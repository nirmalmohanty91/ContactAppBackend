package com.cdk.customerdb.dto;

import com.cdk.customerdb.util.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto implements Serializable {

  @NotBlank(message = "firstName should not be empty")
  private String firstName;

  @NotBlank(message = "lastName should not be empty")
  private String lastName;

  //@NotBlank(message = "dateOfBirth should not be empty")---NotNull change
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDateTime dateOfBirth;

  @NotBlank(message = "email should not be empty")
  private String email;

  @NotBlank(message = "gender should not be empty")
  private String gender;

}
