package com.blz.hotelreservationsystem.model;

public class Hotel {
	enum customer {
		REGULAR, REWARD;
	}

	private String hotelName;
	private int weekRateForRegular;
	private int weekendRateForRegular;
	private long totalPrice;
	private int rating;

	// Constructors
	public Hotel(String hotelName, int weekRateForRegular, int weekendRateForRegular, int rating) {
		this.hotelName = hotelName;
		this.weekRateForRegular = weekRateForRegular;
		this.weekendRateForRegular = weekendRateForRegular;
		this.rating=rating;
	}

	// Getters and Setters

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekRateForRegular() {
		return weekRateForRegular;
	}

	public void setWeekRateForRegular(int weekRateForRegular) {
		this.weekRateForRegular = weekRateForRegular;
	}

	public int getWeekendRateForRegular() {
		return weekendRateForRegular;
	}

	public void setWeekendRateForRegular(int weekendRateForRegular) {
		this.weekendRateForRegular = weekendRateForRegular;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekRateForRegular=" + weekRateForRegular
				+ ", weekendRateForRegular=" + weekendRateForRegular + ", rating=" + rating + "]";
	}
}