package org.example;

import org.example.dao.DaoFactory;
import org.example.dao.SellerDao;
import org.example.dao.implementation.SellerCreator;
import org.example.entities.Department;
import org.example.entities.Seller;

import java.sql.Date;
import java.util.Calendar;

public class App {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSeller();

        System.out.println("\n==== TESTE Nº 4: Vendedor inserir====");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.MAY, 15);
        Date birthDate = new java.sql.Date(calendar.getTimeInMillis());

        Seller v1 = new Seller(null, "Je", "je@gmail.com", birthDate, 1200.00, new Department(4, null));
        sellerDao.create(v1);
        System.out.println("VENDEDOR ADCIONADO COM A ID: " + v1.getId());
    }


}