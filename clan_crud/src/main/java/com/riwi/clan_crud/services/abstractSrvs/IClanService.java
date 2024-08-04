package com.riwi.clan_crud.services.abstractSrvs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.clan_crud.dto.request.ClanRequest;
import com.riwi.clan_crud.dto.request.ClanUpdateRequest;
import com.riwi.clan_crud.entities.Clan;

public interface IClanService extends CrudService<ClanRequest, Clan, Long> {

  public Page<Clan> readByName(Pageable pageable, String keyword);

  public Page<Clan> readByDescription(Pageable pageable, String keyword);

  public Page<Clan> readByIsActive(Pageable pageable, Boolean isActive);

  public Clan findClan(Long id);

  public void disableClan(Long id, ClanUpdateRequest clanUpdateRequest);

}
