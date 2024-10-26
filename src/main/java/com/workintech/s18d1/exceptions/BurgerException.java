package com.workintech.s18d1.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@NoArgsConstructor
public class BurgerException  extends RuntimeException{
    private HttpStatus status;

    public BurgerException(HttpStatus status) {
        this.status = status;
    }

    public BurgerException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }
}
