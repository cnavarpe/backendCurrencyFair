package com.currencyfair.controller;

import static com.currencyfair.util.Tools.buildMessageFromErrors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.currencyfair.exceptions.EndpointValidationException;
import com.currencyfair.model.json.EndpointMessage;
import com.currencyfair.model.json.JsonResponse;
import com.currencyfair.services.MoneyTransactionService;

@RestController
public class EndPointController {
    private static final Logger logger = LoggerFactory.getLogger(EndPointController.class);

    @Autowired
    private MoneyTransactionService moneyTransactionService;

    /**
     * Method that receives, validates and saves endPoint Messages
     * 
     * @param jsonAlarmMessage
     * @return response message
     * @throws EndpointValidationException
     */
    @RequestMapping(value = "/endpoint/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    JsonResponse addEnpoint(@RequestBody @Valid EndpointMessage endpointMessage, BindingResult result)
            throws EndpointValidationException {
        logger.debug("addEnpoint " + endpointMessage);
        if (result.hasErrors()) {
            String errorMsg = buildMessageFromErrors(result.getAllErrors());
            logger.error("validation fail: " + errorMsg);
            throw new EndpointValidationException(endpointMessage, errorMsg);
        } else {
            logger.debug("validation OK");
            moneyTransactionService.save(endpointMessage);
            return new JsonResponse(0, "endpointMessage saved");
        }
    }

    /**
     * Method that handles generic exceptions
     * 
     * @param thrown
     *            exception
     * @return response with the information of the exception
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    JsonResponse handleExceptions(Exception ex) {

        logger.error("exception thrown " + ex.getMessage());
        if (ex instanceof EndpointValidationException) {
            return new JsonResponse(-2, ((EndpointValidationException) ex).getEndpointMessage().toString() + " "
                    + ex.getMessage());
        } else {
            return new JsonResponse(-2, ex.getMessage());
        }
    }

}
