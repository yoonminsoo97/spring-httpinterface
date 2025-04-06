package com.example.httpinterface.controller;

import com.example.httpinterface.client.PostHttpClient;
import com.example.httpinterface.dto.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final PostHttpClient postHttpClient;

    public HelloController(PostHttpClient postHttpClient) {
        this.postHttpClient = postHttpClient;
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> findByPostId(@PathVariable("postId") Long postId) {
        Post post = postHttpClient.findByPostId(postId);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/v1/posts")
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = postHttpClient.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/v2/posts")
    public ResponseEntity<List<Post>> findAllPagination(@RequestParam("page") int page) {
        List<Post> posts = postHttpClient.findAllPagination(page);
        return ResponseEntity.ok().body(posts);
    }

}
