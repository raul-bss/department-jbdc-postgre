package org.example.dao;

import org.example.entities.Department;
import org.example.entities.Seller;

import java.util.List;


public interface SellerDao {
    //Interface com metodos para o vendedor

    void create(Seller obj);
    void update(Seller obj);
    void deleteById(Seller obj);

    Seller findById(Integer id);

    List<Seller> findByDepart(Department dep);

    List<Seller> findAll();
}
