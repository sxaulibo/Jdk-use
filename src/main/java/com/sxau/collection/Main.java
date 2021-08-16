package com.sxau.collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("==Queue接口，通过LinkedList来描述===");
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }

        System.out.println("第一个打印");
        printQ(queue);

        Queue<Character> qc = new LinkedList<>();
        for (Character c : "ccbimlibo".toCharArray()) {
            qc.offer(c);
        }

        System.out.println("第二个打印");
        printQ(qc);


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(47);


        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextInt(i + 10));
        }

        System.out.println("=== 打印priorityQueue");
        printQ(priorityQueue);

        System.out.println("=== 打印priorityQueue 使用arrays初始化");
        List<Integer> ints = Arrays.asList(25, 22, 1, 2, 1, 22);
        priorityQueue = new PriorityQueue<>(ints);
        printQ(priorityQueue);

        System.out.println("=== 打印priorityQueue 使用size,Collections.reverseOrder初始化");
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        printQ(priorityQueue);

        System.out.println("=== 打印priorityQueue 使用String数组初始化");
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(" "));
        PriorityQueue<String> stringsPQ = new PriorityQueue<>(strings);
        printQ(stringsPQ);


        System.out.println("=== 打印priorityQueue 使用size,Collections.reverseOrder()初始化数组");
        stringsPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringsPQ.addAll(strings);
        printQ(stringsPQ);


        HashSet<Character> characterHashSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            characterHashSet.add(c);
        }

//        Queue queue1= new LinkedList<Character>(characterHashSet);
//        printQ(queue1);
        PriorityQueue<Character> characters = new PriorityQueue<>(characterHashSet);
        printQ(characters);


        System.out.println("====实现Iterable接口的自定义对象类配合foreach使用");
        for (String s : new Student()) {
            System.out.println(s);
        }

        String[] strings1 = new String[]{"sss", "eee", "ccc"};
        printIterable(new Student());


        System.out.println("-- Arrays.asList直接生成的List，" +
                "如果被重新洗牌，那么底层的数组 同步变化" +
                "如果被封装到另一个容器，那么另一个容器" +
                "内部的应用会发生变化");
        Random random1 = new Random(47);
        List<String> list = Arrays.asList(strings1);
        Collections.shuffle(list, random1);
        System.out.println("    list" + list);
        System.out.println("    Arrays.toString" + Arrays.toString(strings1));


        String[] strings2 = new String[]{"sss", "eee", "ccc"};
        ArrayList<String> strings3 = new ArrayList<>(Arrays.asList(strings2));
        Collections.shuffle(strings3, random1);
        System.out.println("    list" + strings3);
        System.out.println("    Arrays.toString" + Arrays.toString(strings2));

        Arrays.fill(strings2,null);
        System.out.println("    Arrays.toString" + Arrays.toString(strings2));
        System.out.println("    list" + strings3);



    }


    public static void printQ(@SuppressWarnings("rawtypes") Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    static <T> void printIterable(Iterable<T> ib) {
        for (T t : ib) {
            System.out.println("t = " + t);
        }
    }
}
