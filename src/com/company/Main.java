// authors
// Vasu Agarwal 2015113
// Varnit Jain 2015112


package com.company;

import jdk.nashorn.internal.ir.Block;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Temperature implements Runnable{

    public BlockingQueue<Float> a = new ArrayBlockingQueue<Float>(1000);
//    public ArrayList<Float> a = new ArrayList();

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

class Query_one implements Runnable{

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