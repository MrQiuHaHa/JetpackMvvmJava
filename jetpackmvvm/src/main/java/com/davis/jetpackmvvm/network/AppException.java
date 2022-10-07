package com.davis.jetpackmvvm.network;

public class AppException extends Exception {

    public String errorMsg = "";
    public int errCode = 0;
    public String errorLog = "";
    public Throwable throwable = null;

    AppException(int errCode, String errorMsg, String errorLog, Throwable throwable) {
        super(errorMsg);
        if (errorMsg != null) {
            this.errorMsg = errorMsg;
        }
        this.errCode = errCode;
        if (errorLog != null) {
            this.errorLog = errorLog;
        }
        this.throwable = throwable;
    }

    AppException(Error error, Throwable e) {
        this.errCode = error.getCode();
        this.errorMsg = error.getDescription();
        this.errorLog = e.getMessage();
        this.throwable = e;
    }
}
