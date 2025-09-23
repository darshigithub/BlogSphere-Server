package com.example.demo.dto;

import com.example.demo.model.Blog;

public class BlogDTO {
    private Long id;
    private String title;
    private String content;
    private Long userId;

    public BlogDTO(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.userId = blog.getUser().getId();
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Long getUserId() { return userId; }
}
