package cu.cujae.pandora.back.comms.exception;

public enum ErrorCodes {
    CLIENT_USERNAME_TAKEN(301),
    CLIENT_UNKNOWN(306),
    CLIENT_INVALID_PARAMETER(305),

    SERVER_UNKNOWN_ERROR(999);

    private Integer errorCode;
    ErrorCodes(Integer code){
        errorCode = code;
    }
    public Integer getErrorCode() {
        return errorCode;
    }
}
