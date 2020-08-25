package com.dw.departmentdictionary.service;

import com.dw.departmentdictionary.mapper.CommonMapper;
import com.dw.departmentdictionary.mapper.Mappable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AbstractCommonService<Domain, Dto> implements CommonService<Dto>, Mappable<Domain, Dto> {
    private JpaRepository<Domain, Integer> repository;
    private CommonMapper<Domain, Dto> mapper;

    @Autowired
    public AbstractCommonService(JpaRepository<Domain, Integer> repository, CommonMapper<Domain, Dto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Dto> getAll() {
        List<Domain> domains = this.repository.findAll();
        return domains.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    @Override
    public Dto getOneById(Integer id) {
        Domain domain = this.repository.findById(id).orElseThrow(()
                -> new IllegalArgumentException(String.format("Could not find instance with id %s", id)));
        return this.mapToDto(domain);
    }

    @Override
    public Dto save(Dto dto) {
        return this.mapToDto(this.repository.save(this.mapToDomain(dto)));
    }

    @Override
    public Dto update(Dto dto) {
        return this.save(dto);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public Domain mapToDomain(Dto dto) {
        return this.mapper.mapToDomain(dto);
    }

    @Override
    public Dto mapToDto(Domain domain) {
        return this.mapper.mapToDto(domain);
    }
}
