// authors
// Vasu Agarwal 2015113
// Varnit Jain 2015112


package com.company;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Temperature implements Runnable{

    public BlockingQueue<Float> a = new ArrayBlockingQueue<Float>(1000);
//    public ArrayList<Float> a = new ArrayList();
    public Integer minvalue = null;
    public Integer maxvalue = null;
    public Float avgvalue = null;


    public Temperature() {
    }

    @Override
    public void run() {
        File file = new File("temperature");
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextFloat())
            {
                a.add(in.nextFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public BlockingQueue<Float> getfa ()
    {
        return this.a;
    }

    public BlockingQueue<Float> getfirst() throws InterruptedException {
        int i;
        BlockingQueue<Float> b = new ArrayBlockingQueue<Float>(1000);
        for(i=0;i<100;i++){
            b.put(a.element());
        }
        return b;
    }

    public BlockingQueue<Float> getsecond() throws InterruptedException {
        int i;
        BlockingQueue<Float> b = new ArrayBlockingQueue<Float>(1000);
        for(i=100;i<200;i++){
            b.put(a.element());
        }
        return b;
    }
    public BlockingQueue<Float> getthird() throws InterruptedException {
        int i;
        BlockingQueue<Float> b = new ArrayBlockingQueue<Float>(1000);
        for(i=200;i<300;i++){
            b.put(a.element());
        }
        return b;
    }
    public BlockingQueue<Float> getfourth() throws InterruptedException {
        int i;
        BlockingQueue<Float> b = new ArrayBlockingQueue<Float>(1000);
        for(i=300;i<400;i++){
            b.put(a.element());
        }
        return b;
    }
    public BlockingQueue<Float> getfifth() throws InterruptedException {
        int i;
        BlockingQueue<Float> b = new ArrayBlockingQueue<Float>(1000);
        for(i=400;i<500;i++){
            b.put(a.element());
        }
        return b;
    }


    public void setValues(int a, int b, float f)
    {
        this.minvalue = a;
        this.maxvalue = b;
        this.avgvalue = f;
    }

    public String toString() {
        System.out.println("Minimum value: " + this.minvalue);
        System.out.println("Maximum value: " + this.maxvalue);
        System.out.println("Average value: " + this.avgvalue);
        return null;
    }


}

class Rainfall implements Runnable{

    public BlockingQueue<Float> a = new ArrayBlockingQueue<Float>(1000);
//    public ArrayList<Float> a = new ArrayList();

    public Rainfall() {
    }

    @Override
    public void run() {
        File file = new File("rainfall");
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextFloat())
            {
                a.add(in.nextFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public BlockingQueue<Float> getfa ()
    {
        return this.a;
    }
}

class Humidity implements Runnable{

    public BlockingQueue<Float> a = new ArrayBlockingQueue<Float>(1000);
//    public ArrayList<Float> a = new ArrayList();

    public Humidity() {
    }

    @Override
    public void run() {
        File file = new File("rainfall");
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextFloat())
            {
                a.add(in.nextFloat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public BlockingQueue<Float> getfa ()
    {
        return this.a;
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Temperature r = new Temperature();
        Thread t = new Thread(r);
        t.start();
        t.join();
        System.out.println(r.getfa().size());
        System.out.println(r.getfa());
    }

}