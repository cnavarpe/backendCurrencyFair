package com.currencyfair.test.services;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.currencyfair.database.model.MoneyTransaction;
import com.currencyfair.database.model.support.CurrencySupport;
import com.currencyfair.model.json.EndpointMessage;
import com.currencyfair.services.MoneyTransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(value = "classpath:/application-context-test.xml")
public class MoneyTransactionServiceTest {
    @Autowired
    private MoneyTransactionService moneyTransactionService;

    @Test
    public void testSaveJSONInput() {
        Date now = new Date();
        EndpointMessage msg = new EndpointMessage();
        msg.setUserId(123);
        msg.setAmountBuy(BigInteger.valueOf(123l));
        msg.setAmountSell(BigInteger.valueOf(12l));
        msg.setCurrencyFrom(CurrencySupport.EUR);
        msg.setCurrencyTo(CurrencySupport.USD);
        msg.setOriginatingCountry("EIR");
        msg.setRate(12.3);
        msg.setTimePlaced(now);

        moneyTransactionService.save(msg);

        MoneyTransaction entity = moneyTransactionService.save(msg);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        assertEquals(entity.getUser().getId(), msg.getUserId());
        assertEquals(entity.getAmountBuy(), msg.getAmountBuy());
        assertEquals(entity.getAmountSell(), msg.getAmountSell());
        assertEquals(entity.getAmountBuy(), msg.getAmountBuy());
        assertEquals(entity.getCurrencyFrom(), msg.getCurrencyFrom());
        assertEquals(entity.getCurrencyTo(), msg.getCurrencyTo());
        assertEquals(entity.getOriginatingCountry(), msg.getOriginatingCountry());
        assertEquals(entity.getRate(), msg.getRate());

        // remove milliseconds
        assertEquals(df.format(entity.getTimePlaced()), df.format(msg.getTimePlaced()));

    }
}
