package com.dw.departmentdictionary.resource;

import com.dw.departmentdictionary.service.AbstractCommonService;
import com.dw.departmentdictionary.service.CommonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractCommonResource<Domain, Dto> implements CommonResource<Dto> {
    protected AbstractCommonService<Domain, Dto> service;

    public AbstractCommonResource(AbstractCommonService<Domain, Dto> service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<Dto> getAll() {
        return this.service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Dto getOneById(@PathVariable Integer id) {
        return this.service.getOneById(id);
    }

    @Override
    @PostMapping
    public Dto save(@RequestBody Dto entity) {
        return this.service.save(entity);
    }

    @Override
    @PutMapping("/{id}")
    public Dto update(@PathVariable Integer id, @RequestBody Dto entity) {
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
