package com.example.httpinterface.client;

import com.example.httpinterface.dto.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange(url = "/posts")
public interface PostHttpClient {

    @GetExchange("/{postId}")
    Post findByPostId(@PathVariable("postId") Long postId);

    @GetExchange
    List<Post> findAll();

    @GetExchange
    List<Post> findAllPagination(@RequestParam("_page") int page);

}
