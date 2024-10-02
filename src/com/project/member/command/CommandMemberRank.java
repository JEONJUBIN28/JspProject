package com.project.member.command;

import com.project.global.Command;
import com.project.member.dao.MemberDAO;
import com.project.member.dto.MemberDTO;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
public class CommandMemberRank implements Command {

    private String returnPage;
    private final MemberDAO memberDAO = new MemberDAO();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<MemberDTO> rankList = memberDAO.getVoteTotal();
        request.setAttribute("rankList", rankList);
        return returnPage;
    }
}
