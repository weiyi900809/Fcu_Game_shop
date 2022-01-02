package demo2.controller;

import demo2.service.accountLogin;
import demo2.service.accountRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
