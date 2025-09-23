package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable; 
import org.springframework.stereotype.Service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;

@Service
public class BlogService {
	
    @Autowired 
    BlogRepository blogRepository; 
    
    public Blog createBlog(Blog blog){ 
    	return blogRepository.save(blog); 
    }
    
    public Page<Blog> getAllBlogs(Pageable pageable){ 
    	return blogRepository.findAll(pageable); 
    }
    
    public Blog getBlogById(Long id){ 
    	return blogRepository.findById(id).orElse(null); 
    }
    
    public void deleteBlog(Long id){ 
    	blogRepository.deleteById(id); 
    }
}
