package com.dw.departmentdictionary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name = Department.ID_SEQ, sequenceName = Department.ID_SEQ, allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    public static final String ID_SEQ = "department_id_seq";

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "root_department_id")
    private Department rootDepartment;
}
