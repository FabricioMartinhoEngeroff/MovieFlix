package com.devFabricio.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devFabricio.movieflix.dto.ReviewDTO;
import com.devFabricio.movieflix.entities.Movie;
import com.devFabricio.movieflix.entities.Review;
import com.devFabricio.movieflix.repositories.MovieRepository;
import com.devFabricio.movieflix.repositories.ReviewRepository;
import com.devFabricio.movieflix.services.exceptions.ResourceNotFoundExceptions;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private MovieRepository movieRepository;

	public ReviewDTO addReview(Long movieId, ReviewDTO reviewDto) {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundExceptions("Movie not found"));
		Review review = new Review();
		review.setMovie(movie);
		review.setText(reviewDto.getText());
		review = reviewRepository.save(review);
		return new ReviewDTO(review);
	}
}
