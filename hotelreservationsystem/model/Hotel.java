package com.blz.hotelreservationsystem.model;

public class Hotel {
	enum customer {
		REGULAR, REWARD;
	}

	private String hotelName;
	private int weekRateForRegular;
	private int weekendRateForRegular;
	private int weekRateForRewardCustomer;
	private int weekendRateForRewardCustomer;
	private long totalPrice;
	private int rating;

	//Parameterized Constructor
	public Hotel(String hotelName, int weekRateForRegular, int weekendRateForRegular, int weekRateForRewardCustomer,
			int weekendRateForRewardCustomer, int rating) {
		this.hotelName = hotelName;
		this.weekRateForRegular = weekRateForRegular;
		this.weekendRateForRegular = weekendRateForRegular;
		this.weekRateForRewardCustomer = weekRateForRewardCustomer;
		this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
		this.rating = rating;
	}

	//Getters and setters
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

	public int getWeekRateForRewardCustomer() {
		return weekRateForRewardCustomer;
	}

	public void setWeekRateForRewardCustomer(int weekRateForRewardCustomer) {
		this.weekRateForRewardCustomer = weekRateForRewardCustomer;
	}

	public int getWeekendRateForRewardCustomer() {
		return weekendRateForRewardCustomer;
	}

	public void setWeekendRateForRewardCustomer(int weekendRateForRewardCustomer) {
		this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekRateForRegular=" + weekRateForRegular
				+ ", weekendRateForRegular=" + weekendRateForRegular + ", weekRateForRewardCustomer="
				+ weekRateForRewardCustomer + ", weekendRateForRewardCustomer=" + weekendRateForRewardCustomer
				+ ", rating=" + rating + "]";
	}
	

}