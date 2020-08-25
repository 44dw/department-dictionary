package com.dw.departmentdictionary.service.impl;

import com.dw.departmentdictionary.domain.Department;
import com.dw.departmentdictionary.dto.DepartmentDto;
import com.dw.departmentdictionary.mapper.impl.DepartmentMapper;
import com.dw.departmentdictionary.repository.DepartmentRepository;
import com.dw.departmentdictionary.service.AbstractCommonService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends AbstractCommonService<Department, DepartmentDto> {

    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper) {
        super(repository, mapper);
    }
}
