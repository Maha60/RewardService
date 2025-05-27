// exception/GlobalExceptionHandler.java
package org.example.Exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler
{

     @ExceptionHandler(RewardsCalculationException.class)
     public ResponseEntity<String> handleRewardsException(RewardsCalculationException ex)
     {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
     }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception ex) {
        return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
