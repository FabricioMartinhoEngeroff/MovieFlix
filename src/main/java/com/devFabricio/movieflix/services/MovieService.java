package com.devFabricio.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devFabricio.movieflix.entities.Movie;
import com.devFabricio.movieflix.entities.Review;
import com.devFabricio.movieflix.entities.User;
import com.devFabricio.movieflix.repositories.MovieRepository;
import com.devFabricio.movieflix.repositories.ReviewRepository;
import com.devFabricio.movieflix.services.exceptions.ResourceNotFoundExceptions;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public Page<Movie> findAllMovies(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Movie findMovieById(Long id) {
		return movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("Movie not found with id: " + id));
	}

	@Transactional(readOnly = true)
	public Page<Movie> findMoviesByGenre(String genre, Pageable pageable) {
		return movieRepository.findByGenre(genre, pageable);
	}

	@Transactional(readOnly = true)
	public Page<Review> findReviewsByMovieId(Long movieId, Pageable pageable) {
		return reviewRepository.findByMovieId(movieId, pageable);
	}

	@Transactional
	public Review addReview(Long movieId, String text) {
		Movie movie = movieRepository.findById(movieId).orElseThrow();
		User user = authService.authenticated();
		Review review = new Review(null, text, user, movie);
		return reviewRepository.save(review);
	}

}
