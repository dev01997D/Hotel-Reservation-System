package com.blz.hotelreservationsystem.model;

public class Hotel {
	enum customer {
		REGULAR, REWARD;
	}

	private String hotelName;
	private int weekRate;
	private int weekendRate;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekRate() {
		return weekRate;
	}

	public void setWeekRate(int weekRate) {
		this.weekRate = weekRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	public Hotel(String hotelName, int weekRate, int weekendRate) {
		this.hotelName = hotelName;
		this.weekRate = weekRate;
		this.weekendRate = weekendRate;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekRate=" + weekRate + ", weekendRate=" + weekendRate + "]";
	}
}