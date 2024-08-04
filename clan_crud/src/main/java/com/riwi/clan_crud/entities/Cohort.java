package com.riwi.clan_crud.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cohorts")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cohort {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;
  @Column
  private LocalDateTime createdAt;
  @Column
  private LocalDateTime updatedAt;
  @Column
  @Builder.Default
  private boolean isActive = true;

  @OneToMany
  private List<Clan> clans;
}
