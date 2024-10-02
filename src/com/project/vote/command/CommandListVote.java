package com.project.vote.command;

import com.project.global.Command;
import com.project.vote.dao.VoteDAO;
import com.project.vote.dto.VoteDTO;
import com.project.vote.dto.VoteListDTO;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
public class CommandListVote implements Command {

    private String returnPage;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        VoteDAO dao = new VoteDAO();
        List<VoteListDTO> voteList = dao.getAllVote();
        request.setAttribute("voteList", voteList);
        return returnPage;
    }

}
