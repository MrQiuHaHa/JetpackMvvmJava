package com.davis.jetpackmvvm.network;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import javax.net.ssl.SSLException;

import retrofit2.HttpException;

/**
 * 根据异常返回相关的错误信息工具类
 */
public class ExceptionHandle {

    public static AppException handleException(Throwable e) {
        AppException ex = null;
        if (e != null) {
            if (e instanceof HttpException) {
                ex = new AppException(Error.NETWORK_ERROR, e);
            }
            if (e instanceof JsonParseException || e instanceof JSONException
                    || e instanceof ParseException || e instanceof MalformedJsonException) {
                ex = new AppException(Error.PARSE_ERROR,e);
            }
            if (e instanceof ConnectException) {
                ex = new AppException(Error.NETWORK_ERROR, e);
            }
            if (e instanceof SSLException) {
                ex = new AppException(Error.SSL_ERROR, e);
            }
            if (e instanceof ConnectTimeoutException || e instanceof SocketTimeoutException
                    || e instanceof UnknownHostException) {
                ex = new AppException(Error.TIMEOUT_ERROR, e);
            }
            if (e instanceof AppException) {
                ex = (AppException) e;
            }
        }
        return ex == null ? new AppException(Error.UNKNOWN, e) : ex;
    }
}
