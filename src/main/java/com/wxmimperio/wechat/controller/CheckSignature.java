package com.wxmimperio.wechat.controller;

import com.wxmimperio.wechat.service.ISignatureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by wxmimperio on 2016/11/6.
 */

@Controller
public class CheckSignature {

    private ISignatureService signatureService;

    @RequestMapping(value = "checkSignature")
    @ResponseBody
    public void createTableController(@RequestParam(value = "signature", required = false) String signature,
                                      @RequestParam(value = "timestamp", required = false) String timestamp,
                                      @RequestParam(value = "nonce", required = false) String nonce,
                                      @RequestParam(value = "echostr", required = false) String echostr) throws IOException {

        try {
            this.signatureService.checkSignature(signature,timestamp,nonce);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("this is a checkSignature");
    }

    @Resource
    public void setSignatureService(ISignatureService signatureService) {
        this.signatureService = signatureService;
    }
}
