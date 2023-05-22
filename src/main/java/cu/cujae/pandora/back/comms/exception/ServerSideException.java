package cu.cujae.pandora.back.comms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that conveys server-side error information, and that can be sent to the client.
 * @author alvaldes
 * Formerly: API Exception
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerSideException extends RestException{
    private static final long serialVersionUID = -8416659475773736608L;

    public ServerSideException(String arg0){
        super(arg0);
    }

    public ServerSideException(String message, Integer errorCode){
        super(message, errorCode);
    }

    public ServerSideException(Exception e){
        super(e);
    }
}
