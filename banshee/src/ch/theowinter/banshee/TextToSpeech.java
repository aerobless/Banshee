package ch.theowinter.banshee;

import java.io.IOException;

public class TextToSpeech {
	
	/**
	 * Speak a string using the default tts engine of your
	 * operating system.
	 * 
	 * @param message
	 */
    public boolean speak(String message){
    	boolean success = false;
        String [] speak = new String[]{"say", message};
        Runtime rtSpeak = Runtime.getRuntime();
        try {
			rtSpeak.exec(speak);
			success=true;
		} catch (IOException e) {
			Logger.log("IOException when trying to run shell tts", e);
		}
        return success;
    }
}
