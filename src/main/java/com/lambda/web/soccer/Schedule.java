package com.lambda.web.soccer;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="schedule")
public class Schedule {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;
    @NotNull @Column(length = 10) private String scheDate;
    @Column(length = 10) private String gubun;
    @Column(length = 10) private String hometeamId;
    @Column(length = 10) private String awayteamId;
    @Column(length = 5) private String homeScore;
    @Column(length = 5) private String awayScore;

    @Builder
    public Schedule(String scheDate,
                   String gubun,String hometeamId,String awayteamId,
                   String homeScore,String awayScore){
        this.gubun = gubun;
        this.hometeamId = hometeamId;
        this.awayteamId = awayteamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id") @NotNull
    private Stadium stadium;
}
