package ch.theowinter.banshee.weather;

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
import org.xml.sax.SAXException;

import ch.theowinter.banshee.Logger;
import ch.theowinter.banshee.utilities.WebUtility;

public class WeatherManager {
	//Settings (will probably be moved to their own settings class sometime)
	private final static String SEARCH_URL = "http://api.wetter.com/forecast/weather";
	private final static String PROJECT_NAME = "banshee";
	private final static String API_KEY = "eff00651d20075bef02b0e95dd0aa40e";
	private final static String CITY_CODE = "CH0CH1894";
	
	//Containers
	private Map<String, WeatherSnapshot> weatherMap;
	
	//Tools
	WebUtility webUtil;
	
	/**
	 * Creates a new instance of this class.
	 *
	 * @param aWeatherMap
	 */
	public WeatherManager() {
		super();
		weatherMap = new HashMap<String, WeatherSnapshot>();
		webUtil = new WebUtility();
	}

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
	
	public void parseWeatherXML(String input) throws SAXException, IOException, ParserConfigurationException{
		InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(stream);
		
		System.out.println(document.getElementsByTagName("city_code").item(0).getTextContent());
		System.out.println(document.getElementsByTagName("tx").item(1).getTextContent());
	}
}
