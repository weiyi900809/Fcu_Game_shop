package fcu.fcu.service;
import fcu.fcu.database.Sql2oDbHandler;
import fcu.fcu.model.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.*;

import javax.security.auth.login.AccountException;
import java.util.List;
@Service
public class accountRegister {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public accountRegister() {

    }
    public boolean find_same_username (String username){
        String query = "select Account_ID , User_name  , User_password"
                + " from account where User_name = :username";
        List<account> accounts ;

        try (Connection con = sql2oDbHandler.getConnector().open()) {
            accounts = con.createQuery(query)
                    .addParameter("username", username)
                    .executeAndFetch(account.class);

            if(accounts!= null & accounts.size()>0 ){
                 return true;
             }
             else{
                 return false;
             }

        }
    }

    public void insertAccount( String username, String password){
        String insertQuery =
                "INSERT INTO account ( User_name, User_password) "

                + "VALUES (:username, :user_password)";
        try (Connection con = sql2oDbHandler.getConnector().open()) {
            con.createQuery(insertQuery)
                    .addParameter("username",username )//account.getUName()
                    .addParameter("user_password",password) //account.getPassword()
                    .executeUpdate();
        }
    }
}
