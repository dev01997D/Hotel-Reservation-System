package com.blz.hotelreservationsystem.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.blz.hotelreservationsystem.model.Hotel;
import com.blz.hotelreservationsystem.model.HotelLogBook;

public class HotelReservationMain {
	private static final Scanner SC = new Scanner(System.in);
	static HotelLogBook hotelLog = new HotelLogBook();
	static LocalDateTime now = LocalDateTime.now();
	static SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");

	// Adding hotel details for regular customer
	private static void addHotelWithRegularCustomerPrice() {
		Hotel lakeWood = new Hotel("LakeWood", 110, 90, 80, 80, 3);
		Hotel bridgeWood = new Hotel("BridgeWood", 160, 40, 110, 50, 4);
		Hotel ridgeWood = new Hotel("RidgeWood", 220, 150, 100, 40, 5);
		hotelLog.addHotelToHotelLogBook(lakeWood);
		hotelLog.addHotelToHotelLogBook(bridgeWood);
		hotelLog.addHotelToHotelLogBook(ridgeWood);

		hotelLog.getHotelBook().stream().forEach((hotel) -> System.out.println(hotel));
		;
	}

	// Adding hotel details for reward customer
	private static void addHotelWithRewardCustomerPrice() {
	}

	// Find Cheapest hotel for given date range
	private static Hotel cheapestHotelForRegularCustomer(String dateStart, String dateEnd) throws Exception {
		Date startDate = formatter.parse(dateStart);
		Date endDate = formatter.parse(dateEnd);
		long dateRange = 1 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24; // Convert the difference
																								// into days
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int weekDays = 0;
		do {
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++weekDays;
			}
			startCal.add(Calendar.DAY_OF_MONTH, 1);
		} while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

		long weekends = dateRange - weekDays;
		for (Hotel hotel : hotelLog.getHotelBook()) {
			long totalPrice = hotel.getWeekRateForRegular() * weekDays + hotel.getWeekendRateForRegular() * weekends;
			hotel.setTotalPrice(totalPrice);
		}

		List<Hotel> bestRatedHotelList = hotelLog.getHotelBook().stream()
				.sorted(Comparator.comparing(Hotel::getRating).reversed()).collect(Collectors.toList());
		Hotel cheapHotel = bestRatedHotelList.get(0); // Initialize to highest rated hotel
		long lowestPrice = bestRatedHotelList.get(0).getTotalPrice();
		int rating = bestRatedHotelList.get(0).getRating();

		for (Hotel hotel : hotelLog.getHotelBook()) {
			if (hotel.getTotalPrice() < lowestPrice && hotel.getRating() >= rating)
				cheapHotel = hotel;
		}
		return cheapHotel;
	}

	public static void main(String[] args) {
		// UC 1 & UC3 & UC5 & UC9
		System.out.println("Welcome to Hotel Reservation!");
		addHotelWithRegularCustomerPrice();
		addHotelWithRewardCustomerPrice();

		// UC2 & UC4 & UC6 & UC7
		System.out.println("Enter the check in date in ddMMMYYYY format");
		String startDate = SC.next();
		System.out.println("Enter the check out date in ddMMMYYYY format");
		String endDate = SC.next();
		Hotel cheapHotel;
		try {
			cheapHotel = cheapestHotelForRegularCustomer(startDate, endDate);
			System.out.println("Hotel Name : " + cheapHotel.getHotelName() + ", Rating : " + cheapHotel.getRating()
					+ ", And Total rate is $ " + cheapHotel.getTotalPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
