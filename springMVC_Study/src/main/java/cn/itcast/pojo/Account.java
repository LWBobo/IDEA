package cn.itcast.pojo;

public class Account {
    int account;
    int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "Account{" +
                "account=" + account +
                ", money=" + money +
                '}';
    }
}
