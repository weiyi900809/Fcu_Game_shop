package fcu.fcu.controller;

import fcu.fcu.model.account;
import fcu.fcu.service.accountLogin;
import fcu.fcu.service.accountRegister;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
public class accountController {
    @Autowired
    private accountRegister accountRegisterManager;
    @Autowired
    private accountLogin accountLoginManager;



    @PostMapping("/register")
    @ResponseBody
    public int register(@RequestParam("username")String username, @RequestParam("password")String password){
        int result = 1;

        if (accountRegisterManager.find_same_username(username)){
                result = 0 ;
        }
        else {
            accountRegisterManager.insertAccount(username,password);
        }
        return result;
    }

    @PostMapping("/login")
    @ResponseBody
    public int login(@RequestParam("username")String username, @RequestParam("password")String password){
        int result = 0;

        if (accountLoginManager.find_account(username,password)){
            result = 1 ;
        }

        return result;
    }




}
