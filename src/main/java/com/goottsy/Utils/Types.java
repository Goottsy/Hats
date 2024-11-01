package com.goottsy.Utils;

import co.aikar.commands.BukkitCommandCompletionContext;
import co.aikar.commands.CommandCompletions;
import com.google.common.collect.ImmutableList;
import com.goottsy.Hats;



public class Types {
    Hats instance;

    public Types(Hats instance){
        this.instance = instance;
        CommandCompletions<BukkitCommandCompletionContext> commandCompletions = Hats.commandManager.getCommandCompletions();
//        commandCompletions.registerAsyncCompletion("hats", c -> {
//            return hatIds;
//        });


        commandCompletions.registerAsyncCompletion("bool", c -> {
            return ImmutableList.of("true", "false");
        });

    }




}
