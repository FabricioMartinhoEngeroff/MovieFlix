package com.devFabricio.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devFabricio.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	Page<Movie> findByGenre(String genre, Pageable pageable);
}
