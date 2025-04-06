package com.example.httpinterface.dto;

import lombok.Getter;

@Getter
public class Post {

    private Long id;
    private String title;
    private String body;
    private Long userId;

}
