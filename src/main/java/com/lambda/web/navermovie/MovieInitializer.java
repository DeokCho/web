package com.lambda.web.navermovie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.Crawler;
import com.lambda.web.proxy.ISupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieInitializer implements ApplicationRunner {
    @Autowired MovieMapper movieMapper;
    @Autowired Crawler crawler;
    @Override
    public void run(ApplicationArguments args)throws Exception{
        ISupplier<Integer> s = movieMapper :: count;
        if(s.get()==0) crawler.naverMovie();
    }
}
