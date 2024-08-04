package com.riwi.clan_crud.utils.enums;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClanSortCriteria {
  ID("id", Sort.Direction.ASC),
  NAME("name", Sort.Direction.ASC),
  DESCRIPTION("description", Sort.Direction.ASC),
  IS_ACTIVE("isActive", Sort.Direction.ASC);

  private final String field;
  private final Sort.Direction direction;
}
