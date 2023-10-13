package anderk222.hellojwt.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import anderk222.hellojwt.dto.Response;
import anderk222.hellojwt.dto.ResponseEnum;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Response> handleAccessDeniedException(AccessDeniedException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.NO_AUTHORIZED));

    }

    @ExceptionHandler({ AuthenticationException.class })
    @ResponseBody
    public ResponseEntity<Response> handleAuthenticationException(Exception ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.ERROR_LOGIN));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handleRuntimeException(RuntimeException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.INTERNAL_ERROR));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.INTERNAL_ERROR));

    }

}