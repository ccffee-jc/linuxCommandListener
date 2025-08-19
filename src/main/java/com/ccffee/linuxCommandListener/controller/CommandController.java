package com.ccffee.linuxCommandListener.controller;

import com.ccffee.linuxCommandListener.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/command")
public class CommandController {
    @Autowired
    private CommandService commandService;

    @Value("${command.password:}")
    private String password;

    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    public ResponseEntity<String> execute(@RequestParam String command, @RequestParam String pd){
        if (!pd.equals(password)){
            return ResponseEntity.ok()
                    .contentType(new MediaType("text", "plain", java.nio.charset.StandardCharsets.UTF_8))
                    .body("you shall not pass!!!");
        }
        String result = commandService.executeCmd(command);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "plain", java.nio.charset.StandardCharsets.UTF_8));
        headers.set("Cache-Control", "no-cache");
        
        return ResponseEntity.ok()
                .headers(headers)
                .body(result);
    }
}
