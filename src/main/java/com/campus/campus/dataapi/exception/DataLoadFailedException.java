package com.campus.campus.dataapi.exception;

import org.apache.logging.log4j.message.Message;

public class DataLoadFailedException extends RuntimeException {

    private static final String MESSAGE = "데이터 로드에 실패하였습니다.";

    public DataLoadFailedException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
