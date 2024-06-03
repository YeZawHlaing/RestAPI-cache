package com.example.cacheDemo.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "course")
@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", length = 20, nullable = false)
  private String name;


  @Column(name = "duration", length = 10, nullable = false)
  private String duration;

  @Column(name = "short_description", length = 100, nullable = false)
  private String shortDescription;

  @Column(name = "long_description", length = 500)
  private String longDescription;

}





