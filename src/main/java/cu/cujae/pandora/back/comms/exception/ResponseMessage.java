package cu.cujae.pandora.back.comms.exception;

import java.util.Date;

public class ResponseMessage {
    private Date timestamp;
    private String status;
    private String error;
    private String message;
    private String path;
    private Integer errorCode;

    public ResponseMessage(String path) {
        this.timestamp = new Date();
        this.status = "500";
        this.errorCode = 999;
        this.error = "Internal Server Error";
        this.message = "Server's error";
        this.path = path;
    }

    public ResponseMessage(RestException ex, String path, String status, String error){
        this.timestamp = new Date();
        this.status = status;
        this.errorCode = ex.getErrorCode();
        this.error = error;
        this.message = ex.getMessage();
        this.path = path;
    }

    public ResponseMessage(Exception ex, String path){
        this.timestamp = new Date();
        this.status = "500";
        this.errorCode = 999;
        this.error = "Internal Server Error";
        this.message = ex.getLocalizedMessage();
        this.path = path;
    }
}
