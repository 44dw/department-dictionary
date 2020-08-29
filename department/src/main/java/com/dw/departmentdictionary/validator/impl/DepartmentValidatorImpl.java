package com.dw.departmentdictionary.validator.impl;

import com.dw.departmentdictionary.domain.Department;
import com.dw.departmentdictionary.dto.DepartmentDto;
import com.dw.departmentdictionary.repository.DepartmentRepository;
import com.dw.departmentdictionary.validator.CommonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.util.Objects;
import java.util.Optional;

@Component
public class DepartmentValidatorImpl implements CommonValidator<DepartmentDto> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void validate(DepartmentDto department) {
        this.validateRootDepartment(department.getRootDepartment());
        this.validateName(department.getName());
    }

    private void validateName(String name) {
        Optional<Department> byName = this.departmentRepository.findOneByName(name);
        if (byName.isPresent()) {
            throw new ValidationException("Department name must be unique");
        }
    }

    private void validateRootDepartment(Department rootDepartment) {
        if (Objects.nonNull(rootDepartment)) {
            return;
        }
        Optional<Department> rootDepartmentOptional = this.departmentRepository.findOneByRootDepartmentIsNull();
        if (rootDepartmentOptional.isPresent()) {
            throw new ValidationException("Please fill root department!");
        }
    }
}
