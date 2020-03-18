package com.lwb.service.impl;

import com.lwb.dao.AccountDao;
import com.lwb.domain.Account;
import com.lwb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("服务层 - 查询所有账户信息");
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    @Override
    public int saveAccount(Account account) {
        System.out.println("服务层 - 保存账户");
        return accountDao.saveAccount(account);

    }
}
