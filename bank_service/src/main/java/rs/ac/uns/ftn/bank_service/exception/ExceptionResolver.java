package rs.ac.uns.ftn.bank_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity notFoundException(NotFoundException exception) {
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public final ResponseEntity httpClientErrorException(HttpClientErrorException exception){
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    private ResponseEntity buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
