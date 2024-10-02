package com.project.vote.dao;

import com.project.vote.dto.VoteDTO;
import com.project.vote.dto.VoteListDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class VoteDAO {

    private DataSource dataSource;

    public VoteDAO() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<VoteListDTO> getAllVote() {
        List<VoteListDTO> members = new ArrayList<>();
        String sql = "SELECT * FROM TBL_VOTE_202005 WHERE V_AREA = '제1투표장'";

        DateTimeFormatter birthdayFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                String birthday = rs.getString("V_JUMIN").substring(0, 6);

                LocalDate birthDate;
                try {
                    // 생년월일 처리
                    int year = Integer.parseInt(birthday.substring(0, 2));
                    int month = Integer.parseInt(birthday.substring(2, 4));
                    int day = Integer.parseInt(birthday.substring(4, 6));

                    year = year >= 0 && year <= 21 ? year + 2000 : year + 1900;

                    birthDate = LocalDate.of(year, month, day);
                } catch (DateTimeParseException | NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }

                LocalDate now = LocalDate.now();

                String age = String.valueOf(Period.between(birthDate, now).getYears());
                String gender = rs.getString("V_JUMIN").length() > 6 && rs.getString("V_JUMIN").charAt(6) == '1' ? "남" : "여";
                String confirmStatus = "Y".equalsIgnoreCase(rs.getString("V_CONFIRM")) ? "확인" : "미확인";

                VoteListDTO voteDTO = new VoteListDTO(
                        rs.getString("V_NAME"),
                        birthDate.format(outputFormatter),
                        age,
                        gender,
                        rs.getString("M_NO"),
                        rs.getString("V_TIME"),
                        confirmStatus
                );
                members.add(voteDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return members;
    }

    public void saveVote(VoteDTO voteDTO) {

        String sql = "INSERT INTO TBL_VOTE_202005 (V_JUMIN, V_NAME, M_NO, V_TIME, V_AREA, V_CONFIRM) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, voteDTO.getMemberSocialNumber());
                preparedStatement.setString(2, voteDTO.getMemberName());
                preparedStatement.setString(3, voteDTO.getPersonNumber());
                preparedStatement.setString(4, voteDTO.getVoteTime());
                preparedStatement.setString(5, voteDTO.getVoteArea());
                preparedStatement.setString(6, voteDTO.getVoteConfirm());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}