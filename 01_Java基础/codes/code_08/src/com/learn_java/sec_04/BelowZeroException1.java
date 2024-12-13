package com.learn_java.sec_04;

public class BelowZeroException1 extends RuntimeException{
    static final long serialVersionUID = -703489715766939L;

    public BelowZeroException1() {
        super();
    }

    public BelowZeroException1(String message) {
        super(message);
    }

    public BelowZeroException1(String message, Throwable cause) {
        super(message, cause);
    }

    public BelowZeroException1(Throwable cause) {
        super(cause);
    }

    protected BelowZeroException1(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
