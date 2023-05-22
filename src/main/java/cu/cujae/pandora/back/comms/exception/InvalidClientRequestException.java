package cu.cujae.pandora.back.comms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
* The client performed a somehow invalid request
* @author alvaldes
* Former ClientException
*/
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidClientRequestException extends RestException{

    /*
    * Exceptions are serializable
    */
    private static final long serialVersionUID = 8275440441911802559L;

    public InvalidClientRequestException(String message, Integer errorCode) {
        super(message, errorCode);
    }

//    public InvalidClientRequestException(String arg0) {
//        super(arg0);
//    }

    public InvalidClientRequestException(Exception e) {
        super(e);
    }
}
