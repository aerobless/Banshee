package ch.theowinter.banshee;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.theowinter.banshee.weather.WeatherManager;
import ch.theowinter.banshee.weather.WeatherSnapshot;
import ch.theowinter.banshee.weather.WeatherTypes;

public class BansheeInterpreter {
	WeatherManager weather;
	TextToSpeech voice;

	BansheeInterpreter() {
		super();
		weather = new WeatherManager();
		voice = new TextToSpeech();	
	}
	
	public void announceWaker(){
		voice.speak("Good morning.");
		voice.speak("It's "+simpleTimeString());
	}

	public void announceWeather(){
		weather.updateWeather();
		WeatherSnapshot morning = weather.getWeatherFor("06:00");
		WeatherSnapshot midday = weather.getWeatherFor("11:00");
		WeatherSnapshot afternoon = weather.getWeatherFor("17:00");
		WeatherSnapshot night = weather.getWeatherFor("23:00");
		WeatherSnapshot current = null;
		
		//Set current weather
		if(currentHour()>3 && currentHour()<=9){
			current = morning;
		} else if (currentHour()<=14) {
			current = midday;
		} else if (currentHour()<=20) {
			current = afternoon;
		} else {
			current = night;
		}
		
		int averageTemp = (current.getMaxTemperature()+current.getMinTemperature())/2;
		voice.speak("The weather in Rah-ppersvil is "+averageTemp+" degrees.");
		voice.speak("It is currently "+WeatherTypes.weatherTypes.get(current.getWeatherType()));
		voice.speak("and it will be "+WeatherTypes.weatherTypes.get(afternoon.getWeatherType())+"when you get home from school.");
	}
	
	/**
	 * Returns a simple time string with the format
	 * hh:mm
	 *
	 * @return timeString
	 */
	public String simpleTimeString(){
		SimpleDateFormat timingFormat = new SimpleDateFormat("HH:mm");
		return timingFormat.format(new Date());
	}
	
	public int currentHour(){
		String currentTime = simpleTimeString();
		return Integer.parseInt(currentTime.substring(0, 2));
	}
}
