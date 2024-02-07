package com.ratingsevice.services.Impl;

import com.ratingsevice.entites.Rating;
import com.ratingsevice.repositories.RatingRepository;
import com.ratingsevice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
public class RatingServiceImpl implements RatingService {
@Autowired
   private RatingRepository repository;


    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
