package com.webServerProject.SpringProject1.PromotionsAndDiscountsServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webServerProject.SpringProject1.AgsMovieManagementServices.AgsBookingDetailsResponse;
import com.webServerProject.SpringProject1.PvrMovieManagementService.PvrBookingDetailsResponse;

@Service
public class PromotionsAndDiscountServices {
	static int couponPrice = 100;

	public PvrBookingDetailsResponse applyPromoCodeForPvr(PvrBookingDetailsResponse pvrBookingDetailsResponse) {
		int normalPrice = pvrBookingDetailsResponse.getTicketPrice();
		int discountPrice;
		if (normalPrice > 300) {
			discountPrice = normalPrice - couponPrice;
		} else {
			System.out.println("Coupon not eligible for this Booking");
			discountPrice = normalPrice;
		}
		pvrBookingDetailsResponse.setTicketPrice(discountPrice);
		return pvrBookingDetailsResponse;
	}
	
	public AgsBookingDetailsResponse applyPromoCodeForAgs(AgsBookingDetailsResponse agsBookingDetailsResponse) {
		int normalPrice = agsBookingDetailsResponse.getTicketPrice();
		int discountPrice;
		if (normalPrice > 300) {
			discountPrice = normalPrice - couponPrice;
		} else {
			System.out.println("Coupon not eligible for this Booking");
			discountPrice = normalPrice;
		}
		agsBookingDetailsResponse.setTicketPrice(discountPrice);
		return agsBookingDetailsResponse;
	}

	public List<String> getAvailablePromotions() {
		List<String> activePromotions = new ArrayList<String>();
		activePromotions.add("Company Name : Coke || Promotion : 20% offer on next booking");
		activePromotions.add("Company Name : Pepsi || Promotion : 30% offer on next booking ");
		activePromotions.add("Company Name : EnjoyPopcorn || Promotion : 25% offer on next booking");
		activePromotions.add("Company Name : Sofa thambi furniure || Promotion : 35% offer on next booking");
		activePromotions.add("Company Name : KFC || Promotion : 40% offer on next booking");
		return activePromotions;
	}
}
