package com.cdk.customerdb.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@Table(name = "customer_information_test")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntityTest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

}
