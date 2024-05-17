package org.example.dao.implementation;

import org.example.dao.DepartmentDao;
import org.example.entities.Department;

import java.sql.Connection;
import java.util.List;

public class DepartmentCreator implements DepartmentDao {

    //Implementa todos os metodos do Departamento

    private Connection connection;
    public DepartmentCreator(Connection connection){
        this.connection = connection;
    }
    @Override
    public void create(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }

    @Override
    public Department findById() {
        return null;
    }
}
