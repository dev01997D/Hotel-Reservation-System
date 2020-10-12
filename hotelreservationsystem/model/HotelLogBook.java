package com.blz.hotelreservationsystem.model;

import java.util.ArrayList;

public class HotelLogBook {
	private ArrayList<Hotel> hotelBook = new ArrayList<Hotel>();

	public ArrayList<Hotel> getHotelBook() {
		return this.hotelBook;
	}

	public void setHotelBook(ArrayList<Hotel> addressBook) {
		this.hotelBook = addressBook;
	}

	public void addHotelToHotelLogBook(Hotel hotel) {
		hotelBook.add(hotel);
	}
}
