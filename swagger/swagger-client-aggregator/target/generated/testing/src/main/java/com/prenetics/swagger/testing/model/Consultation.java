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
 * Consultation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-18T18:14:02.083+08:00")
public class Consultation {
  /**
   * booking status:   * &#x60;HOLD&#x60; - RESERVED, booking made   * &#x60;STOP&#x60; - CANCELLED, booking cancelled   * &#x60;DONE&#x60; - DONE, consultation finished   * &#x60;MISS&#x60; - MISSED, consultation is missed, should re-schedule again 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    STOP("STOP"),
    
    HOLD("HOLD"),
    
    DONE("DONE"),
    
    MISS("MISS");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  public Consultation status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * booking status:   * &#x60;HOLD&#x60; - RESERVED, booking made   * &#x60;STOP&#x60; - CANCELLED, booking cancelled   * &#x60;DONE&#x60; - DONE, consultation finished   * &#x60;MISS&#x60; - MISSED, consultation is missed, should re-schedule again 
   * @return status
  **/
  @ApiModelProperty(value = "booking status:   * `HOLD` - RESERVED, booking made   * `STOP` - CANCELLED, booking cancelled   * `DONE` - DONE, consultation finished   * `MISS` - MISSED, consultation is missed, should re-schedule again ")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Consultation consultation = (Consultation) o;
    return Objects.equals(this.status, consultation.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Consultation {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
