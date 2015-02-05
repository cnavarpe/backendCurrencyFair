package com.currencyfair.services.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currencyfair.database.model.MoneyTransaction;
import com.currencyfair.database.model.User;
import com.currencyfair.database.repositories.MoneyTransactionRepository;
import com.currencyfair.model.json.EndpointMessage;
import com.currencyfair.services.MoneyTransactionService;
import com.currencyfair.services.UserService;

@Service
@Transactional(readOnly = false)
public class MoneyTransactionServiceImpl implements MoneyTransactionService {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    @Autowired
    private UserService userService;

    @Override
    public MoneyTransaction save(EndpointMessage message) {
        Integer userId = message.getUserId();
        User user = userService.findById(userId);
        if (user == null) {
            user = new User();
            user.setId(userId);
            user.setName("UNKNOWN");
            userService.save(user);
        }
        MoneyTransaction entity = new MoneyTransaction();
        entity.setUser(user);
        entity.setAmountBuy(message.getAmountBuy());
        entity.setAmountSell(message.getAmountSell());
        entity.setCurrencyFrom(message.getCurrencyFrom());
        entity.setCurrencyTo(message.getCurrencyTo());
        entity.setOriginatingCountry(message.getOriginatingCountry());
        entity.setRate(message.getRate());
        entity.setTimePlaced(new Timestamp(message.getTimePlaced().getTime()));

        moneyTransactionRepository.save(entity);
        return entity;
    }

}
