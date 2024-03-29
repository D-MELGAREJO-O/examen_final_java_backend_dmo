package com.ef_java_backend.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(

        LocalDateTime dateTime,
        String message,
        String path

) {
}
