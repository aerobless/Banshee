package ch.theowinter.banshee.weather;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ch.theowinter.banshee.Logger;

public class WeatherManager {
	private final static String SEARCH_URL = "http://api.wetter.com/forecast/weather";
	private final static String PROJECT_NAME = "banshee";
	private final static String API_KEY = "eff00651d20075bef02b0e95dd0aa40e";
	private final static String CITY_CODE = "CH0CH1894";

	public String buildWeatherURL(){
		String result = null;
		try {
			String urlMd5 = MD5(PROJECT_NAME+API_KEY+CITY_CODE);
			result = SEARCH_URL+"/city/"+CITY_CODE+"/project/"+PROJECT_NAME+"/cs/"+urlMd5;
		} catch (NoSuchAlgorithmException e) {
			Logger.log("MD5 algorithm not found",e);
		} catch (UnsupportedEncodingException e) {
			Logger.log("UTF8 encoding not supported",e);
		}
		return result;
	}
	
	public String MD5(String md5) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	    java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	    byte[] array = md.digest(md5.getBytes("UTF-8"));
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < array.length; ++i) {
	      sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	    }
	    return sb.toString();
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
