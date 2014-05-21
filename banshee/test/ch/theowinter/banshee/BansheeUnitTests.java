package ch.theowinter.banshee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import ch.theowinter.banshee.server.TextToSpeech;
import ch.theowinter.banshee.server.utilities.WebUtility;
import ch.theowinter.banshee.server.weather.WeatherManager;
import ch.theowinter.banshee.server.weather.WeatherSnapshot;

public class BansheeUnitTests {

	@Test
	public void initalTest(){
		System.out.println("Test results:");
	}
	
	/**
	 * Actual sound output, enable when required to test. 
	 */
	@Test
	public void speakTest(){
		TextToSpeech ttsEngine = new TextToSpeech();
		ttsEngine.hashCode();
		//assertTrue(ttsEngine.speak("Test successful"));
	}
	
	@Test
	public void md5CalculationTest(){
		ch.theowinter.banshee.server.utilities.WebUtility webutil = new WebUtility();
		String md5 = null;
		try {
			md5 = webutil.MD5("bansheeeff00651d20075bef02b0e95dd0aa40eCH0CH1894");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertEquals("68d3a19b46d79faccd4c8cbbbdbcca10", md5);
	}
	
	@Test
	public void buildWeatherURLTest(){
		WeatherManager weather = new WeatherManager();
		String weatherURL = weather.buildWeatherURL();
		testLog(weatherURL, true);
		String expectedURL = "http://api.wetter.com/forecast/weather/city/CH0CH3201/project/banshee/cs/06efa06c37845169cd219a85f220f4c5";
		assertEquals(expectedURL, weatherURL);
	}
	
	@Test
	public void websiteDownloadToStringTest(){
		WebUtility webutil = new WebUtility();
		String result = null;
		try {
			result = webutil.webToString("http://google.com");
		} catch (IOException anEx) {
			anEx.printStackTrace();
		}
		assertTrue(result.length()>150);
	}
	
	@Test
	public void weatherManagerTest(){
		WeatherManager weatherManager = new WeatherManager();
		WeatherSnapshot weather0600 = weatherManager.getWeatherFor("06:00");
		WeatherSnapshot weather1100 = weatherManager.getWeatherFor("11:00");
		assertEquals("06:00", weather0600.getSnapshotTime());
		assertEquals("11:00", weather1100.getSnapshotTime());
		assertTrue(weather0600.getCityCode().length()>1);
		assertTrue(weather1100.getLocationName().length()>1);
		assertTrue(weather0600.getMaxTemperature()>=weather0600.getMinTemperature());
		assertTrue(weather1100.getMaxTemperature()>=weather1100.getMinTemperature());
		assertTrue(weather1100.getWeatherType()>=0);
	}
	
	public void testLog(String message, boolean indent){
		if(indent){
			System.out.println("  - "+message);
		}else{
			System.out.println(message);
		}
	}
}
