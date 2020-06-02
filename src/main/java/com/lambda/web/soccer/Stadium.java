package com.lambda.web.soccer;

import javax.validation.constraints.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="stadium")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stadiumNo;
    @NotNull @Column(length = 10) private String stadiumId ;
    @Column(length = 40) private String stadiumName ;
    @Column(length = 10) private String hometeamId ;
    @Column(length = 10) private String seatCount ;
    @Column(length = 60) private String address ;
    @Column(length = 10) private String ddd ;
    @Column(length = 10) private String tel ;


    @Builder
    public Stadium(String stadiumId,String stadiumName,String hometeamId,
                   String seatCount,String address,String ddd,String tel){
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.hometeamId = hometeamId;
        this.seatCount = seatCount;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
    }

    @OneToMany(mappedBy = "stadium")
    private List<Team> teams;

    @OneToMany(mappedBy = "stadium")
    private List<Schedule> schedules;
}
