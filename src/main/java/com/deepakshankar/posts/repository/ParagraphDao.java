package com.deepakshankar.posts.repository;

import com.deepakshankar.posts.model.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphDao extends JpaRepository<Paragraph, Long> {
}
