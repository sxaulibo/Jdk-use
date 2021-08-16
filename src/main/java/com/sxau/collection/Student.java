package com.sxau.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class Student implements Iterable<String>{
    private String[] strings = new String[]{"a", "b"};


    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < strings.length;
            }

            @Override
            public String next() {
                return strings[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }



}
