package com.project.member.command;

import com.project.global.Command;
import com.project.member.dao.MemberDAO;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CommandMemberList implements Command {

    private String returnPage;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        MemberDAO memberDAO = new MemberDAO();
        request.setAttribute("memberList", memberDAO.getAllMembers());
        return returnPage;
    }
}
