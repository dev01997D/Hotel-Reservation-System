package com.blz.hotelreservationsystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import com.blz.hotelreservationsystem.model.Hotel;
import com.blz.hotelreservationsystem.model.HotelLogBook;

public class HotelReservationMain {
	private static final Scanner SC = new Scanner(System.in);
	static HotelLogBook hotelLog = new HotelLogBook();
	static LocalDateTime now = LocalDateTime.now();
	static SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");

	// Adding hotel details for regular customer
	private static void addHotelWithRegularCustomerPrice() {
		Hotel lakeWood = new Hotel("LakeWood", 110, 90);
		Hotel bridgeWood = new Hotel("BridgeWood", 160, 50);
		Hotel ridgeWood = new Hotel("RidgeWood", 220, 150);
		hotelLog.addHotelToHotelLogBook(lakeWood);
		hotelLog.addHotelToHotelLogBook(bridgeWood);
		hotelLog.addHotelToHotelLogBook(ridgeWood);

		hotelLog.getHotelBook().stream().forEach((hotel) -> System.out.println(hotel));
		;
	}

	// Find Cheapest hotel for given date range
	private static Hotel cheapestHotelForRegularCustomer(String dateStart, String dateEnd) throws Exception {
		Date startDate = formatter.parse(dateStart);
		Date endDate = formatter.parse(dateEnd);
		long dateRange = 2 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24; // Convert the difference
																								// into days
		Hotel cheapestHotel = hotelLog.getHotelBook().stream().sorted(Comparator.comparing(Hotel::getWeekRate))
				.findFirst().orElse(null);
		long totalPrice = dateRange * cheapestHotel.getWeekRate();
		cheapestHotel.setTotalPrice(totalPrice);
		return cheapestHotel;
	}

	public static void main(String[] args) {
		// UC 1
		System.out.println("Welcome to Hotel Reservation!");
		addHotelWithRegularCustomerPrice();

		// UC2
		System.out.println("Enter the check in date in ddMMMYYYY format");
		String startDate = SC.next();
		System.out.println("Enter the check out date in ddMMMYYYY format");
		String endDate = SC.next();
		Hotel cheapHotel;
		try {
			cheapHotel = cheapestHotelForRegularCustomer(startDate, endDate);
			System.out.println(cheapHotel.getHotelName() + "'s total rate is $ " + cheapHotel.getTotalPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//UC3 
	}
}
