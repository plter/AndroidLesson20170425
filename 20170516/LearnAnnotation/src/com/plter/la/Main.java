package com.plter.la;

import java.lang.reflect.Method;

/**
 * Created by plter on 5/16/17.
 */
public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Human h = new Human("XiaoHua", 10, 100);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
        humanEat(h);
    }

    void humanEat(Human human) {

        int coast = 10;

        try {
            Method methodEat = Human.class.getMethod("eat");
            RequireMoney annotationRequireMoney = methodEat.getAnnotation(RequireMoney.class);
            if (annotationRequireMoney != null) {
                if (human.getMoney() > coast) {
                    human.setMoney(human.getMoney() - coast);
                    human.eat();
                } else {
                    System.out.println("钱不够");
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
