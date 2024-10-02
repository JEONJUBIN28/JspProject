package com.project.vote.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteDTO {

    private String memberSocialNumber;
    private String memberName;
    private String personNumber;
    private String voteTime;
    private String voteArea;
    private String voteConfirm;

}
