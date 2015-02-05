package com.currencyfair.exceptions;

import com.currencyfair.model.json.EndpointMessage;

public class EndpointValidationException extends RuntimeException {
    private static final long serialVersionUID = -7745537393139842671L;
    private EndpointMessage endpointMessage;
    private String errorMsg;

    public EndpointValidationException(final EndpointMessage endpointMessage, final String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.endpointMessage = endpointMessage;
    }

    public EndpointMessage getEndpointMessage() {
        return endpointMessage;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
