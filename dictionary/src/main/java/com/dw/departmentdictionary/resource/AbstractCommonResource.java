package com.dw.departmentdictionary.resource;

import com.dw.departmentdictionary.service.CommonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractCommonResource<T> implements CommonResource<T> {
    private CommonService<T> service;

    public AbstractCommonResource(CommonService<T> service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<T> getAll() {
        return this.service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public T getOneById(@PathVariable Integer id) {
        return this.service.getOneById(id);
    }

    @Override
    @PostMapping
    public T save(@RequestBody T entity) {
        return this.service.save(entity);
    }

    @Override
    @PutMapping("/{id}")
    public T update(@PathVariable Integer id, @RequestBody T entity) {
        try {
            this.service.getOneById(id);
            return this.service.update(entity);
        } catch (Exception e) {
            System.out.println("Entity not found!");
        }
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.service.deleteById(id);
    }
}
