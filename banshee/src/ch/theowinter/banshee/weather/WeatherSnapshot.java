package ch.theowinter.banshee.weather;

import java.util.Date;

public class WeatherSnapshot {
	//Meta
	private String locationName;
	private String cityCode;
	private String snapshotTime;
	
	//Data
	private int maxTemperature;
	private int minTemperature;
	private int weatherType;
	
	//Control
	private Date creationDate;

	/**
	 * Creates a new instance of this class.
	 *
	 * @param aLocationName
	 * @param aCityCode
	 * @param aSnapshotTime
	 * @param aMaxTemperature
	 * @param aMinTemperature
	 * @param aWeatherType
	 */
	WeatherSnapshot(String aLocationName, String aCityCode,
			String aSnapshotTime, int aMaxTemperature, int aMinTemperature,
			int aWeatherType) {
		super();
		locationName = aLocationName;
		cityCode = aCityCode;
		snapshotTime = aSnapshotTime;
		maxTemperature = aMaxTemperature;
		minTemperature = aMinTemperature;
		weatherType = aWeatherType;
		creationDate = new Date();
	}

	/**
	 * @return the locationName
	 */
	public final String getLocationName() {
		return locationName;
	}

	/**
	 * @return the cityCode
	 */
	public final String getCityCode() {
		return cityCode;
	}

	/**
	 * @return the snapshotTime
	 */
	public final String getSnapshotTime() {
		return snapshotTime;
	}

	/**
	 * @return the maxTemperature
	 */
	public final int getMaxTemperature() {
		return maxTemperature;
	}

	/**
	 * @return the minTemperature
	 */
	public final int getMinTemperature() {
		return minTemperature;
	}

	/**
	 * @return the weatherType
	 */
	public final int getWeatherType() {
		return weatherType;
	}

	/**
	 * @return the creationDate
	 */
	public final Date getCreationDate() {
		return creationDate;
	}
	
}
