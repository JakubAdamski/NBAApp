package com.japroject.controller;

import com.japroject.model.Post;
import com.japroject.request.PostRequest;
import com.japroject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    @ResponseBody
    public List<Post> getAllPosts(){return postService.findAllPost();}

    @PostMapping("/addpost")
    public void addPost(@RequestBody PostRequest request){
        postService.createPost(request);
    }
}
