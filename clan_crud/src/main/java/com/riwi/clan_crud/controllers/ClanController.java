package com.riwi.clan_crud.controllers;

import java.net.http.HttpClient.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.clan_crud.dto.request.ClanRequest;
import com.riwi.clan_crud.dto.request.ClanUpdateRequest;
import com.riwi.clan_crud.entities.Clan;
import com.riwi.clan_crud.services.abstractSrvs.IClanService;
import com.riwi.clan_crud.utils.enums.ClanSortCriteria;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/clans")
public class ClanController {
  @Autowired
  private final IClanService iClanService;

  private ResponseEntity<Object> isPageEmpty(Page<Clan> page) {
    if (page.isEmpty()) {
      return new ResponseEntity<>("Theres no elements to show", HttpStatus.OK);
    }
    return new ResponseEntity<>(page, HttpStatus.OK);

  }

  @GetMapping
  public ResponseEntity<Object> showClans(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String description,
      @RequestParam(required = false) Boolean isActive,
      @RequestParam(required = false) ClanSortCriteria sortCriteria,
      @RequestParam(required = false, defaultValue = "1") Integer page,
      @RequestParam(required = false, defaultValue = "3") Integer size) {

    if (page < 1) {
      page = 1;
    }
    if (sortCriteria == null) {
      sortCriteria = ClanSortCriteria.ID;
    }
    Sort sort = Sort.by(sortCriteria.getDirection(), sortCriteria.getField());
    Pageable pageable = PageRequest.of(page - 1, size, sort);

    switch (sortCriteria) {
      case ID:
        return isPageEmpty(iClanService.read(pageable));

      case NAME:
        return isPageEmpty(iClanService.readByName(pageable, name));

      case DESCRIPTION:
        return isPageEmpty(iClanService.readByDescription(pageable, description));

      case IS_ACTIVE:
        return isPageEmpty(iClanService.readByIsActive(pageable, isActive));
    }
    return isPageEmpty(iClanService.read(pageable));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<Clan> createClan(@RequestBody ClanRequest clanRequest) {
    return ResponseEntity.ok(this.iClanService.create(clanRequest));
  }

  @PutMapping(path = "/update/{id}")
  public ResponseEntity<Clan> updateClan(@PathVariable Long id, @RequestBody ClanRequest clanRequest) {

    return ResponseEntity.ok(this.iClanService.update(clanRequest, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteClan(@PathVariable Long id, @RequestBody ClanUpdateRequest clanUpdateRequest) {
    this.iClanService.disableClan(id, clanUpdateRequest);
    return ResponseEntity.ok().build();
  }

}
