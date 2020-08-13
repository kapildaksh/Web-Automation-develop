/*
 * Testing Service API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * Contact: devops@prenetics.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.prenetics.swagger.testing.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Challenge
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-18T18:14:02.083+08:00")
public class Challenge {
  @SerializedName("h_account")
  private String hAccount = null;

  /**
   * Gets or Sets challengeType
   */
  @JsonAdapter(ChallengeTypeEnum.Adapter.class)
  public enum ChallengeTypeEnum {
    STEPS_CHALLENGE("steps_challenge"),
    
    MEALS_CHALLENGE("meals_challenge"),
    
    SLEEPS_CHALLENGE("sleeps_challenge");

    private String value;

    ChallengeTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ChallengeTypeEnum fromValue(String text) {
      for (ChallengeTypeEnum b : ChallengeTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ChallengeTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChallengeTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChallengeTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ChallengeTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("challengeType")
  private ChallengeTypeEnum challengeType = null;

  @SerializedName("completedDays")
  private Integer completedDays = null;

  @SerializedName("totalDays")
  private Integer totalDays = null;

  @SerializedName("startDateUtc")
  private String startDateUtc = null;

  @SerializedName("isActive")
  private Boolean isActive = null;

  @SerializedName("isEnded")
  private Boolean isEnded = null;

  @SerializedName("isManualTrigger")
  private Boolean isManualTrigger = null;

  @SerializedName("hasSuccessNotified")
  private Boolean hasSuccessNotified = null;

  @SerializedName("hasFailNotified")
  private Boolean hasFailNotified = null;

  @SerializedName("hasStartNotified")
  private Boolean hasStartNotified = null;

  @SerializedName("order")
  private Integer order = null;

  public Challenge hAccount(String hAccount) {
    this.hAccount = hAccount;
    return this;
  }

   /**
   * Get hAccount
   * @return hAccount
  **/
  @ApiModelProperty(value = "")
  public String getHAccount() {
    return hAccount;
  }

  public void setHAccount(String hAccount) {
    this.hAccount = hAccount;
  }

  public Challenge challengeType(ChallengeTypeEnum challengeType) {
    this.challengeType = challengeType;
    return this;
  }

   /**
   * Get challengeType
   * @return challengeType
  **/
  @ApiModelProperty(value = "")
  public ChallengeTypeEnum getChallengeType() {
    return challengeType;
  }

  public void setChallengeType(ChallengeTypeEnum challengeType) {
    this.challengeType = challengeType;
  }

  public Challenge completedDays(Integer completedDays) {
    this.completedDays = completedDays;
    return this;
  }

   /**
   * Get completedDays
   * @return completedDays
  **/
  @ApiModelProperty(value = "")
  public Integer getCompletedDays() {
    return completedDays;
  }

  public void setCompletedDays(Integer completedDays) {
    this.completedDays = completedDays;
  }

  public Challenge totalDays(Integer totalDays) {
    this.totalDays = totalDays;
    return this;
  }

   /**
   * Get totalDays
   * @return totalDays
  **/
  @ApiModelProperty(value = "")
  public Integer getTotalDays() {
    return totalDays;
  }

  public void setTotalDays(Integer totalDays) {
    this.totalDays = totalDays;
  }

  public Challenge startDateUtc(String startDateUtc) {
    this.startDateUtc = startDateUtc;
    return this;
  }

   /**
   * YYYY-MM-DDTHH:mm:ssZ
   * @return startDateUtc
  **/
  @ApiModelProperty(example = "2018-02-20T20:00:00+08:00", value = "YYYY-MM-DDTHH:mm:ssZ")
  public String getStartDateUtc() {
    return startDateUtc;
  }

  public void setStartDateUtc(String startDateUtc) {
    this.startDateUtc = startDateUtc;
  }

  public Challenge isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

   /**
   * Get isActive
   * @return isActive
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Challenge isEnded(Boolean isEnded) {
    this.isEnded = isEnded;
    return this;
  }

   /**
   * Get isEnded
   * @return isEnded
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsEnded() {
    return isEnded;
  }

  public void setIsEnded(Boolean isEnded) {
    this.isEnded = isEnded;
  }

  public Challenge isManualTrigger(Boolean isManualTrigger) {
    this.isManualTrigger = isManualTrigger;
    return this;
  }

   /**
   * Get isManualTrigger
   * @return isManualTrigger
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsManualTrigger() {
    return isManualTrigger;
  }

  public void setIsManualTrigger(Boolean isManualTrigger) {
    this.isManualTrigger = isManualTrigger;
  }

  public Challenge hasSuccessNotified(Boolean hasSuccessNotified) {
    this.hasSuccessNotified = hasSuccessNotified;
    return this;
  }

   /**
   * Get hasSuccessNotified
   * @return hasSuccessNotified
  **/
  @ApiModelProperty(value = "")
  public Boolean isHasSuccessNotified() {
    return hasSuccessNotified;
  }

  public void setHasSuccessNotified(Boolean hasSuccessNotified) {
    this.hasSuccessNotified = hasSuccessNotified;
  }

  public Challenge hasFailNotified(Boolean hasFailNotified) {
    this.hasFailNotified = hasFailNotified;
    return this;
  }

   /**
   * Get hasFailNotified
   * @return hasFailNotified
  **/
  @ApiModelProperty(value = "")
  public Boolean isHasFailNotified() {
    return hasFailNotified;
  }

  public void setHasFailNotified(Boolean hasFailNotified) {
    this.hasFailNotified = hasFailNotified;
  }

  public Challenge hasStartNotified(Boolean hasStartNotified) {
    this.hasStartNotified = hasStartNotified;
    return this;
  }

   /**
   * Get hasStartNotified
   * @return hasStartNotified
  **/
  @ApiModelProperty(value = "")
  public Boolean isHasStartNotified() {
    return hasStartNotified;
  }

  public void setHasStartNotified(Boolean hasStartNotified) {
    this.hasStartNotified = hasStartNotified;
  }

  public Challenge order(Integer order) {
    this.order = order;
    return this;
  }

   /**
   * Get order
   * @return order
  **/
  @ApiModelProperty(value = "")
  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Challenge challenge = (Challenge) o;
    return Objects.equals(this.hAccount, challenge.hAccount) &&
        Objects.equals(this.challengeType, challenge.challengeType) &&
        Objects.equals(this.completedDays, challenge.completedDays) &&
        Objects.equals(this.totalDays, challenge.totalDays) &&
        Objects.equals(this.startDateUtc, challenge.startDateUtc) &&
        Objects.equals(this.isActive, challenge.isActive) &&
        Objects.equals(this.isEnded, challenge.isEnded) &&
        Objects.equals(this.isManualTrigger, challenge.isManualTrigger) &&
        Objects.equals(this.hasSuccessNotified, challenge.hasSuccessNotified) &&
        Objects.equals(this.hasFailNotified, challenge.hasFailNotified) &&
        Objects.equals(this.hasStartNotified, challenge.hasStartNotified) &&
        Objects.equals(this.order, challenge.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hAccount, challengeType, completedDays, totalDays, startDateUtc, isActive, isEnded, isManualTrigger, hasSuccessNotified, hasFailNotified, hasStartNotified, order);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Challenge {\n");
    
    sb.append("    hAccount: ").append(toIndentedString(hAccount)).append("\n");
    sb.append("    challengeType: ").append(toIndentedString(challengeType)).append("\n");
    sb.append("    completedDays: ").append(toIndentedString(completedDays)).append("\n");
    sb.append("    totalDays: ").append(toIndentedString(totalDays)).append("\n");
    sb.append("    startDateUtc: ").append(toIndentedString(startDateUtc)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    isEnded: ").append(toIndentedString(isEnded)).append("\n");
    sb.append("    isManualTrigger: ").append(toIndentedString(isManualTrigger)).append("\n");
    sb.append("    hasSuccessNotified: ").append(toIndentedString(hasSuccessNotified)).append("\n");
    sb.append("    hasFailNotified: ").append(toIndentedString(hasFailNotified)).append("\n");
    sb.append("    hasStartNotified: ").append(toIndentedString(hasStartNotified)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

