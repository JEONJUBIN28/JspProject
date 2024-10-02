package com.project.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VoteListDTO {

    private String memberName;
    private String birthday;
    private String age;
    private String sex;
    private String personNumber;
    private String voteTime;
    private String voteConfirm;

}
