package com.rememory.repository;

import com.rememory.domain.post.Post;
import com.rememory.domain.post.PostRepository;
import com.rememory.domain.user.User;
import com.rememory.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원을 등록한다")
    void saveUser() {
        //given
        String nickname = "닉네임1";
        LocalDateTime now = LocalDateTime.of(2023,6,10,0,0,0);

        userRepository.save(User.builder()
                .nickname(nickname)
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);

        assertAll(
                () -> assertThat(user.getNickname()).isEqualTo("닉네임1"),
                () -> assertThat(user.getCreatedDate()).isAfter(now)
        );
    }
}
