package com.currencyfair.model.json;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;



import com.currencyfair.database.model.support.CurrencySupport;
import com.currencyfair.util.CustomJsonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class EndpointMessage {

    /** Id from the user who makes the transaction in the database */
    @JsonProperty("userId")
    @NotNull
    @Min(0)
    private Integer userId;

    /** currency the original transaction is */
    @JsonProperty("currencyFrom")
    @NotNull
    private CurrencySupport currencyFrom;

    /** currency conversion in the transaction */
    @JsonProperty("currencyTo")
    @NotNull
    private CurrencySupport currencyTo;

    @JsonProperty("amountSell")
    @NotNull
    @Min(0)
    private BigInteger amountSell;

    @JsonProperty("amountBuy")
    @NotNull
    @Min(0)
    private BigInteger amountBuy;

    @JsonProperty("rate")
    @NotNull
    private Double rate;

    @JsonProperty("timePlaced")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @NotNull
    private Date timePlaced;

    /**
     * it can be used a String with validation or an enum, since I do not have
     * the list of values I will use an open String
     */
    @JsonProperty("originatingCountry")
    @NotBlank
    private String originatingCountry;

    public EndpointMessage() {

    }

    public Integer getUserId() {
        return userId;
    }

    public CurrencySupport getCurrencyFrom() {
        return currencyFrom;
    }

    public CurrencySupport getCurrencyTo() {
        return currencyTo;
    }

    public BigInteger getAmountSell() {
        return amountSell;
    }

    public BigInteger getAmountBuy() {
        return amountBuy;
    }

    public Double getRate() {
        return rate;
    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCurrencyFrom(CurrencySupport currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public void setCurrencyTo(CurrencySupport currencyTo) {
        this.currencyTo = currencyTo;
    }

    public void setAmountSell(BigInteger amountSell) {
        this.amountSell = amountSell;
    }

    public void setAmountBuy(BigInteger amountBuy) {
        this.amountBuy = amountBuy;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amountBuy == null) ? 0 : amountBuy.hashCode());
        result = prime * result + ((amountSell == null) ? 0 : amountSell.hashCode());
        result = prime * result + ((currencyFrom == null) ? 0 : currencyFrom.hashCode());
        result = prime * result + ((currencyTo == null) ? 0 : currencyTo.hashCode());
        result = prime * result + ((originatingCountry == null) ? 0 : originatingCountry.hashCode());
        result = prime * result + ((rate == null) ? 0 : rate.hashCode());
        result = prime * result + ((timePlaced == null) ? 0 : timePlaced.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
        EndpointMessage other = (EndpointMessage) obj;
        if (amountBuy == null) {
            if (other.amountBuy != null)
                return false;
        } else if (!amountBuy.equals(other.amountBuy))
            return false;
        if (amountSell == null) {
            if (other.amountSell != null)
                return false;
        } else if (!amountSell.equals(other.amountSell))
            return false;
        if (currencyFrom != other.currencyFrom)
            return false;
        if (currencyTo != other.currencyTo)
            return false;
        if (originatingCountry == null) {
            if (other.originatingCountry != null)
                return false;
        } else if (!originatingCountry.equals(other.originatingCountry))
            return false;
        if (rate == null) {
            if (other.rate != null)
                return false;
        } else if (!rate.equals(other.rate))
            return false;
        if (timePlaced == null) {
            if (other.timePlaced != null)
                return false;
        } else if (!timePlaced.equals(other.timePlaced))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EndpointMessage [userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
                + ", amountSell=" + amountSell + ", amountBuy=" + amountBuy + ", rate=" + rate + ", timePlaced="
                + timePlaced + ", originatingCountry=" + originatingCountry + "]";
    }

}
