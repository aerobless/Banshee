package ch.theowinter.banshee.shared;

public final class Logger {
	
	public static final void log(String message){
		log(message, null);
	}
	
	public static final void log(String message, Exception e){
		System.out.println(message);
		
	}
}
