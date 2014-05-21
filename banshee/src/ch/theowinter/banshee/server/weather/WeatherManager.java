package ch.theowinter.banshee.server.weather;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ch.theowinter.banshee.server.utilities.WebUtility;
import ch.theowinter.banshee.shared.Logger;

public class WeatherManager {
	//Settings (will probably be moved to their own settings class sometime)
	private final static String SEARCH_URL = "http://api.wetter.com/forecast/weather";
	private final static String PROJECT_NAME = "banshee";
	private final static String API_KEY = "eff00651d20075bef02b0e95dd0aa40e";
	private final static String CITY_CODE = "CH0CH3201";
	
	//Containers
	private Map<String, WeatherSnapshot> weatherMap;
	
	//Tools
	ch.theowinter.banshee.server.utilities.WebUtility webUtil;
	
	/**
	 * Creates a new instance of this class.
	 *
	 * @param aWeatherMap
	 */
	public WeatherManager() {
		super();
		webUtil = new WebUtility();
		weatherMap = new HashMap<String, WeatherSnapshot>();
		
		//Run last:
		updateWeather();
	}
	
	/**
	 * Update the weather data stored in your instance of
	 * WeatherManager.
	 */
	public void updateWeather(){
		String weatherURL = buildWeatherURL();
		try {
			weatherMap = parseXMLToWeatherMap(webUtil.webToString(weatherURL));
		} catch (IOException e) {
			Logger.log("IOException while trying to update the weather in the WeatherManager.", e);
		} catch (SAXException e) {
			Logger.log("SAXException while trying to update the weather in the WeatherManager.", e);
		} catch (ParserConfigurationException e) {
			Logger.log("ParserConfigurationException while trying to update the weather in the WeatherManager.", e);
		}
	}

	/**
	 * Create the URL to get XML-weather information from
	 * wetter.com.
	 *
	 * @return URL
	 */
	public String buildWeatherURL(){
		String result = null;
		try {
			String urlMd5 = webUtil.MD5(PROJECT_NAME+API_KEY+CITY_CODE);
			result = SEARCH_URL+"/city/"+CITY_CODE+"/project/"+PROJECT_NAME+"/cs/"+urlMd5;
		} catch (NoSuchAlgorithmException e) {
			Logger.log("MD5 algorithm not found",e);
		} catch (UnsupportedEncodingException e) {
			Logger.log("UTF8 encoding not supported",e);
		}
		return result;
	}
	
	/**
	 * Create a weatherMap from an XML-String containing weather data.
	 *
	 * @param input
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public Map<String, WeatherSnapshot> parseXMLToWeatherMap(String input) throws SAXException, IOException, ParserConfigurationException{
		InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(stream);
		
		Map<String, WeatherSnapshot> localWeatherMap = new HashMap<String, WeatherSnapshot>();
		
		for(int i=0; i<document.getElementsByTagName("time").getLength(); i++){
			NodeList timeNode = document.getElementsByTagName("time").item(i).getChildNodes();
			String locationName = document.getElementsByTagName("name").item(0).getTextContent();
			String cityCode = document.getElementsByTagName("city_code").item(0).getTextContent();
			String snapshotTime = document.getElementsByTagName("time").item(i).getAttributes().item(0).getTextContent();
			int maxTemperature = Integer.parseInt(timeNode.item(3).getTextContent());
			int minTemperature = Integer.parseInt(timeNode.item(5).getTextContent());
			int weatherType = Integer.parseInt(timeNode.item(1).getTextContent());
			localWeatherMap.put(snapshotTime, new WeatherSnapshot(locationName, cityCode, snapshotTime, maxTemperature, minTemperature, weatherType));	
		}
		return localWeatherMap;
	}
	
	
	/**
	 * Get a weatherSnapshot containing min temperature, max temperature and
	 * weather type for a specific time. Please note that only the following key-times
	 * are indexed: 06:00, 11:00, 17:00, 23:00 any other requested time will return null.
	 *
	 * @param time
	 * @return WeatherSnapshot
	 */
	public WeatherSnapshot getWeatherFor(String time){
		return weatherMap.get(time);
	}
}
