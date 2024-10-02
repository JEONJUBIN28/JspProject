package com.project.member.controller;

import com.project.global.Command;
import com.project.member.factory.MemberCommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {

    private final MemberCommandFactory memberCommandFactory = new MemberCommandFactory();

    public MemberController() {
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
        Command command = memberCommandFactory.createNewCommand(key);
        String viewPage = command.execute(req, res);

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);

    }

}
