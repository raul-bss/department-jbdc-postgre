package org.example.dao;

import org.example.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void create(Department obj);
    void update(Department obj);
    void deleteById(Integer id);

    List<Department> findAll();
    Department findById();


}
