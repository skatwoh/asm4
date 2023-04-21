package com.example.Repository;

import com.example.Entity.Account;
import com.example.Util.UserUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginRepo {
    public Account checkLogin(String username){
        Account account = new Account();
        try (Session session = UserUtil.getFactory().openSession()) {
            account = session.get(Account.class,username);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
