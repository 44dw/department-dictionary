package com.dw.departmentdictionary.service;

import com.dw.departmentdictionary.mapper.CommonMapper;
import com.dw.departmentdictionary.mapper.Mappable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AbstractCommonService<Domain, Dto> implements CommonService<Dto>, Mappable<Domain, Dto> {
    protected JpaRepository<Domain, Integer> repository;
    protected CommonMapper<Domain, Dto> mapper;

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

    public List<Dto> getAllWithSpec(Specification<Domain> specification) {
        List<Domain> domains = ((JpaSpecificationExecutor<Domain>) repository).findAll(specification);
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
        this.validateCreation(dto);
        return this.mapToDto(this.repository.save(this.mapToDomain(dto)));
    }

    @Override
    public Dto update(Dto dto) {
        return this.save(dto);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Domain> domainOptional = this.repository.findById(id);
        if (domainOptional.isPresent()) {
            this.validateDeletion(this.mapToDto(domainOptional.get()));
            this.repository.deleteById(id);
        }
    }

    @Override
    public Domain mapToDomain(Dto dto) {
        return this.mapper.mapToDomain(dto);
    }

    @Override
    public Dto mapToDto(Domain domain) {
        return this.mapper.mapToDto(domain);
    }

    protected void validateCreation(Dto dto) {

    }

    protected void validateDeletion(Dto dto) {

    }
}
