package com.rememory.domain.post;

import com.rememory.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDateTime;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findTop10ByOrderByCreatedAtDesc();
  
    List<Post> findByCategory(Category category);
}
