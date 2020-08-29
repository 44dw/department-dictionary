package com.dw.departmentdictionary.api.feign;

import com.dw.departmentdictionary.api.feign.fallback.DepartmentFallback;
import com.dw.departmentdictionary.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8081/department", name = "department", fallback = DepartmentFallback.class)
public interface DepartmentClient {
    @GetMapping
    List<DepartmentDto> getAll();

    @GetMapping("/{id}")
    DepartmentDto getById(@PathVariable("id") Integer id);
}
