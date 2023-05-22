package cu.cujae.pandora.back.comms.exception;

public abstract class RestException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    protected Integer errorCode;

    public RestException(String message, Integer errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public RestException(String arg0){
        super(arg0);
    }

    public RestException(Exception e){
        super(e);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
