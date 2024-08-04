package com.riwi.clan_crud.services.abstractSrvs;

import com.riwi.clan_crud.dto.request.CohortRequest;
import com.riwi.clan_crud.entities.Cohort;

public interface ICohortService extends CrudService<CohortRequest, Cohort, Long> {

  public Cohort findCohort(Long id);
}
