package com.dw.departmentdictionary.resource;

import com.dw.departmentdictionary.api.feign.DepartmentClient;
import com.dw.departmentdictionary.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestResource {
    @Autowired
    private DepartmentClient departmentClient;

    @GetMapping
    public List<DepartmentDto> getDeps() {
        return this.departmentClient.getAll();
    }
}
