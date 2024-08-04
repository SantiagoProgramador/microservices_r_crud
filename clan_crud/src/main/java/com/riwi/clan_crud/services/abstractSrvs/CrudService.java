package com.riwi.clan_crud.services.abstractSrvs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<RQ, RS, ID> {
  RS create(RQ rq);

  RS update(RQ rq, ID id);

  void delete(ID id);

  Page<RS> read(Pageable pageable);

}
