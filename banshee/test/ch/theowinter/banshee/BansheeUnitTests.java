package ch.theowinter.banshee;

import static org.junit.Assert.*;

import org.junit.Test;

public class BansheeUnitTests {

	@Test
	public void initalTest(){
		System.out.println("testing works.");
	}
	
	@Test
	public void speakTest(){
		TextToSpeech ttsEngine = new TextToSpeech();
		assertTrue(ttsEngine.speak("Test successful"));
		assertTrue(ttsEngine.speak("sadfasdfasdfsadfsdfasdf"));
		assertTrue(ttsEngine.speak("Hello world this is a long string."));
	}
	

}
