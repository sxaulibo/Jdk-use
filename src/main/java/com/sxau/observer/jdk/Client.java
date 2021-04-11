package com.sxau.observer.jdk;

public class Client {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("Jerry");

        gPer.addObserver(tom);
        gPer.addObserver(jerry);

        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        gPer.publishQuestion(question);
    }
}
