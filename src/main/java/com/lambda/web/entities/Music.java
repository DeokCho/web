package com.lambda.web.entities;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicSeq;
    @Column(length = 4, nullable = false)
    private String seq;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String artists;
    @Column(length = 500, nullable = false)
    private String thumbnail;

    @Builder
    public Music(String seq, String title, String artists,
                 String thumbnail) {
        this.seq = seq;
        this.title = title;
        this.artists = artists;
        this.thumbnail = thumbnail;
    }

}