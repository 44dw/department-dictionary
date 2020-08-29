package com.dw.departmentdictionary.api.feign.fallback;

import com.dw.departmentdictionary.api.feign.DepartmentClient;
import com.dw.departmentdictionary.dto.DepartmentDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DepartmentFallback implements DepartmentClient {
    @Override
    public List<DepartmentDto> getAll() {
        return Collections.emptyList();
    }

    @Override
    public DepartmentDto getById(Integer id) {
        return new DepartmentDto();
    }
}
