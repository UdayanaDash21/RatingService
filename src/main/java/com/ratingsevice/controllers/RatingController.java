package com.ratingsevice.controllers;


import com.ratingsevice.entites.Rating;
import com.ratingsevice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //create
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
   public  ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return  ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //Get all
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAutority('Admin')")
    @GetMapping
    public ResponseEntity<List<Rating>> getRating(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    //Get all by User Id
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingUserId(@PathVariable(value = "userId") String userId){
        return ResponseEntity.ok(ratingService.getRatingUserId(userId));
    }

    //Get all by Hotel Id
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
