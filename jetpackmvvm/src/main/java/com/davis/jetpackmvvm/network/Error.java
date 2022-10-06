package com.davis.jetpackmvvm.network;

public enum Error {
    UNKNOWN,
    PARSE_ERROR,
    NETWORK_ERROR,
    SSL_ERROR,
    TIMEOUT_ERROR;

    public static Error valueOf(int code) {
        switch (code)
        {
            case 1000:
                return UNKNOWN;
            case 1001:
                return PARSE_ERROR;
            case 1002:
                return NETWORK_ERROR;
            case 1004:
                return SSL_ERROR;
            case 1006:
                return TIMEOUT_ERROR;
        }
        return UNKNOWN;
    }

    public int getCode() {
        switch (this)
        {
            case UNKNOWN:
                return 1000;
            case PARSE_ERROR:
                return 1001;
            case NETWORK_ERROR:
                return 1002;
            case SSL_ERROR:
                return 1004;
            case TIMEOUT_ERROR:
                return 1006;
        }
        return 0;
    }

    public String getDescription() {
        switch (this)
        {
            case UNKNOWN:
                return "请求失败，请稍后再试";
            case PARSE_ERROR:
                return "解析错误，请稍后再试";
            case NETWORK_ERROR:
                return "网络连接错误，请稍后重试";
            case SSL_ERROR:
                return "证书出错，请稍后再试";
            case TIMEOUT_ERROR:
                return "网络连接超时，请稍后重试";
        }
        return "";
    }
}
