package com.dw.departmentdictionary.service.impl;

import com.dw.departmentdictionary.domain.Department;
import com.dw.departmentdictionary.dto.DepartmentDto;
import com.dw.departmentdictionary.mapper.impl.DepartmentMapper;
import com.dw.departmentdictionary.repository.DepartmentRepository;
import com.dw.departmentdictionary.service.AbstractCommonService;
import com.dw.departmentdictionary.validator.CommonValidator;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends AbstractCommonService<Department, DepartmentDto> {

    private CommonValidator<DepartmentDto> departmentValidator;

    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper, CommonValidator<DepartmentDto> departmentValidator) {
        super(repository, mapper);
        this.departmentValidator = departmentValidator;
    }

    @Override
    protected void validate(DepartmentDto departmentDto) {
        this.departmentValidator.validate(departmentDto);
    }
}
