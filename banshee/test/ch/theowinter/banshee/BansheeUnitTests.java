package ch.theowinter.banshee;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

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
		WeatherManager weather = new WeatherManager();
		String md5 = null;
		try {
			md5 = weather.MD5("bansheeeff00651d20075bef02b0e95dd0aa40eCH0CH1894");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assertEquals("68d3a19b46d79faccd4c8cbbbdbcca10", md5);
	}
	
	@Test
	public void buildWeatherURLTest(){
		WeatherManager weather = new WeatherManager();
		String weatherURL = weather.buildWeatherURL();
		String expectedURL = "http://api.wetter.com/forecast/weather/city/CH0CH1894/project/banshee/cs/68d3a19b46d79faccd4c8cbbbdbcca10";
		assertEquals(expectedURL, weatherURL);
		testLog(weatherURL, true);
	}
	
	public void testLog(String message, boolean indent){
		if(indent){
			System.out.println("  - "+message);
		}else{
			System.out.println(message);
		}
	}
}
