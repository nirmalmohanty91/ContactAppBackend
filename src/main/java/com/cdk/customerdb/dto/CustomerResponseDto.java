package com.cdk.customerdb.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {

  private Integer id;
  private String firstName;
  private String lastName;

}
