package com.japroject.service;

import com.japroject.model.News;
import com.japroject.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> findAllNews(){
        return newsRepository.findAll();
    }

    public void saveNews(News news){
        newsRepository.save(news);
    }


}
