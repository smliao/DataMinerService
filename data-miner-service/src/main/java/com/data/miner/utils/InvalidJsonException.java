package com.data.miner.utils;

public class InvalidJsonException extends RuntimeException {

    public InvalidJsonException(Exception e) {
        super(e);
    }
}
