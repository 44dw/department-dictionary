package com.dw.departmentdictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Integer id;
    private String name;
    private DepartmentDto rootDepartment;
}
