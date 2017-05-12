package com.plter.myarraylist;

/**
 * Created by plter on 5/12/17.
 */
public class Main {

    public static void main(String[] args) {

        DynamicArray<String> arr = new DynamicArray<>(2);

        arr.add("Hello");
        arr.add("World");
        arr.add("XiaoHua");
        arr.add("LiGang");
        arr.add("LiSi");

        System.out.println(arr.size());
        System.out.println(String.format("Capacity:%d", arr.getCurrentCapacity()));
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

    }
}
