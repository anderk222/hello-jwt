package anderk222.hellojwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {

        ex.printStackTrace();

        return ResponseEntity.status(401).body("Error");

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> handleException(Exception ex) {

        ex.printStackTrace();

        return ResponseEntity.status(401).body("Error");

    }

}