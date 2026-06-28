package br.com.dbserver.votacao.desafiovotacao.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_associated_id")
    private Long userAssociatedId;

    @Column(name = "poll_id")
    private Long pollId;

     @Column(name = "vote")
    private String voteValue;
  

    protected Vote() {   }

    public Vote(Long userAssociatedId, Long pollId, String voteValue) {
        this.userAssociatedId = userAssociatedId;
        this.pollId = pollId;
        this.voteValue = voteValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAssociatedId() {
        return userAssociatedId;
    }

    public void setUserAssociatedId(Long userAssociatedId) {
        this.userAssociatedId = userAssociatedId;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public String getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(String voteValue) {
        this.voteValue = voteValue;
    }


    
}
