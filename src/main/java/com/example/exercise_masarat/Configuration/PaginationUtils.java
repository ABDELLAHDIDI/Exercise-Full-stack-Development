package com.example.exercise_masarat.Configuration;

import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PaginationUtils {
    public static <Post> List<Post> paginate(List<Post> list, int page, int pageSize) {
        int startIndex = (page ) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        if (startIndex < 0 ||startIndex >= list.size()) {
            return List.of();
        }
        return list.subList(startIndex, endIndex);
    }
}
