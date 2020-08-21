package com.dw.departmentdictionary.service.impl;

import com.dw.departmentdictionary.domain.Department;
import com.dw.departmentdictionary.dto.DepartmentDto;
import com.dw.departmentdictionary.mapper.impl.DepartmentMapper;
import com.dw.departmentdictionary.repository.DepartmentRepository;
import com.dw.departmentdictionary.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements CommonService<DepartmentDto> {
    private DepartmentRepository repository;
    private DepartmentMapper mapper;

    @Autowired
    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<Department> departments = this.repository.findAll();
        return departments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getOneById(Integer id) {
        Department department = this.repository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Could not find department with id " + id));
        return this.mapToDto(department);
    }

    @Override
    public DepartmentDto save(DepartmentDto dto) {
        return this.mapToDto(this.repository.save(this.mapToDomain(dto)));
    }

    @Override
    public DepartmentDto update(Integer id, DepartmentDto department) {
        this.getOneById(id);
        department.setId(id);
        return this.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    public Department mapToDomain(DepartmentDto dto) {
        return this.mapper.mapToDomain(dto);
    }

    public DepartmentDto mapToDto(Department department) {
        return this.mapper.mapToDto(department);
    }

}
