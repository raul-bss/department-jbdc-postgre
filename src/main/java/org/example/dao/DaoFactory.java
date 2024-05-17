package org.example.dao;

import org.example.dao.implementation.DepartmentCreator;
import org.example.dao.implementation.SellerCreator;
import org.example.database.DataBaseCONN;

public class DaoFactory {
    /*

    A CLASSE EXPÕE UM METODO QUE RETORNA O TIPO DA INTERFACE
    MAS INTERNAMENTE INSTANCIA UMA IMPLEMENTAÇÃO

     NÃO EXPOE A IMPLEMENTAÇÃO, SOMENTE A INTERFACE
     */

    public static SellerDao createSeller(){
        return new SellerCreator(DataBaseCONN.getConnection());
    }
    public static DepartmentDao createDepartment(){
        return new DepartmentCreator(DataBaseCONN.getConnection());
    }
}



