package com.currencyfair.util;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * General utilities class
 * 
 */
public class Tools {

    /**
     * Build error message from a list of Validation errors
     * 
     * @param allErrors
     * @return
     */
    public static String buildMessageFromErrors(List<ObjectError> allErrors) {
        StringBuilder errorMsg = new StringBuilder();
        boolean first = true;
        for (ObjectError error : allErrors) {
            if (first) {
                first = false;
            } else {
                errorMsg.append(", ");
            }
            String fieldName = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            errorMsg.append(fieldName).append(" ").append(defaultMessage);
        }
        return errorMsg.toString();
    }

}
