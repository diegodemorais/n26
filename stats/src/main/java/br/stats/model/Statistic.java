package br.stats.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.stats.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;

/**
 * Statistic
 */
@Validated

public class Statistic   {
  @JsonProperty("sum")
  private Double sum = null;

  @JsonProperty("avg")
  private Double avg = null;

  @JsonProperty("max")
  private Double max = null;

  @JsonProperty("min")
  private Double min = null;

  @JsonProperty("count")
  private Long count = null;
  
  private LocalDateTime dateTime = null;

  public Statistic() {
		setDateTime(LocalDateTime.now());
		setSum(0d);
		setAvg(0d);
		setMax(Double.MIN_VALUE);
		setMin(Double.MAX_VALUE);
		setCount(0l);
  }
  
  public Statistic dateTime(LocalDateTime dateTime) {
	    this.dateTime = dateTime;
	    return this;
  }
  
  public LocalDateTime getDateTime() {
	  return dateTime;
  }
  
  public void setDateTime(LocalDateTime dateTime) {
	  this.dateTime = dateTime;
  }
  
  public Statistic sum(Double sum) {
    this.sum = sum;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Double getSum() {
    return sum;
  }

  public void setSum(Double sum) {
    this.sum = sum;
  }

  public Statistic avg(Double avg) {
    this.avg = avg;
    return this;
  }

  /**
   * Get avg
   * @return avg
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getAvg() {
    return avg;
  }

  public void setAvg(Double avg) {
    this.avg = avg;
  }

  public Statistic max(Double max) {
    this.max = max;
    return this;
  }

  /**
   * Get max
   * @return max
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getMax() {
    return max;
  }

  public void setMax(Double max) {
    this.max = max;
  }

  public Statistic min(Double min) {
    this.min = min;
    return this;
  }

  /**
   * Get min
   * @return min
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getMin() {
    return min;
  }

  public void setMin(Double min) {
    this.min = min;
  }

  public Statistic count(Long count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statistic statistic = (Statistic) o;
    return Objects.equals(this.sum, statistic.sum) &&
        Objects.equals(this.avg, statistic.avg) &&
        Objects.equals(this.max, statistic.max) &&
        Objects.equals(this.min, statistic.min) &&
        Objects.equals(this.count, statistic.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sum, avg, max, min, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Statistic {\n");
    
    sb.append("    sum: ").append(toIndentedString(sum)).append("\n");
    sb.append("    avg: ").append(toIndentedString(avg)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

