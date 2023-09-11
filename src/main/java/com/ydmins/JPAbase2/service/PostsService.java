package com.ydmins.JPAbase2.service;

import com.ydmins.JPAbase2.domain.posts.Posts;
import com.ydmins.JPAbase2.domain.posts.PostsRepository;
import com.ydmins.JPAbase2.web.dto.PostsResponseDto;
import com.ydmins.JPAbase2.web.dto.PostsSaveRequestDto;
import com.ydmins.JPAbase2.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("행당 게시글이 존재하지 않습니다. " +
                "id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 존재하지 않슷빈다." +
                " id="+id));
        return new PostsResponseDto(entity);
    }
}
