package com.digitalworlds.weather.realtime.application.exception;

public class RealTimeException extends RuntimeException {
    public RealTimeException(String message) {
        super(message);
    }

    public RealTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RealTimeException(Throwable cause) {
        super(cause);
    }

    public RealTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
