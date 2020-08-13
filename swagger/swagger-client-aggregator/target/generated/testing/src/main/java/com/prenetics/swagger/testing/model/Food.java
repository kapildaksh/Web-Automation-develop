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
 * Food
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-18T18:14:02.083+08:00")
public class Food {
  @SerializedName("serviceAccount")
  private String serviceAccount = null;

  @SerializedName("imageDescription")
  private String imageDescription = null;

  @SerializedName("image_url")
  private String imageUrl = null;

  @SerializedName("rate")
  private Integer rate = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("calories")
  private Integer calories = null;

  public Food serviceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
    return this;
  }

   /**
   * Get serviceAccount
   * @return serviceAccount
  **/
  @ApiModelProperty(value = "")
  public String getServiceAccount() {
    return serviceAccount;
  }

  public void setServiceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
  }

  public Food imageDescription(String imageDescription) {
    this.imageDescription = imageDescription;
    return this;
  }

   /**
   * Get imageDescription
   * @return imageDescription
  **/
  @ApiModelProperty(value = "")
  public String getImageDescription() {
    return imageDescription;
  }

  public void setImageDescription(String imageDescription) {
    this.imageDescription = imageDescription;
  }

  public Food imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

   /**
   * Get imageUrl
   * @return imageUrl
  **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Food rate(Integer rate) {
    this.rate = rate;
    return this;
  }

   /**
   * Get rate
   * @return rate
  **/
  @ApiModelProperty(value = "")
  public Integer getRate() {
    return rate;
  }

  public void setRate(Integer rate) {
    this.rate = rate;
  }

  public Food createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * YYYY-MM-DDTHH:mm:ssZ
   * @return createdAt
  **/
  @ApiModelProperty(example = "2018-02-20T20:00:00+08:00", value = "YYYY-MM-DDTHH:mm:ssZ")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Food calories(Integer calories) {
    this.calories = calories;
    return this;
  }

   /**
   * Get calories
   * @return calories
  **/
  @ApiModelProperty(value = "")
  public Integer getCalories() {
    return calories;
  }

  public void setCalories(Integer calories) {
    this.calories = calories;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Food food = (Food) o;
    return Objects.equals(this.serviceAccount, food.serviceAccount) &&
        Objects.equals(this.imageDescription, food.imageDescription) &&
        Objects.equals(this.imageUrl, food.imageUrl) &&
        Objects.equals(this.rate, food.rate) &&
        Objects.equals(this.createdAt, food.createdAt) &&
        Objects.equals(this.calories, food.calories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceAccount, imageDescription, imageUrl, rate, createdAt, calories);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Food {\n");
    
    sb.append("    serviceAccount: ").append(toIndentedString(serviceAccount)).append("\n");
    sb.append("    imageDescription: ").append(toIndentedString(imageDescription)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    calories: ").append(toIndentedString(calories)).append("\n");
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
