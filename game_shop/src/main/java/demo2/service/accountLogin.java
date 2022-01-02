package demo2.service;

import demo2.database.Sql2oDbHandler;
import demo2.model.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;
@Service
public class accountLogin {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public accountLogin() {

    }
    public boolean find_account (String username, String password){
        String query = "SELECT Account_ID , User_name  , User_password"
                + " FROM account WHERE User_name = :username AND User_password = :password ";
        List<account> accounts ;

        try (Connection con = sql2oDbHandler.getConnector().open()) {
            accounts = con.createQuery(query)
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .executeAndFetch(account.class);

            if(accounts!= null & accounts.size()>0 ){
                return true;
            }
            else{
                return false;
            }

        }
    }

}
