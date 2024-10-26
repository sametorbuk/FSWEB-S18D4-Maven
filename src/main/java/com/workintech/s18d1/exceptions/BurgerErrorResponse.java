package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BurgerErrorResponse {
    private String message;
    private int status;
    private long timeStamps;


    public BurgerErrorResponse(String message, long timeStamps, HttpStatus status) {
        this.message = message;
        this.timeStamps = timeStamps;
        this.status = status.value();
    }

    public BurgerErrorResponse(String message) {
        this.message = message;
    }
}
