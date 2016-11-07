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
    public void createTableController(@RequestParam(value = "signature", required = false) String signature,
                                      @RequestParam(value = "timestamp", required = false) String timestamp,
                                      @RequestParam(value = "nonce", required = false) String nonce,
                                      @RequestParam(value = "echostr", required = false) String echostr) throws IOException {
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        System.out.println("this is a checkSignature");
    }
}
