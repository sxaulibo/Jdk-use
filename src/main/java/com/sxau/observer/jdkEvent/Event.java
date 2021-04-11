package com.sxau.observer.jdkEvent;

import java.lang.reflect.Method;

/**
 * 创建Event类
 * 标准事件源格式定义
 */
public class Event {
    //事件源，动作是由谁发出的
    private Object source;
    //事件触发，要通知谁（观察者）
    private EventListener target;
    //观察者的回应
    private Method callback;
    //事件的名称
    private String trigger;
    //事件的触发事件
    private long time;

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target = " + target +
                ", callback = " + callback +
                ", trigger = '" + trigger +
                '\'' + ", time = " + time +
                '}';
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public EventListener getTarget() {
        return target;
    }

    public void setTarget(EventListener target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }
}
