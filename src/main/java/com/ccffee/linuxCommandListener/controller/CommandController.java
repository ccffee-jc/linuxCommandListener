package com.ccffee.linuxCommandListener.controller;

import com.ccffee.linuxCommandListener.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/command")
public class CommandController {
    @Autowired
    private CommandService commandService;

    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    public String execute(@RequestParam String command, @RequestParam String pd){
        if (!pd.equals("qwe123456789")){
            return "you shall not pass!!!";
        }
        return commandService.executeCmd(command);
    }
}
