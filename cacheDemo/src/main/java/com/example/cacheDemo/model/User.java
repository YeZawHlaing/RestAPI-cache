package com.example.cacheDemo.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Random;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", length = 20, nullable = false)
  private String name;

  @Column(name = "email", length = 50, nullable = false, unique = true)
  private String email;

  @Column(name = "password", length = 50, nullable = false)
  private String password;

  @Column(name = "phone_number", length = 12, nullable = false, unique = true)
  private String phoneNumber;

  @Column(name = "age")
  private int age;

  @Temporal(TemporalType.DATE)
  @Column(name = "dob")
  private LocalDate dob;


  @Column(name = "address", length = 80)
  private String address;


  @PrePersist
  @PreUpdate
  public void generateUserId() {
    Random random = new Random();
    int r1 = random.nextInt();
    int r2 = random.nextInt();
    id = (long) r1 * r2;
  }
}
