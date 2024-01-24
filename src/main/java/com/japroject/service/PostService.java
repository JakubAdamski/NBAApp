package com.japroject.service;

import com.japroject.exception.AssociationNotFoundException;
import com.japroject.exception.UserNotFoundException;
import com.japroject.model.Post;
import com.japroject.repository.AssociationRepository;
import com.japroject.repository.PostRepository;
import com.japroject.repository.UserRepository;
import com.japroject.request.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssociationRepository associationRepository;



    public List<Post> findAllPost(){return postRepository.findAll();}

    public void createPost(PostRequest request){
        var user = userRepository.findById(request.userId);
        var association = associationRepository.findById(request.associationId);

        var post = Post.builder()
                        .user(user.orElseThrow(() -> new UserNotFoundException(request.userId)))
                                .association(association.orElseThrow(() -> new AssociationNotFoundException(request.associationId)))
                                        .content(request.content)
                .data(LocalDateTime.now())
                                                .build();


        postRepository.save(post);

    }
}
