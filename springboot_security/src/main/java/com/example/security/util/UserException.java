package com.example.security.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 14:43:02
 * @Description
 */

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
