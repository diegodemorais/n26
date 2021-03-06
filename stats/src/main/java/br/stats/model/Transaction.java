package br.stats.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Transaction
 */
@Validated
public class Transaction   {
  private Double amount = null;

  private LocalDateTime date = null;
  
  public Transaction(){
  }
  
  public Transaction(Double amount, LocalDateTime date) {
	  setAmount(amount);
	  setDate(date);
  }
  
  
  public Transaction amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Transaction date(LocalDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  **/


  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.date, transaction.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

