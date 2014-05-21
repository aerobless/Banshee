package ch.theowinter.banshee.server.weather;

import java.util.HashMap;
import java.util.Map;

public class WeatherTypes {
	public static final Map<Integer, String> weatherTypes = buildWeatherList();
	public static final int[] badWeatherArray = new int[]{6,7,9,50,53,55,56,57,
		60,61,63,67,68,69,73,75,80,81,82,83,84,85,86,90,95,96};
	
	private static final Map<Integer, String> buildWeatherList(){
		Map<Integer, String> weatherTypeMap	= new HashMap<Integer, String>();
		weatherTypeMap.put(0, "sunny");
		weatherTypeMap.put(1, "slightly cloudy");
		weatherTypeMap.put(2, "cloudy");
		weatherTypeMap.put(3, "overcast");
		weatherTypeMap.put(4, "foggy");
		weatherTypeMap.put(5, "drizzling rain");
		weatherTypeMap.put(6, "raining");
		weatherTypeMap.put(7, "snowing");
		weatherTypeMap.put(8, "showering");
		weatherTypeMap.put(9, "storming");
		weatherTypeMap.put(10, weatherTypeMap.get(1));
		weatherTypeMap.put(20, weatherTypeMap.get(2));
		weatherTypeMap.put(30, weatherTypeMap.get(3));
		weatherTypeMap.put(40, weatherTypeMap.get(4));
		weatherTypeMap.put(45, weatherTypeMap.get(4));
		weatherTypeMap.put(48, "foggy and rime is forming");
		weatherTypeMap.put(49, weatherTypeMap.get(48));
		weatherTypeMap.put(50, weatherTypeMap.get(5));
		weatherTypeMap.put(51, "slightly drizzling rain");
		weatherTypeMap.put(53, weatherTypeMap.get(5));
		weatherTypeMap.put(55, "strongly drizzling rain");
		weatherTypeMap.put(56, "slightly drizzling rain and freezing cold");
		weatherTypeMap.put(57, "strongly drizzling rain and freezing cold");
		weatherTypeMap.put(60, "lightly raining");
		weatherTypeMap.put(61, weatherTypeMap.get(60));
		weatherTypeMap.put(63, "moderatly raining");
		weatherTypeMap.put(65, "heavily raining");
		weatherTypeMap.put(66, "lightly raining and freezing cold");
		weatherTypeMap.put(67, "moderatly or strongly raining and freezing cold");
		weatherTypeMap.put(68, "lightly snow-raining");
		weatherTypeMap.put(69, "heavily snow-raining");
		weatherTypeMap.put(70, "lightly snowing");
		weatherTypeMap.put(71, weatherTypeMap.get(70));
		weatherTypeMap.put(73, "moderatly snowing");
		weatherTypeMap.put(75, "strongly snowing");
		weatherTypeMap.put(80, "mostly dry with light rain-showers");
		weatherTypeMap.put(81, "overcast with frequent strong rain-showers");
		weatherTypeMap.put(82, "cloudy with occasional strong rain-showers");
		weatherTypeMap.put(83, "lightly snowing with occasional showers");
		weatherTypeMap.put(84, "heavily snowing with occasional showers");
		weatherTypeMap.put(85, "lightly snowing with occasional showers");
		weatherTypeMap.put(86, "moderatly or heavily snowing with occasional showers");
		weatherTypeMap.put(90, "storming");
		weatherTypeMap.put(95, "lightly storming");
		weatherTypeMap.put(96, "strongly storming");
		weatherTypeMap.put(999, "unknown, because there is not data available");
		return weatherTypeMap;
	}
}
