package com.deepakshankar.posts.repository;

import com.deepakshankar.posts.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionDAO extends JpaRepository<Reaction, Long> {
}
