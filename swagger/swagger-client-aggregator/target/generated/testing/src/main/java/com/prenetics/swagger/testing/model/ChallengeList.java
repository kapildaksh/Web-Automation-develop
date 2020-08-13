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
import com.prenetics.swagger.testing.model.Challenge;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ChallengeList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-18T18:14:02.083+08:00")
public class ChallengeList {
  @SerializedName("challenge_list")
  private List<Challenge> challengeList = null;

  public ChallengeList challengeList(List<Challenge> challengeList) {
    this.challengeList = challengeList;
    return this;
  }

  public ChallengeList addChallengeListItem(Challenge challengeListItem) {
    if (this.challengeList == null) {
      this.challengeList = new ArrayList<Challenge>();
    }
    this.challengeList.add(challengeListItem);
    return this;
  }

   /**
   * Get challengeList
   * @return challengeList
  **/
  @ApiModelProperty(value = "")
  public List<Challenge> getChallengeList() {
    return challengeList;
  }

  public void setChallengeList(List<Challenge> challengeList) {
    this.challengeList = challengeList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChallengeList challengeList = (ChallengeList) o;
    return Objects.equals(this.challengeList, challengeList.challengeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(challengeList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChallengeList {\n");
    
    sb.append("    challengeList: ").append(toIndentedString(challengeList)).append("\n");
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

