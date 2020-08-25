package com.dw.departmentdictionary.mapper;

public interface CommonMapper<Domain, Dto> {
    Domain mapToDomain(Dto dto);
    Dto mapToDto(Domain domain);
}
