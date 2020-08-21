package com.dw.departmentdictionary.api.feign;

import com.dw.departmentdictionary.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/department", name = "department")
public interface DepartmentClient {
    @GetMapping
    List<DepartmentDto> getAll();
}
