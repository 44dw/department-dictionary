package com.dw.departmentdictionary.service.impl;

import com.dw.departmentdictionary.domain.Department;
import com.dw.departmentdictionary.repository.DepartmentRepository;
import com.dw.departmentdictionary.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements CommonService<Department> {
    private DepartmentRepository repository;

    @Autowired
    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Department> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Department getOneById(Integer id) {
        return this.repository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Could not find department with id " + id));
    }

    @Override
    public Department save(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Department update(Integer id, Department department) {
        this.getOneById(id);
        department.setId(id);
        return this.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }
}
