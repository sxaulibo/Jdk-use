package com.sxau.observer;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //被观察者 subject
        ConcreteSubject<String> observable = new ConcreteSubject<>();
        //观察者
        ConcreteObserve<String> observe = new ConcreteObserve<>();
        //注册
        observable.attach(observe);
        //通知(这里通知可以通知对象，通知的时候对方可以关注自身的变化或者，等等，可以传参数 self,Subject,Object)
        //穿自身的引用、自身的全部数据、要推的部分数据，最后均可以配合拉取使用
        observable.notify("hello");
    }


    //抽象主题者(被观察者)
    public interface ISubject<E> {
        //添加观察者
        boolean attach(IObserver<E> observer);

        //移除观察者
        boolean detach(IObserver<E> observer);

        //通知观察者(推、拉模型。告知本体全部消息/告知少量信息同时让观察者再拉数据)
        void notify(E event);
    }

    //具体主题者(被观察者)
    public static class ConcreteSubject<E> implements ISubject<E> {

        private final List<IObserver<E>> observers = new ArrayList<>();

        @Override
        public boolean attach(IObserver<E> observer) {
            if (this.observers.contains(observer)) return false;
            this.observers.add(observer);
            return true;
        }

        @Override
        public boolean detach(IObserver<E> observer) {
            return this.observers.remove(observer);
        }

        @Override
        public void notify(E event) {
            for (IObserver<E> observer : observers) {
                observer.update(event);
            }
        }


    }


    //抽象观察者(观察者)
    public interface IObserver<E> {
        void update(E event);
    }

    //具体的观察者(可以是一个或者多个观察者)
    public static class ConcreteObserve<E> implements IObserver<E> {

        @Override
        public void update(E event) {
            System.out.println("receive event: " + event);
        }
    }


}
