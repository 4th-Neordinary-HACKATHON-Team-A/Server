package com.rememory.domain.post;

import com.rememory.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategory(Category category);
}
