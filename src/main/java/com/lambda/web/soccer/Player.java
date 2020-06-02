package com.lambda.web.soccer;

import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="player")
@Lazy
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerNo;
    @NotNull
    @Column(length = 10) private String playerId;
    @NotNull @Column(length = 20) private String playerName;
    @Column(length = 40) private String ePlayerName;
    @Column(length = 30) private String nickname;
    @Column(length = 10) private String joinYyyy;
    @Column(length = 10) private String position;
    @Column(length = 10) private String backNo;
    @Column(length = 20) private String nation;
    @Column(length = 20) private String birthDate;
    @Column(length = 10) private String solar;
    @Column(length = 10) private String height;
    @Column(length = 10) private String weight;

    @Builder Player(String playerId, String playerName, String ePlayerName,
                    String nickname,
                    String joinYyyy,
                    String position,
                    String backNo,
                    String nation,
                    String birthDate,
                    String solar,
                    String height,
                    String weight){
        this.playerId = playerId;
        this.playerName = playerName;
        this.ePlayerName=ePlayerName;
        this.nickname=nickname;
        this.joinYyyy=joinYyyy;
        this.position=position;
        this.backNo=backNo;
        this.nation=nation;
        this.birthDate=birthDate;
        this.solar=solar;
        this.height=height;
        this.weight=weight;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(){

    }
    public Long getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(Long playerNo) {
        this.playerNo = playerNo;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getePlayerName() {
        return ePlayerName;
    }

    public void setePlayerName(String ePlayerName) {
        this.ePlayerName = ePlayerName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getJoinYyyy() {
        return joinYyyy;
    }

    public void setJoinYyyy(String joinYyyy) {
        this.joinYyyy = joinYyyy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSolar() {
        return solar;
    }

    public void setSolar(String solar) {
        this.solar = solar;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
