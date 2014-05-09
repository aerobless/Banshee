package ch.theowinter.banshee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import ch.theowinter.banshee.utilities.WebUtility;
import ch.theowinter.banshee.weather.WeatherManager;

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
	public void readWeatherXMLTest(){
		WebUtility webutil = new WebUtility();
		WeatherManager weather = new WeatherManager();
		String result = null;
		try {
			result = webutil.webToString(weather.buildWeatherURL());
			weather.parseWeatherXML(result);
		} catch (IOException anEx) {
			anEx.printStackTrace();
		} catch (SAXException anEx) {
			// TODO Auto-generated catch block
			anEx.printStackTrace();
		} catch (ParserConfigurationException anEx) {
			// TODO Auto-generated catch block
			anEx.printStackTrace();
		}
	}
	
	public void testLog(String message, boolean indent){
		if(indent){
			System.out.println("  - "+message);
		}else{
			System.out.println(message);
		}
	}
}
