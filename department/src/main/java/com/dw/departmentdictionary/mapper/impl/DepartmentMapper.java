package com.dw.departmentdictionary.mapper.impl;

import com.dw.departmentdictionary.domain.Department;
import com.dw.departmentdictionary.dto.DepartmentDto;
import com.dw.departmentdictionary.mapper.CommonMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DepartmentMapper implements CommonMapper<Department, DepartmentDto> {

    @Override
    public Department mapToDomain(DepartmentDto departmentDto) {
        if (Objects.isNull(departmentDto)) {
            return null;
        }
        return new Department(departmentDto.getId(), departmentDto.getName(), this.mapToDomain(departmentDto.getRootDepartment()));
    }

    @Override
    public DepartmentDto mapToDto(Department department) {
        if (Objects.isNull(department)) {
            return null;
        }
        return new DepartmentDto(department.getId(), department.getName(), this.mapToDto(department.getRootDepartment()));
    }
}
