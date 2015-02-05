package com.currencyfair.services;

import com.currencyfair.database.model.MoneyTransaction;
import com.currencyfair.model.json.EndpointMessage;

public interface MoneyTransactionService {

    MoneyTransaction save(EndpointMessage message);

}
