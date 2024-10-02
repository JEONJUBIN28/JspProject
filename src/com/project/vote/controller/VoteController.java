package com.project.vote.controller;

import com.project.global.Command;
import com.project.vote.factory.VoteCommandFactory;

import java.io.IOException;
import java.io.Serial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class VoteController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;
    private final VoteCommandFactory voteCommandFactory = new VoteCommandFactory();

    public VoteController() {
        super();
    }

    private String extractKey(HttpServletRequest request){
        return request.getRequestURI().
                substring(request.getContextPath().length());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        actionDo(req, res);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        actionDo(req, res);
    }

    private void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String key = extractKey(req).toLowerCase();
        Command command = voteCommandFactory.createNewCommand(key);
        String viewPage = command.execute(req, res);

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);

    }

}
