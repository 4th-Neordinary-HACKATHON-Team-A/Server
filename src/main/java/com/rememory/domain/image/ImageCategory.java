package com.rememory.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageCategory extends JpaRepository<Image,Long> {
}