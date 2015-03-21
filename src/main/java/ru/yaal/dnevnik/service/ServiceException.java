package ru.yaal.dnevnik.service;

public class ServiceException extends Exception {
    public ServiceException(String format, Object... args) {
        super(String.format(format, args));
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}