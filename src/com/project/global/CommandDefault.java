package com.project.global;

import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class CommandDefault implements Command{

    private String returnPage;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return returnPage;
    }
}
