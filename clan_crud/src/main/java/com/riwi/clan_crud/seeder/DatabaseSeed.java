package com.riwi.clan_crud.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.riwi.clan_crud.entities.Cohort;
import com.riwi.clan_crud.repositories.CohortRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseSeed implements CommandLineRunner {
  @Autowired
  private final CohortRepository cohortRepository;

  @Override
  public void run(String... args) throws Exception {
    log.info("Seeding database with cohorts...");

    if (cohortRepository.count() > 0)
      return;

    Cohort cohort1 = Cohort.builder().name("Meta").build();
    Cohort cohort2 = Cohort.builder().name("Alpha").build();
    Cohort cohort3 = Cohort.builder().name("Lowe lace").build();

    cohortRepository.save(cohort1); 
    cohortRepository.save(cohort2);
    cohortRepository.save(cohort3);

  }

}
