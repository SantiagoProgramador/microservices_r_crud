package com.riwi.clan_crud.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.clan_crud.entities.Clan;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {

  Page<Clan> findByNameContaining(Pageable pageable, String keyword);

  Page<Clan> findByDescriptionContaining(Pageable pageable, String keyword);

  Page<Clan> findAllByIsActive(Pageable pageable, Boolean isActive);

}
