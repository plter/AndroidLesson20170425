package com.plter.la;

/**
 * Created by plter on 5/16/17.
 */
public class Human implements IHuman {

    private String name;
    private int age;
    private int money;

    public Human(String name, int age, int initMoney) {
        this.age = age;
        this.name = name;
        this.money = initMoney;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    @RequireMoney
    public void eat() {
        System.out.println("吃饭");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
