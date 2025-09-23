package com.example.demo.controller;

import com.example.demo.dto.BlogDTO;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        Long userId = blog.getUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        blog.setUser(user);
        return blogRepository.save(blog);
    }

    @GetMapping
    public List<BlogDTO> getAllBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(BlogDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BlogDTO getBlog(@PathVariable Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        return new BlogDTO(blog);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long id) {
        return blogRepository.findById(id)
                .map(blog -> {
                    blogRepository.delete(blog);
                    return ResponseEntity.ok().body("Blog deleted successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
