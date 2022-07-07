package com.shashimallah.java8;

import java.util.*;
import java.util.stream.Collectors;

public class SortIntegerArrayByOccurance {

    //    input = 1 2 3 4 2 3 2 3 4
    //    output = 3 2 4 1 / 2 3 4 1
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 3, 2, 3, 4);
        //        one way
        Set<Integer> result = list.stream()
                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)).keySet();
        System.out.println(result);
    }

}
