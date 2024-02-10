package com.example.exercise_masarat.Service;

import com.example.exercise_masarat.Model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    private final String POSTS_API_URL = "http://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public  List<Post> getPosts() throws IOException {
        String jsonResponse = restTemplate.getForObject(POSTS_API_URL, String.class);
        return Arrays.asList(objectMapper.readValue(jsonResponse, Post[].class));
    }


//    public String getPosts() {
//        return restTemplate.getForObject(POSTS_API_URL, String.class);
//    }
}
