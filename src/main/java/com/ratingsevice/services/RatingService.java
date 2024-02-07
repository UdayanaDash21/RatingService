package com.ratingsevice.services;

import com.ratingsevice.entites.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);


    //get all
    List<Rating> getRatings();

    //Get all rating by user id
    List<Rating> getRatingUserId (String userId);

    //Get all by hotel id
    List<Rating> getRatingByHotelId(String hotelId);

}
