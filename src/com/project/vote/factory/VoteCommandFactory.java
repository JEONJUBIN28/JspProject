package com.project.vote.factory;

import com.project.global.Command;
import com.project.global.CommandDefault;
import com.project.vote.command.*;

import java.util.HashMap;
import java.util.Map;

public class VoteCommandFactory {

    private final Map<String, Command> commandHashMap = new HashMap<>();

    public VoteCommandFactory() {
        // GET | DEFAULT
        commandHashMap.put("/home.do", new CommandVoteHome("/index.jsp"));
        commandHashMap.put("/votelist.do", new CommandListVote("/list.jsp"));
        commandHashMap.put("/votepage.do", new CommandPageVote("/voteinput.jsp"));

        // POST
        commandHashMap.put("/addvote.do", new CommandAddVote("/votelist.do"));
    }

    public Command createNewCommand(String key) {
        return commandHashMap.getOrDefault(key, new CommandVoteNotFound("/error.jsp"));
    }

}
