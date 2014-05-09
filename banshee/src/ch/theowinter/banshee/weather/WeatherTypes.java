package ch.theowinter.banshee.weather;

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
		weatherTypeMap.put(4, "fog");
		weatherTypeMap.put(5, "drizzel rain");
		weatherTypeMap.put(6, "rain");
		weatherTypeMap.put(7, "snow");
		weatherTypeMap.put(8, "shower");
		weatherTypeMap.put(9, "storm");
		weatherTypeMap.put(10, weatherTypeMap.get(1));
		weatherTypeMap.put(20, weatherTypeMap.get(2));
		weatherTypeMap.put(30, weatherTypeMap.get(3));
		weatherTypeMap.put(40, weatherTypeMap.get(4));
		weatherTypeMap.put(45, weatherTypeMap.get(4));
		weatherTypeMap.put(48, "fog with rime formation");
		weatherTypeMap.put(49, weatherTypeMap.get(48));
		weatherTypeMap.put(50, weatherTypeMap.get(5));
		weatherTypeMap.put(51, "slight drizzel rain");
		weatherTypeMap.put(53, weatherTypeMap.get(5));
		weatherTypeMap.put(55, "strong drizzel rain");
		weatherTypeMap.put(56, "slight drizzel rain, freezing");
		weatherTypeMap.put(57, "strong drizzel rain, freezing");
		weatherTypeMap.put(60, "light rain");
		weatherTypeMap.put(61, weatherTypeMap.get(60));
		weatherTypeMap.put(63, "moderate rain");
		weatherTypeMap.put(65, "strong rain");
		weatherTypeMap.put(66, "light rain, freezing");
		weatherTypeMap.put(67, "moderate or strong rain, freezing");
		weatherTypeMap.put(68, "light snow-rain");
		weatherTypeMap.put(69, "strong snow-rain");
		weatherTypeMap.put(70, "light snowfall");
		weatherTypeMap.put(71, weatherTypeMap.get(70));
		weatherTypeMap.put(73, "moderate snowfall");
		weatherTypeMap.put(75, "strong snowfall");
		weatherTypeMap.put(80, "light rain - shower");
		weatherTypeMap.put(81, "rain - shower");
		weatherTypeMap.put(82, "strong rain - shower");
		weatherTypeMap.put(83, "light snowfall - rain shower");
		weatherTypeMap.put(84, "strong snowfall - rain shower");
		weatherTypeMap.put(85, "light snow - shower");
		weatherTypeMap.put(86, "moderate oder strong snowfall - shower");
		weatherTypeMap.put(90, "storm");
		weatherTypeMap.put(95, "light storm");
		weatherTypeMap.put(96, "strong storm");
		weatherTypeMap.put(999, "no data");
		return weatherTypeMap;
	}
}
