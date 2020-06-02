package com.lambda.web.proxy;


import com.lambda.web.entities.Music;
import com.lambda.web.entities.MusicRepository;
import com.lambda.web.navermovie.Movie;
import com.lambda.web.navermovie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader fileUploader;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;


    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        if(musicRepository.count() == 0) crawler.bugsMusic();

        List<Music> list = musicRepository.findAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();


    }

    @GetMapping("/soccer/{searchWord}")
    public HashMap<String, String> soccer(@PathVariable String searchWord){
        pxy.print("넘어온 키워드 :"+searchWord);
        fileUploader.upload();
    return null;
    }

    @GetMapping("navermovie/{searchWord}")
    public void naverMovie(@PathVariable String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        crawler.naverMovie();
    }

}