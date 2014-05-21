package ch.theowinter.banshee.server;


public class BansheeServer {

	public static void main(String[] args) {
		System.out.println("Application works");
		BansheeInterpreter banshee = new BansheeInterpreter();
		banshee.announceGreeting();
		banshee.announceWeather();

	}
}
