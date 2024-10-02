package com.project.member.factory;

import com.project.global.Command;
import com.project.global.CommandDefault;
import com.project.member.command.CommandMemberList;
import com.project.member.command.CommandMemberNotFound;
import com.project.member.command.CommandMemberRank;

import java.util.HashMap;
import java.util.Map;

public class MemberCommandFactory {

    private final Map<String, Command> commandHashMap = new HashMap<>();

    public MemberCommandFactory() {
        commandHashMap.put("/member/members.do", new CommandMemberList("/memberlist.jsp"));
        commandHashMap.put("/member/rank.do", new CommandMemberRank("/ranking.jsp"));
    }

    public Command createNewCommand(String key) {
        return commandHashMap.getOrDefault(key, new CommandMemberNotFound("/error.jsp"));
    }
}


