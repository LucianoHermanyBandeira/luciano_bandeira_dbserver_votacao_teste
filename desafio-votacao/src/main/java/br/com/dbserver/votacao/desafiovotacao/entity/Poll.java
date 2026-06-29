package br.com.dbserver.votacao.desafiovotacao.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "polls")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;

    @Column(name = "time_length")
    private Integer timeLengthInMinutes;

    @Column(name = "start_time")
    LocalDateTime startTime;

     @Column(name = "end_time")
    LocalDateTime endTime;

    protected Poll() {
    }

    public Poll(Long id, String theme, Integer timeLengthInMinutes, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.theme = theme;
        this.timeLengthInMinutes = timeLengthInMinutes;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Poll(Long id, String theme, Integer timeLengthInMinutes) {
        this.id = id;
        this.theme = theme;
        this.timeLengthInMinutes = timeLengthInMinutes;        
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getTimeLengthInMinutes() {
        return this.timeLengthInMinutes;
    }

    public void setTimeLengthInMinutes(Integer timeLengthInMinutes) {
        this.timeLengthInMinutes = timeLengthInMinutes;
    }

    public void setStartTime(LocalDateTime agora) {
        this.startTime = agora;
        
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }
 

}
       

