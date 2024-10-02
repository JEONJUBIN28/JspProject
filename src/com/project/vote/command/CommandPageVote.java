package com.project.vote.command;

import com.project.global.Command;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class CommandPageVote implements Command {

    private String returnPage;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return returnPage;
    }
}
