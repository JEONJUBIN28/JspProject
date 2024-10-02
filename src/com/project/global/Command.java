package com.project.global;

import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response);

}
