package com.riwi.clan_crud.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity(name = "clans")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String description;
  @Column
  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();
  @Column
  private LocalDateTime updatedAt;
  @Column
  @Builder.Default
  private Boolean isActive = true;
  @ManyToOne
  @JoinColumn(name = "cohort_id", referencedColumnName = "id")
  private Cohort cohort;
}
