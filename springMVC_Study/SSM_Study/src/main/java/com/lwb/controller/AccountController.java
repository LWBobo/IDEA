package com.lwb.controller;

import com.lwb.domain.Account;
import com.lwb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/testfindAll")
    public String testfindAll(Model model){
        System.out.println("表现层，查询所有账户...");
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
        model.addAttribute("list",accounts);
        return "list";
    }
    @RequestMapping(value = "/testSave")
    public String testfindAll(Model model,Account account){
        System.out.println("表现层，保存账户...");
        System.out.println(account);
        accountService.saveAccount(account);

        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
        model.addAttribute("list",accounts);

        return "list";
    }
}
