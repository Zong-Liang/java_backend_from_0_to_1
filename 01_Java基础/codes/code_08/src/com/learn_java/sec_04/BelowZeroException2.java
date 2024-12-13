package com.learn_java.sec_04;

public class BelowZeroException2 extends Exception{
    static final long serialVersionUID = -33875124229948L;

    public BelowZeroException2() {
        super();
    }

    public BelowZeroException2(String message) {
        super(message);
    }

    public BelowZeroException2(String message, Throwable cause) {
        super(message, cause);
    }

    public BelowZeroException2(Throwable cause) {
        super(cause);
    }

    protected BelowZeroException2(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
