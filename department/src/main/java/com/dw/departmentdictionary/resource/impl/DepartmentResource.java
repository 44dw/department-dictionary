package com.dw.departmentdictionary.resource.impl;

import com.dw.departmentdictionary.dto.DepartmentDto;
import com.dw.departmentdictionary.resource.AbstractCommonResource;
import com.dw.departmentdictionary.service.impl.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentResource extends AbstractCommonResource<DepartmentDto> {
    public DepartmentResource(DepartmentService service) {
        super(service);
    }
}
