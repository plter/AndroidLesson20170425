package com.plter.selectname;

import javax.swing.*;
import java.awt.*;
/**
 * Created by plter on 5/16/17.
 */
public class Main extends JFrame {
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    private JButton btn;
    private JLabel label;
    private String[] names = new String[]{"裴纬华", "陈梦轩", "宋宝春", "曹阳", "张泽亚", "任耀文", "张磊", "李涛", "孙鹏", "刘敏文", "左丛林", "宋一平", "韩君帅", "赵强", "刘江", "李亚红", "李晓", "马永淋", "杨建宁", "罗志泽"};

    public Main() throws HeadlessException {
        super("选择一个名字");

        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        buildUI();
        addListeners();
    }

    private void buildUI() {
        btn = new JButton("选择名字");
        btn.setSize(120, 30);
        add(btn);

        label = new JLabel("Label");
        label.setSize(200, 30);
        label.setLocation(0, 35);
        add(label);
    }

    private void addListeners() {
        btn.addActionListener(e -> {
            int index = (int) (Math.random() * names.length);
            label.setText(names[index]);
        });
    }
}
