package com.devFabricio.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devFabricio.movieflix.dto.ReviewDTO;
import com.devFabricio.movieflix.entities.Movie;
import com.devFabricio.movieflix.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public ResponseEntity<Page<Movie>> getAllMovies(Pageable pageable) {
		Page<Movie> movies = movieService.findAllMovies(pageable);
		return ResponseEntity.ok(movies);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		return ResponseEntity.ok(movie);
	}

	@GetMapping("/genre")
	public ResponseEntity<Page<Movie>> getMoviesByGenre(@RequestParam String genre, Pageable pageable) {
		Page<Movie> movies = movieService.findMoviesByGenre(genre, pageable);
		return ResponseEntity.ok(movies);
	}

	@GetMapping("/{movieId}/reviews")
	public ResponseEntity<Page<ReviewDTO>> getReviewsByMovieId(@PathVariable Long movieId, Pageable pageable) {
		Page<ReviewDTO> reviews = movieService.findReviewsByMovieId(movieId, pageable).map(ReviewDTO::new);
		return ResponseEntity.ok(reviews);
	}

	@PostMapping("/{movieId}/reviews")
	public ResponseEntity<ReviewDTO> addReview(@PathVariable Long movieId, @RequestBody String text) {
		ReviewDTO review = new ReviewDTO(movieService.addReview(movieId, text));
		return ResponseEntity.ok(review);
	}

}
