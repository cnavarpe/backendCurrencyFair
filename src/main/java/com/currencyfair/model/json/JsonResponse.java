package com.currencyfair.model.json;

/**
 * Object that returns the processing response information from JSON endpoint
 */

public class JsonResponse {

    private Integer errorCode;

    private String message;

    public JsonResponse() {
    }

    /**
     * Instantiates a new json response.
     * 
     * @param errorCode
     *            the error code
     * @param message
     *            error message
     */
    public JsonResponse(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((errorCode == null) ? 0 : errorCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JsonResponse other = (JsonResponse) obj;
        if (errorCode == null) {
            if (other.errorCode != null)
                return false;
        } else if (!errorCode.equals(other.errorCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "JsonResponse [errorCode=" + errorCode + ", message=" + message + "]";
    }

}
