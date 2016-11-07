package com.wxmimperio.wechat.controller;

import com.wxmimperio.wechat.service.ISignatureService;
import com.wxmimperio.wechat.service.impl.SignatureServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wxmimperio on 2016/11/6.
 */

@Controller
public class CheckSignature {

    private SignatureServiceImpl signatureServiceImpl;

    @RequestMapping(value = "checkSignature")
    @ResponseBody
    public void createTableController(@RequestParam(value = "signature", required = false) String signature,
                                      @RequestParam(value = "timestamp", required = false) String timestamp,
                                      @RequestParam(value = "nonce", required = false) String nonce,
                                      @RequestParam(value = "echostr", required = false) String echostr, HttpServletResponse response) throws IOException {

        try {
            PrintWriter out = response.getWriter();
            if (this.signatureServiceImpl.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("this is a checkSignature");
    }

    @Resource(name = "signatureServiceImpl")
    public void setSignatureService(SignatureServiceImpl signatureServiceImpl) {
        this.signatureServiceImpl = signatureServiceImpl;
    }
}
