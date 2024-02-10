package com.example.exercise_masarat.Controller;



import com.example.exercise_masarat.Configuration.PaginationUtils;
import com.example.exercise_masarat.Model.Post;
import com.example.exercise_masarat.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    int PAGE_SIZE =10;

    @Autowired
    private PostService postService;



@GetMapping("/api/posts")
public String getPosts(Model model, @RequestParam(defaultValue = "0") int page) {
    try {
        List<Post> allPosts = postService.getPosts();
        List<Post> paginatedPosts = PaginationUtils.paginate(allPosts, page, PAGE_SIZE);
        model.addAttribute("Posts", paginatedPosts);
    } catch (Exception e) {
        // Handle exceptions if needed
        e.printStackTrace();
    }
    model.addAttribute("page", page);
    return "Posts";
    }

    @GetMapping("/Search")
    public String  getPost(Model m,@RequestParam(value = "id") String id) throws IOException {
        List<Post> l = new ArrayList<>();

        postService.getPosts().forEach(post -> {
            if(id.equals(post.getId()+"")  || id.equals(post.getUserId()+"")){
                l.add(post);
            }
            else if(post.getTitle().contains(id) || post.getBody().contains(id)){
                l.add(post);
            }
        });





        m.addAttribute("Posts",l);
        return "Posts";
    }



}
