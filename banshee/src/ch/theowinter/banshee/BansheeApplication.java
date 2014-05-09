package ch.theowinter.banshee;

public class BansheeApplication {

	public static void main(String[] args) {
		System.out.println("Application works");
		BansheeInterpreter banshee = new BansheeInterpreter();
		banshee.announceGreeting();
		banshee.announceWeather();

	}
}
