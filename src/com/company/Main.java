package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //инициализация:
        LinkedList<Integer> infoElements = new LinkedList<>();
        LinkedList<Integer> ignoredElements = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            infoElements.add(i);
            if(i%2==0){
                ignoredElements.add(i); //игнорирование чётных элементов
            }
        }
        IgnoreList<Integer> list = new IgnoreList<Integer>(infoElements, ignoredElements);
        //тесты:
        System.out.println("====Тесты Iterator:");
        //Просто вывод:
        System.out.println("Исходный список:");
        iterOutput(list);
        //Удаление:
        System.out.println("Список с удалёнными через один элементами:");
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            iter.next();
            if(iter.hasNext()) {
                iter.next();
                iter.remove();
            }
        }
        iterOutput(list);
        ////
        System.out.println();
        System.out.println("====Тесты ListIterator:");
        list = new IgnoreList<Integer>(infoElements, ignoredElements);
        //Просто вывод:
        System.out.println("Исходный список:");
        listIterOutput(list);
        //Удаление:
        System.out.println("Список с добавленным через один элементом 1000:");
        ListIterator listIter = list.listIterator();
        while(listIter.hasNext()){
            listIter.next();
            listIter.add(1000);
        }
        listIterOutput(list);
        //Удаление:
        System.out.println("Список с удалёнными элементами \"1000\":");
        listIter = list.listIterator();
        while(listIter.hasNext()){
            int val = (int)listIter.next();
            if(val==1000) listIter.remove();
        }
        listIterOutput(list);
    }

    public static void iterOutput(IgnoreList list){
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+ " ");
        }
        System.out.println();
    }

    public static void listIterOutput(IgnoreList list){
        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}