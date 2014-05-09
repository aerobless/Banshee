package ch.theowinter.banshee;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
	
}
