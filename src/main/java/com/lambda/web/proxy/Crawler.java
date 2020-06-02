package com.lambda.web.proxy;

import com.lambda.web.entities.Music;
import com.lambda.web.entities.MusicRepository;
import com.lambda.web.navermovie.Movie;
import com.lambda.web.navermovie.MovieRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service("crawler")  @Lazy
public class Crawler extends Proxy{
    @Autowired Inventory<Music> inventory;
    @Autowired Box<String> box;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;
    public void bugsMusic(){
        inventory.clear();
        try{
            String url = "https://music.bugs.co.kr/chart";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 " +
                            "(KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("p.title");
            Elements artist = d.select("p.artist");
            Elements thumbnail = d.select("a.thumbnail");
            Music music = null;
            for(int i=0;i < title.size(); i++){
                music = new Music();
                music.setSeq(string(i+1));
                music.setTitle(title.get(i).text());
                music.setArtists(artist.get(i).text());
                music.setThumbnail(thumbnail.get(i).select("img").attr("src"));
                musicRepository.save(music);
            }
        }catch(Exception e){
            print("에러 발생");
        }
        print("******************** 크롤링 결과 *****************\n");
        // inventory.get().forEach(System.out::print);
        //print(inventory.get().get(0).toString());

    }

    public void naverMovie() {
        try{
            String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements arr = d.select("div.tit3");
            Elements date = d.select("p.r_date");
            Movie movie = null;
            for(int i=0;i < arr.size(); i++){
                movie = new Movie();
                movie.setRank(string(i+1));
                movie.setTitle(arr.get(i).text());
                movie.setRankDate(date.get(0).text());

                movieRepository.save(movie);
            }
        }catch(Exception e){
            print("에러 발생");
        }
        print("******************** 크롤링 결과 *****************");

    }
}