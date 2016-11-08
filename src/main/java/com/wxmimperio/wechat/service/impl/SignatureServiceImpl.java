package com.wxmimperio.wechat.service.impl;

import com.wxmimperio.wechat.service.ISignatureService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by wxmimperio on 2016/11/7.
 */

@Service("signatureServiceImpl")
public class SignatureServiceImpl implements ISignatureService {
    private static final String token = "4603wxmimperio";

    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) throws Exception {
        //对token、timestamp、nonce按照字典排序
        String[] paramArr = new String[]{token, timestamp, nonce};
        Arrays.sort(paramArr);
        StringBuilder contextBuilder = new StringBuilder();
        for (String param : paramArr) {
            contextBuilder.append(param);
        }
        String checkText = null;

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(contextBuilder.toString().getBytes());
        checkText = byteToStr(digest);
        return checkText != null && checkText.equals(signature.toUpperCase());
    }

    private String byteToStr(byte[] byteArray) {
        String str = "";
        for (int i = 0; i < byteArray.length; i++) {
            str += byteToHexStr(byteArray[i]);
        }
        return str;
    }

    private String byteToHexStr(byte mByte) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = digit[mByte & 0X0F];
        return new String(tempArr);
    }
}
