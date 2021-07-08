package com.meli.desafiospring.utils;

import java.util.Collections;
import java.util.List;

public class SortUtil {
    public static <T extends Comparable<? super T>> void sort(List<T> t) {
        Collections.sort(t);
    }

    public static <T extends Comparable<? super T>> void sortDesc(List<T> t) {
        t.sort(Collections.reverseOrder());
    }
}
