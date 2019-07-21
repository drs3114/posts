package com.deepakshankar.posts.repository;

import com.deepakshankar.posts.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDAO extends JpaRepository<Genre, Long> {
}
