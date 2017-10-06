package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        IgnoreList<Integer> list = new IgnoreList<>();
        //Элементы списка (до ста):
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        //Игнорируемые элементы (нечётные до ста) :
        for (int i = 1; i < 100; i+=2) {
            list.addIgnoring(i);
        }
        //тест:
        for(Integer element : list){
            System.out.println(element);
        }
    }

}