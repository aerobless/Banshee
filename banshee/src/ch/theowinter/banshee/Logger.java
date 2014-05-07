package ch.theowinter.banshee;

public final class Logger {
	
	public static final void log(String message){
		log(message, null);
	}
	
	public static final void log(String message, Exception e){
		System.out.println(message);
		
	}
}
