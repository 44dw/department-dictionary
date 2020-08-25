package com.dw.departmentdictionary.mapper;

public interface Mappable<Domain, Dto> {
    Domain mapToDomain(Dto dto);
    Dto mapToDto(Domain domain);
}
