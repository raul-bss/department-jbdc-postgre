package org.example.database;

import org.example.database.Exception.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;



public class DataBaseCONN {

    private static Connection connection = null;

    //Metodo para conectar com o Banco de Dados
    public static Connection getConnection(){
        if (connection == null){

            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                String user = props.getProperty("user");
                String password = props.getProperty("password");

                connection = DriverManager.getConnection(url,user,password);

            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }


    //Metodo para encerrar a conexão
    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    //Metodo para carregar os properties
    public static Properties loadProperties(){
        String path = "C:/Users/raul_/OneDrive/Documentos/estudos/Dao.JBDC/db.properties";

        try{
            FileInputStream fileStream = new FileInputStream(path);
            Properties props = new Properties();
            props.load(fileStream);
            return props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement statement){
        if (statement != null){
            try {
                statement.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

}
