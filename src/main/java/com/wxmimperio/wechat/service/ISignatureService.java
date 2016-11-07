package com.wxmimperio.wechat.service;

/**
 * Created by wxmimperio on 2016/11/7.
 */
public interface ISignatureService {
    boolean checkSignature(String signature, String timestamp, String nonce) throws Exception;
}
