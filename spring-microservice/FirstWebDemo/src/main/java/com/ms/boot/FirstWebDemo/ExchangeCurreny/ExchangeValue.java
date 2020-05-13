package com.ms.boot.FirstWebDemo.ExchangeCurreny;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
  
  @Id
  private Long id;
  
  @Column(name="currency_from")
  private String from;
  
  @Column(name="currency_to")
  private String to;
  
  private BigDecimal conversionMultiple;
  private int port;
  
  private BigDecimal quantity;
  private BigDecimal totalCalculatedAmount;
  
  public BigDecimal getTotalCalculatedAmount() {
	return totalCalculatedAmount;
}


public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
	this.totalCalculatedAmount = totalCalculatedAmount;
}


public BigDecimal getQuantity() {
	return quantity;
}


public void setQuantity(BigDecimal quantity) {
	this.quantity = quantity;
}


public ExchangeValue() {
    
  }
  

  public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
    super();
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }
  public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
	      BigDecimal totalCalculatedAmount, int port) {
	    super();
	    this.id = id;
	    this.from = from;
	    this.to = to;
	    this.conversionMultiple = conversionMultiple;
	    this.quantity = quantity;
	    this.totalCalculatedAmount = totalCalculatedAmount;
	    this.port = port;
	  }

  public Long getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }
  
  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

}