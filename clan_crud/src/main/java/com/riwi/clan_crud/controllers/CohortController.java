package com.riwi.clan_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.clan_crud.entities.Cohort;
import com.riwi.clan_crud.services.abstractSrvs.ICohortService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/cohorts")
public class CohortController {

  @Autowired
  private final ICohortService iCohortService;

  @GetMapping
  public ResponseEntity<Page<Cohort>> getCohorts(
      @RequestParam(defaultValue = "1", required = false) Integer page,
      @RequestParam(defaultValue = "5", required = false) Integer size) {

    if (page < 1) {
      page = 1;
    }
    Pageable pageable = PageRequest.of(page - 1, size);

    return ResponseEntity.ok(this.iCohortService.read(pageable));
  }
}
