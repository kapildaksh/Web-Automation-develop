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
import com.prenetics.swagger.testing.model.Sleep;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SleepList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-18T18:14:02.083+08:00")
public class SleepList {
  @SerializedName("sleep_log_list")
  private List<Sleep> sleepLogList = null;

  public SleepList sleepLogList(List<Sleep> sleepLogList) {
    this.sleepLogList = sleepLogList;
    return this;
  }

  public SleepList addSleepLogListItem(Sleep sleepLogListItem) {
    if (this.sleepLogList == null) {
      this.sleepLogList = new ArrayList<Sleep>();
    }
    this.sleepLogList.add(sleepLogListItem);
    return this;
  }

   /**
   * Get sleepLogList
   * @return sleepLogList
  **/
  @ApiModelProperty(value = "")
  public List<Sleep> getSleepLogList() {
    return sleepLogList;
  }

  public void setSleepLogList(List<Sleep> sleepLogList) {
    this.sleepLogList = sleepLogList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SleepList sleepList = (SleepList) o;
    return Objects.equals(this.sleepLogList, sleepList.sleepLogList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sleepLogList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SleepList {\n");
    
    sb.append("    sleepLogList: ").append(toIndentedString(sleepLogList)).append("\n");
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

