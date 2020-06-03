package com.lambda.web.navermovie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.Box;
import com.lambda.web.proxy.IFunction;
import com.lambda.web.proxy.Pager;
import com.lambda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box; // count는 String, List 는 ArrayList라서 Object로 처리

    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        }else{
            pxy.print("검색어가 "+searchWord);
        }
        pxy.print("넘어온 페이지 번호 : "+ pageNumber);
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFunction<Pager, List<MovieDTO>> f = p ->  movieMapper.selectMovies(p);
        List<MovieDTO> list = f.apply(pager);
        pxy.print("***********");
        for(MovieDTO m : list){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", list);
        return box.get();
    }
}

