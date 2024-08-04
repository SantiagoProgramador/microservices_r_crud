package com.riwi.clan_crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.clan_crud.dto.request.CohortRequest;
import com.riwi.clan_crud.entities.Cohort;
import com.riwi.clan_crud.repositories.CohortRepository;
import com.riwi.clan_crud.services.abstractSrvs.ICohortService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CohortService implements ICohortService {

  @Autowired
  private final CohortRepository cohortRepository;

  @Override
  public Cohort create(CohortRequest rq) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public Cohort update(CohortRequest rq, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public Page<Cohort> read(Pageable pageable) {

    return this.cohortRepository.findAll(pageable);
  }

  @Override
  public Cohort findCohort(Long id) {

    return this.cohortRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
