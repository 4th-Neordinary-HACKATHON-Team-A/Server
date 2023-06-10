package com.rememory.service;

import com.rememory.domain.image.ImageRepository;
import com.rememory.domain.post.Post;
import com.rememory.domain.post.PostRepository;
import com.rememory.dto.MainDto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MainService {

    private final PostRepository postRepository;

    @Transactional
    public List<MainRequestDto> getMainPage() {
        LocalDateTime now = LocalDateTime.now();
        List<Post> posts = postRepository.findTop10ByOrderByCreatedAtDesc();

        return posts.stream()
                .map(m -> new MainRequestDto(
                        m.getId(), m.getUser().getNickname(),
                        m.getTitle(), m.getCategory().getName(),
                        m.getImage().getImageSrc(),
                        (int) Duration.between(m.getCreatedAt().toLocalTime(), now).toMinutes()))
                .collect(Collectors.toList());
    }
}
