package com.example.java.decorator;

/**
 * decorator pattern 装饰者模式 也称 wrapper pattern 包装器模式
 *
 * (1)抽象组件(Component):可以是一个抽象类或者接口，充当被修饰类的原始对象，规定被修饰对象的行为
 * (2)具体组件(ConcreteComponent):实现或者继承Component的一个具体对象，即被装饰对象。
 * (3)抽象装饰器(Decorator):通用的装饰ConcreteComponent的装饰器，内部必然有一个属性指向Component。
 *  其实现一般是一个抽象类，主要是为了让其子类按照其构造形式传入一个Component,这是强制的通用行为。
 *  如果系统中的装饰逻辑单一，则并不需要实现许多装饰器，可以直接省略该类，而直接显示一个具体装饰器即可。
 * (4)具体装饰器(ConcreteDecorator):Decorator的具体实现类，理论上每个ConcreteDecorator都扩展了Component对象的一种功能。
 */
public class Client {
    public static void main(String[] args) {
        //concrete 具体的、实际的  Decorator 装潢师 operation 行为行动
        ConcreteComponent c1 = new ConcreteComponent();
        Decorator decoratorA = new ConcreteDecoratorA(c1);
        decoratorA.operation();
        Decorator decoratorB = new ConcreteDecoratorB(c1);
        decoratorB.operation();

        Decorator decoratorBandA = new ConcreteDecoratorB(decoratorA);
        decoratorBandA.operation();
    }

    static abstract class Component {
        /**
         * 示例方法
         */
        public abstract void operation();
    }

    static class ConcreteComponent extends Component {

        @Override
        public void operation() {
            //相应的功能处理
            System.out.println("处理业务逻辑");
        }
    }

    static abstract class Decorator extends Component {
        /**
         * 持有组件对象
         */
        protected Component component;

        /**
         * 构造方法，传入组件对象
         *
         * @param component 组件对象
         */
        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            //转发请求给组件对象，可以在转发前后执行一些附加动作
            component.operation();
        }
    }

    static class ConcreteDecoratorA extends Decorator {
        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        private void operationFirst() {
        }//在调父类的operation方法之前需要执行的操作

        private void operationLast() {
        }//在调父类的operation方法之后需要执行的操作

        @Override
        public void operation() {
            //调用父类的方法，可以在调用前后执行一些附加动作
            operationFirst();//添加的功能
            //这里可以选择性地调用父类的方法，
            //如果不调用，则相当于完全改写了方法，实现了新的功能
            super.operation();
            operationLast();//添加的功能
        }


    }

    static class ConcreteDecoratorB extends Decorator {
        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        private void operationFirst() {
        }//在调父类的operation方法之前需要执行的操作

        private void operationLast() {
        }//在调父类的operation方法之后需要执行的操作

        @Override
        public void operation() {
            //调用父类的方法，可以在调用前后执行一些附加动作
            operationFirst();//添加的功能
            super.operation();
            operationLast();//添加的功能
        }

    }
}
