package com.example.Service.Imp;

import com.example.Entity.Account;
import com.example.Repository.LoginRepo;
import com.example.Service.LoginService;

public class ILoginService implements LoginService {
    private LoginRepo loginRepo = new LoginRepo();
    @Override
    public Account loginAccount(String username) {
       return (Account) loginRepo.checkLogin(username);
    }
}
