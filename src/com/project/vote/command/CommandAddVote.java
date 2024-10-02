package com.project.vote.command;

import com.project.global.Command;
import com.project.vote.dao.VoteDAO;
import com.project.vote.dto.VoteDTO;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class CommandAddVote implements Command {

    private final VoteDAO voteRepository = new VoteDAO();
    private String returnPage;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        VoteDTO voteDTO = new VoteDTO(
                request.getParameter("jumin"),
                request.getParameter("name"),
                request.getParameter("voteNo"),
                request.getParameter("voteTime"),
                request.getParameter("voteArea"),
                request.getParameter("confirm")
        );

        voteRepository.saveVote(voteDTO);
        return returnPage;

    }
}
