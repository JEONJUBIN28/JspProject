package com.project.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String memberNum;
    private String memberName;
    private String memberCode;
    private String memberGraduate;
    private String memberSecurityNumber;
    private String memberAddress;
    private String memberPhoneNumber;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNum='" + memberNum + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberCode='" + memberCode + '\'' +
                ", memberGraduate='" + memberGraduate + '\'' +
                ", memberSecurityNumber='" + memberSecurityNumber + '\'' +
                ", memberAddress='" + memberAddress + '\'' +
                ", memberPhoneNumber='" + memberPhoneNumber + '\'' +
                '}';
    }
}
