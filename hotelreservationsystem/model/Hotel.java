package com.blz.hotelreservationsystem.model;

public class Hotel {
	enum customer {
		REGULAR, REWARD;
	}

	private String hotelName;
	private int weekRate;
	private long totalPrice;

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

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


	public Hotel(String hotelName, int weekRate) {
		this.hotelName = hotelName;
		this.weekRate = weekRate;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekRate=" + weekRate + "]";
	}
}