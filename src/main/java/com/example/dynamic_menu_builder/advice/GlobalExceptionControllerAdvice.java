package com.example.dynamic_menu_builder.advice;

import com.example.dynamic_menu_builder.exception.*;
import com.example.dynamic_menu_builder.model.dto.R;
import com.example.dynamic_menu_builder.util.ExceptionUtils;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * Global exception controller advice
 */
@RestControllerAdvice
public class GlobalExceptionControllerAdvice {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * handles JSR303 validation exception
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R handleValidationException(ConstraintViolationException ex){
        StringBuilder msg = new StringBuilder();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
            String paramName = pathImpl.getLeafNode().getName();
            String message = constraintViolation.getMessage();
            msg.append("[").append(message).append("]");
        }
        LOGGER.error(msg.toString(),ex);

        return R.error(HttpStatus.BAD_REQUEST.value(),
                "Request data validation error").setData(msg.toString());
    }

    /**
     * handles Bad Request exception
     */
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R handleBadRequestException(BadRequestException ex){
        LOGGER.error(ex.getMsg());
        return R.error(
                ex.getCode(), ex.getMsg());
    }

    /**
     * handles Duplicate Data exception
     */
    @ExceptionHandler(value = DuplicatedDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R handleDuplicatedDataException(DuplicatedDataException ex){
        LOGGER.error(ex.getMsg());
        return R.error(
                ex.getCode(), ex.getMsg());
    }

    /**
     * handles Not Found exception
     */
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public R handleNotFoundException(NotFoundException ex){
        LOGGER.error(ex.getMsg());
        return R.error(
                ex.getCode(), ex.getMsg());
    }

    /**
     * handles NotImplementedException
     */
    @ExceptionHandler(value = NotImplementedException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public R handleNotImplementedException(NotImplementedException ex){
        LOGGER.error(ex.getMsg());
        return R.error(
                ex.getCode(), ex.getMsg());
    }

    /**
     * handles defined exception
     * @param ex the exception
     * @return Response
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleException(BaseException ex) {
        LOGGER.error(ex.getMsg());
        return R.error(
                ex.getCode(), ex.getMsg());
    }

    /**
     * handles un-expected exception
     * @param ex the exception
     * @return Response
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleUnknown(Exception ex){
        LOGGER.error(ex.getMessage(),ex);
        return R.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .setData(ExceptionUtils.getStackTrace(ex));
    }
}
