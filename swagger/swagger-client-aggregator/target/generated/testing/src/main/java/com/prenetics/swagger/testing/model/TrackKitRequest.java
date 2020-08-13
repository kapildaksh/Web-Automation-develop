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
import com.prenetics.swagger.testing.model.TrackKit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TrackKitRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-18T18:14:02.083+08:00")
public class TrackKitRequest {
  @SerializedName("track_kit")
  private TrackKit trackKit = null;

  public TrackKitRequest trackKit(TrackKit trackKit) {
    this.trackKit = trackKit;
    return this;
  }

   /**
   * Get trackKit
   * @return trackKit
  **/
  @ApiModelProperty(value = "")
  public TrackKit getTrackKit() {
    return trackKit;
  }

  public void setTrackKit(TrackKit trackKit) {
    this.trackKit = trackKit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackKitRequest trackKitRequest = (TrackKitRequest) o;
    return Objects.equals(this.trackKit, trackKitRequest.trackKit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trackKit);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrackKitRequest {\n");
    
    sb.append("    trackKit: ").append(toIndentedString(trackKit)).append("\n");
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
