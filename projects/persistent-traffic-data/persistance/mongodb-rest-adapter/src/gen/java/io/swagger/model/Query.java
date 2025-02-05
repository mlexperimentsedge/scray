/*
 * Rest MongoDB example
 * Simple API to query MongoDB data
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Query
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-04-29T01:06:05.602Z")
public class Query   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("serverAddress")
  private String serverAddress = null;

  @JsonProperty("databaseName")
  private String databaseName = null;

  @JsonProperty("collectionName")
  private String collectionName = null;

  @JsonProperty("query")
  private String query = null;

  @JsonProperty("description")
  private String description = null;

  public Query id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty("id")
  @ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", required = true, value = "")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Query serverAddress(String serverAddress) {
    this.serverAddress = serverAddress;
    return this;
  }

  /**
   * Get serverAddress
   * @return serverAddress
   **/
  @JsonProperty("serverAddress")
  @ApiModelProperty(example = "127.0.0.1:27017", required = true, value = "")
  @NotNull
  public String getServerAddress() {
    return serverAddress;
  }

  public void setServerAddress(String serverAddress) {
    this.serverAddress = serverAddress;
  }

  public Query databaseName(String databaseName) {
    this.databaseName = databaseName;
    return this;
  }

  /**
   * Get databaseName
   * @return databaseName
   **/
  @JsonProperty("databaseName")
  @ApiModelProperty(example = "db1", required = true, value = "")
  @NotNull
  public String getDatabaseName() {
    return databaseName;
  }

  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }

  public Query collectionName(String collectionName) {
    this.collectionName = collectionName;
    return this;
  }

  /**
   * Get collectionName
   * @return collectionName
   **/
  @JsonProperty("collectionName")
  @ApiModelProperty(example = "col1", required = true, value = "")
  @NotNull
  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public Query query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
   **/
  @JsonProperty("query")
  @ApiModelProperty(example = "SELECT * FROM inventory WHERE status = \"D\"", required = true, value = "")
  @NotNull
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public Query description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @JsonProperty("description")
  @ApiModelProperty(example = "Super description", value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Query query = (Query) o;
    return Objects.equals(this.id, query.id) &&
        Objects.equals(this.serverAddress, query.serverAddress) &&
        Objects.equals(this.databaseName, query.databaseName) &&
        Objects.equals(this.collectionName, query.collectionName) &&
        Objects.equals(this.query, query.query) &&
        Objects.equals(this.description, query.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, serverAddress, databaseName, collectionName, query, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Query {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    serverAddress: ").append(toIndentedString(serverAddress)).append("\n");
    sb.append("    databaseName: ").append(toIndentedString(databaseName)).append("\n");
    sb.append("    collectionName: ").append(toIndentedString(collectionName)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

