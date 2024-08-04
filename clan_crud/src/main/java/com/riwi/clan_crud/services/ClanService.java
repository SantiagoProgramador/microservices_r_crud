package com.riwi.clan_crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.clan_crud.dto.request.ClanRequest;
import com.riwi.clan_crud.dto.request.ClanUpdateRequest;
import com.riwi.clan_crud.entities.Clan;
import com.riwi.clan_crud.entities.Cohort;
import com.riwi.clan_crud.repositories.ClanRepository;
import com.riwi.clan_crud.services.abstractSrvs.IClanService;
import com.riwi.clan_crud.services.abstractSrvs.ICohortService;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClanService implements IClanService {

  @Autowired
  private final ClanRepository clanRepository;

  @Autowired
  private final ICohortService iCohortService;

  @Override
  public Clan create(ClanRequest rq) {
    Cohort cohort = iCohortService.findCohort(rq.getCohortId());

    Clan clan = Clan.builder()
        .name(rq.getName())
        .description(rq.getDescription())
        .cohort(cohort)
        .build();

    return clanRepository.save(clan);
  }

  @Override
  public Clan update(ClanRequest rq, Long id) {
    Clan clan = findClan(id);

    if (rq.getCohortId() != clan.getCohort().getId()) {
      Cohort cohort = iCohortService.findCohort(rq.getCohortId());
      clan.setCohort(cohort);
    }
    clan.builder()
        .name(rq.getName())
        .description(rq.getDescription())
        .build();
    clan.setUpdatedAt(LocalDateTime.now());

    return clanRepository.save(clan);
  }

  @Override
  public Clan findClan(Long id) {
    return this.clanRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  @Override
  public void delete(Long id) {
    Clan clan = findClan(id);
    clanRepository.delete(clan);
  }

  @Override
  public Page<Clan> read(Pageable pageable) {

    return this.clanRepository.findAll(pageable);
  }

  @Override
  public Page<Clan> readByName(Pageable pageable, String keyword) {

    return this.clanRepository.findByNameContaining(pageable, keyword);
  }

  @Override
  public Page<Clan> readByDescription(Pageable pageable, String keyword) {

    return this.clanRepository.findByDescriptionContaining(pageable, keyword);
  }

  @Override
  public Page<Clan> readByIsActive(Pageable pageable, Boolean isActive) {

    return this.clanRepository.findAllByIsActive(pageable, isActive);
  }

  @Override
  public void disableClan(Long id, ClanUpdateRequest clanUpdateRequest) {
    Clan clan = findClan(id);
    clan.setIsActive(clanUpdateRequest.getIsActive());
    clan.setUpdatedAt(LocalDateTime.now());
    this.clanRepository.save(clan);
  }

}
