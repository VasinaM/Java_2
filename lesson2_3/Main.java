package lesson2_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList <String> list = new ArrayList <> ();
        list.add("J");
        list.add("H");
        list.add("D");
        list.add("I");
        list.add("J");
        list.add("E");
        list.add("F");
        list.add("D");
        list.add("G");
        list.add("H");
        list.add("C");
        list.add("B");
        list.add("A");
        list.add("E");
        list.add("G");
        list.add("F");
        System.out.println(list);
        Set<String> set = new TreeSet<>(list);
        System.out.println(set);
    }

    public static void countWords (){

    }
}
