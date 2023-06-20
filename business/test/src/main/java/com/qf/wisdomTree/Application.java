package com.qf.wisdomTree;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Iterator;
import java.util.Stack;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {


        MyQueue<String> myQueue=new MyQueue<String>();

        myQueue.add("1","2","3");


        myQueue.pop();
    }

    static class MyQueue<T>{
        private Stack pullStack=new Stack();
        private Stack upStack=new Stack();
        
        public void add(T... t){
            for (T t1 : t) {
                pullStack.push(t1);
            }
            while (!pullStack.empty()){
                upStack.push(pullStack.pop());
            }
        }

        public void add(T t){
            pullStack.push(t);

            upStack.push(pullStack.pop());
        }

        public void pop(){
            while (!upStack.empty()){
                System.out.println(upStack.pop());
            }
        }

        /**
         * admin用户在某个时间点什么操作了某个库表
         */


    }
}
