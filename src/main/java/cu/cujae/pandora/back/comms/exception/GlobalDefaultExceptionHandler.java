package cu.cujae.pandora.back.comms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;


@RestControllerAdvice
class GlobalDefaultExceptionHandler {

    private Logger LOG = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseMessage> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        if (e instanceof RestException) {
            throw e;
        }
        if (e instanceof MissingServletRequestParameterException) {
            throw e;
        }

        if (e instanceof MethodArgumentNotValidException) {
            throw e;
        }
        LOG.error("Exception not handled by anyone {}", e.getMessage());
        LOG.debug("Exception detail:", e);
        // Otherwise setup and send the user to a default error-view.
        return new ResponseEntity<>(new ResponseMessage(e, req.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = RestException.class)
    public ResponseEntity<ResponseMessage> restExceptionHandler(HttpServletRequest req, RestException e)
            throws Exception {
        if (e instanceof InvalidClientRequestException) {
            ResponseMessage clientException = new ResponseMessage(e, req.getRequestURI(), "400", "Bad Request");
            LOG.debug("ClientException: \n" + new Gson().toJson(clientException));
            return new ResponseEntity<>(clientException, HttpStatus.BAD_REQUEST);
        }

        if (e instanceof ServerSideException) {
            ResponseMessage soapException = new ResponseMessage(e, req.getRequestURI(), "500", "Internal Server Error");
            LOG.debug("SoapException: \n" + new Gson().toJson(soapException));
            return new ResponseEntity<>(soapException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

}
