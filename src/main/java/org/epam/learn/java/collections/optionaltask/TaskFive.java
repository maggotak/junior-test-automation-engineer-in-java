package org.epam.learn.java.collections.optionaltask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskFive {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(9);
        list.add(-6);
        list.add(3);
        list.add(-5);
        list.add(4);
        list.add(3);
        list.add(-9);

        list.sort(Comparator.comparing(x -> x < 0));

        System.out.println(list);
    }
}
