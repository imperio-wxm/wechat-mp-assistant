package com.wxmimperio.wechat.service.impl;

import com.wxmimperio.wechat.service.ISignatureService;

import java.util.Arrays;

/**
 * Created by wxmimperio on 2016/11/7.
 */
public class SignatureServiceImpl implements ISignatureService {
    private static final String token = "4603wxmimperio";

    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) throws Exception {
        //对token、timestamp、nonce按照字典排序
        String[] paramArr = new String[]{token, timestamp, nonce};
        Arrays.sort(paramArr);
        return false;
    }


}
