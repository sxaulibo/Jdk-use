package com.sxau.observer;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        /*//被观察者 subject
        ConcreteSubject<String> observable = new ConcreteSubject<>();
        //观察者
        ConcreteObserve<String> observe = new ConcreteObserve<>();
        //注册
        observable.attach(observe);
        //通知(这里通知可以通知对象，通知的时候对方可以关注自身的变化或者，等等，可以传参数 self,Subject,Object)
        //穿自身的引用、自身的全部数据、要推的部分数据，最后均可以配合拉取使用
        observable.notify("hello");*/

        BaseSubjectImpl<Integer> subject = new BaseSubjectImpl<>(1);//热水箱
        IObserver<Integer> observer = new ConcreteObserve<>();//水温监控 Siri
        subject.attach(observer);//热水箱添加一个水温监控，一对多的关系
        subject.notify(subject.getData());//热水器推送消息

//        热水器推送当前温度给监控者,(推送的时候，会把自身的引用也推送过去，如果水温不够监控器回调热水器，让热水器继续加热
//        热水器每加热一次重新推送消息给监控者，直到监控者判断当前水温到达27˚C就回调告知热水器说停止加热，步骤停止)

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

        void update(ISubject<E> ref, ISubject<E> subjectData, E event);
    }

    //具体的观察者(可以是一个或者多个观察者)
    public static class ConcreteObserve<E> implements IObserver<E> {

        @Override
        public void update(E event) {
            System.out.println("receive event: " + event);

        }

        @Override
        public void update(ISubject<E> ref, ISubject<E> subjectData, E event) {
            if (ref instanceof BaseSubjectImpl && event instanceof Integer) {
                BaseSubjectImpl<E> subject = (BaseSubjectImpl<E>) ref;
                int temperature = (Integer) event;
                if (temperature < 27) {
                    subject.change(ref, "Siri watch：cold");
                }
                if (temperature >= 27) {
                    System.out.println("Siri监控：当前水温27˚C, 主人洗澡啦🛀");
                    subject.change(ref, null);
                }
            }
        }
    }


    //抽象主题者(被观察者 抽象对象)
    public abstract static class BaseSubject<E> implements ISubject<E> {
        private final List<IObserver<E>> observers = new ArrayList<>();

        //添加观察者
        public boolean attach(IObserver<E> observer) {
            if (this.observers.contains(observer)) return false;
            this.observers.add(observer);
            return true;
        }

        //移除观察者
        public boolean detach(IObserver<E> observer) {
            return this.observers.remove(observer);
        }

        //通知观察者(推、拉模型。告知本体全部消息/告知少量信息同时让观察者再拉数据)
        public void notify(E event) {
            for (IObserver<E> observer : observers) {
                observer.update(this, null, event);
            }
        }

    }

    //具体主题者(被观察者)
    public static class BaseSubjectImpl<E> extends BaseSubject<E> {
        private Integer data;

        public BaseSubjectImpl(Integer data) {
            this.data = data;
            print("高速加热模式");
        }

        @SuppressWarnings({"unchecked"})
        public void change(ISubject<E> self, String pushData) {
            if (self instanceof BaseSubjectImpl) {
                BaseSubjectImpl<E> selfRef = (BaseSubjectImpl<E>) self;
                if (data < 15) {
                    data += 10;
                    System.out.println(pushData);
                    print("高速加热模式");
                } else if (data < 27) {
                    data += 2;
                    System.out.println(pushData);
                    print("缓慢加热模式");
                } else {
                    System.out.println("热水器：bling~ 保温模式");
                    return;
                }

                this.notify((E) this.data);
            }
        }

        private void print(String msg) {
            System.out.println("热水器：水温" + this.data + "˚C , " + msg);
        }

        public Integer getData() {
            return data;
        }
    }

}
