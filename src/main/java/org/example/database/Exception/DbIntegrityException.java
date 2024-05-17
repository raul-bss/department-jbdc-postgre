package org.example.database.Exception;

public class DbIntegrityException extends RuntimeException{

    public DbIntegrityException(String msg){
        super(msg);
    }
}
