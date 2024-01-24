package com.japroject.controller;

import com.japroject.model.News;
import com.japroject.repository.NewsRepository;
import com.japroject.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    @ResponseBody
    public List<News> getAllNews(){
        return newsService.findAllNews();
    }

    @PostMapping("/addnews")
    public void addNews(@RequestBody News news){
        newsService.saveNews(news);
    }


}
