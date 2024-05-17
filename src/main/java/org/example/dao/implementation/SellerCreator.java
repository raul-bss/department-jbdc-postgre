package org.example.dao.implementation;

import org.example.dao.SellerDao;
import org.example.database.DataBaseCONN;
import org.example.database.Exception.DbException;
import org.example.entities.Department;
import org.example.entities.Seller;

import java.sql.*;
import java.util.List;

public class SellerCreator implements SellerDao {

    //Implementa todos os metodos do Vendedor

    private Connection connection;
    public SellerCreator(Connection connection){
        this.connection = connection;
    }


    @Override
    public void create(Seller obj) {

        PreparedStatement declaration = null;
        ResultSet result = null;

        try {

            declaration = connection.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name,Email,BirthDate,BaseSalary,DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ? ,? ,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            declaration.setString(1,obj.getName());
            declaration.setString(2, obj.getEmail());
            declaration.setDate(3,obj.getBirthDate());
            declaration.setDouble(4, obj.getSalary());
            declaration.setInt(5,obj.getDepartament().getId());

            int affectedLines = declaration.executeUpdate();

            if (affectedLines > 0) {

                //Armazena a Id gerada pelo Statement.RETURN_GENERATED_KEYS
                ResultSet rs = declaration.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DataBaseCONN.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
            }catch(SQLException e) {
                throw new DbException(e.getMessage());
            }finally {
                DataBaseCONN.closeStatement(declaration);

            }
    }

    @Override
    public void update(Seller obj) {

            PreparedStatement declaration = null;
            ResultSet result = null;

            try {
                declaration = connection.prepareStatement(
                        "UPDATE seller"
                        + "SET Name= ?,Email = ?,BirthDate = ?,BaseSalary = ?,DepartmentId = ? "
                        + "WHERE Id =? "
                );
                declaration.setString(1,obj.getName());
                declaration.setString(2,obj.getEmail());
                declaration.setDate(3,obj.getBirthDate());
                declaration.setDouble(4,obj.getSalary());
                declaration.setInt(5,obj.getDepartament().getId());
                declaration.setInt(6,obj.getId());

                declaration.executeUpdate();

            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }finally{
                DataBaseCONN.closeStatement(declaration);
                DataBaseCONN.closeConnection();
            }

    }

    @Override
    public void deleteById(Seller obj) {

    }

    @Override
    public Seller findById(Integer id) {
        return null;
    }

    @Override
    public List<Seller> findByDepart(Department dep) {
        return List.of();
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
