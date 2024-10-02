package com.project.member.dao;

import com.project.member.dto.MemberDTO;
import com.project.member.dto.MemberListDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDAO {

    private DataSource dataSource;

    public MemberDAO() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MemberListDTO> getMemberVote() {
        List<MemberListDTO> members = new ArrayList<>();
        String sql = """
                SELECT member.M_NO AS mCode,
                       member.M_NAME AS mName,
                       vote.M_NO AS vNo
                FROM TBL_VOTE_202005 vote
                JOIN TBL_MEMBER_202005  member
                ON V_CONFIRM = 'Y' AND member.M_NO = vote.M_NO""";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                MemberListDTO memberListDTO = new MemberListDTO(
                        rs.getString("mCode"),
                        rs.getString("mName"),
                        rs.getString("vNo")
                );

                members.add(memberListDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members.stream().distinct().collect(Collectors.toList());
    }

    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = new ArrayList<>();
        String sql = """
                SELECT m.M_NO AS mNum,
                       m.M_NAME AS mName,
                       m.P_CODE AS mCode,
                       m.P_SCHOOL AS mGraduate,
                       m.M_JUMIN AS mSecurity,
                       m.M_CITY AS mCity,
                       p.P_TEL1 AS TEL1,
                       p.P_TEL2 AS TEL2,
                       p.P_TEL3 AS TEL3
                FROM TBL_MEMBER_202005 m
                JOIN TBL_PARTY_202005 p
                ON m.P_CODE = p.P_CODE ORDER BY m.M_NO""";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                String telNumber = rs.getString("TEL1") + " - " +
                        rs.getString("TEL2") + " - " +
                        rs.getString("TEL3");

                String graduate  = rs.getString("mGraduate").equalsIgnoreCase("1") ? "학사" :
                        rs.getString("mGraduate").equalsIgnoreCase("2") ? "석사" : "박사";

                String socialSecurityNumber = rs.getString("mSecurity").substring(0,6) + " - " +
                        rs.getString("mSecurity").substring(6);

                MemberDTO memberDTO = new MemberDTO(
                        rs.getString("mNum"),
                        rs.getString("mName"),
                        rs.getString("mCode"),
                        graduate,
                        socialSecurityNumber,
                        rs.getString("mCity"),
                        telNumber
                );

                members.add(memberDTO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return members;
    }

    public List<MemberDTO> getVoteTotal(){
        List<MemberDTO> dtos = new ArrayList<>();

        String sql = """
                SELECT member.M_NO AS mCode,
                       member.M_NAME AS mName,
                       count(vote.M_NO) AS vNo
                FROM TBL_VOTE_202005 vote
                         LEFT JOIN TBL_MEMBER_202005 member
                                   ON V_CONFIRM = 'Y' AND member.M_NO = vote.M_NO
                WHERE member.M_NAME IS NOT NULL
                group by member.M_NAME, member.M_NO
                ORDER BY vNo DESC""";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {

                MemberDTO dto = new MemberDTO();
                dto.setMemberCode(rs.getString("mCode"));
                dto.setMemberName(rs.getString("mName"));
                dto.setMemberNum(rs.getString("vNo"));

                dtos.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dtos.stream().
                map(changeDTO -> {
                    MemberDTO dto = new MemberDTO();
                    dto.setMemberCode(changeDTO.getMemberCode());
                    dto.setMemberName(changeDTO.getMemberName());
                    dto.setMemberNum(changeDTO.getMemberNum());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
