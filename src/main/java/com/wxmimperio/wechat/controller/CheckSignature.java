package com.wxmimperio.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by wxmimperio on 2016/11/6.
 */

@Controller
public class CheckSignature {

    @RequestMapping(value = "checkSignature")
    @ResponseBody
    public void createTableController(@RequestParam(value = "tableName", required = false) String tableName) throws IOException {
        System.out.println(tableName);
        System.out.println("this is a checkSignature");
    }
}
