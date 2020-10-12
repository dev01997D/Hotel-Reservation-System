package com.blz.hotelreservationsystem.controller;

import com.blz.hotelreservationsystem.model.Hotel;
import com.blz.hotelreservationsystem.model.HotelLogBook;

public class HotelReservationMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation!");
		
		//Adding hotel details for regular customer
		Hotel lakeWood=new Hotel("LakeWood", 110, 90);
		Hotel bridgeWood=new Hotel("BridgeWood", 160, 60);
		Hotel ridgeWood=new Hotel("RidgeWood", 220, 150);
		HotelLogBook hotelLog=new HotelLogBook();
		hotelLog.addHotelToHotelLogBook(lakeWood);
		hotelLog.addHotelToHotelLogBook(bridgeWood);
		hotelLog.addHotelToHotelLogBook(ridgeWood);

		hotelLog.getHotelBook().stream().forEach((hotel)-> System.out.println(hotel));;
	}
}
