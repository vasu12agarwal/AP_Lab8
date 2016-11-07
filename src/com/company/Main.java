// authors
// Vasu Agarwal 2015113
// Varnit Jain 2015112


package com.company;

import java.io.*;
import java.util.*;
import java.lang.*;

class Temperature implements Runnable{

    public ArrayList<Float> a = new ArrayList<Float>(1000);
//    public ArrayList<Float> a = new ArrayList();
    public Float minvalue = null;
    public Float maxvalue = null;
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

    public ArrayList<Float> getfa (int k)
    {
        ArrayList<Float> b = new ArrayList<Float>();
        int j = k-1;
        for(int i=j*100;i<k*100;i++)
            b.add(a.get(i));
        return b;
    }


/*
    public ArrayList<Float> getfirst() throws InterruptedException {
        int i;
        ArrayList<Float> b = new ArrayList<Float>(1000);
        for(i=0;i<100;i++){
            b.add(a.get(i));
        }
        return b;
    }

    public ArrayList<Float> getsecond() throws InterruptedException {
        int i;
        ArrayList<Float> b = new ArrayList<Float>(1000);
        for(i=100;i<200;i++){
            b.add(a.get(i));
        }
        return b;
    }
    public ArrayList<Float> getthird() throws InterruptedException {
        int i;
        ArrayList<Float> b = new ArrayList<Float>(1000);
        for(i=200;i<300;i++){
            b.add(a.get(i));
        }
        return b;
    }
    public ArrayList<Float> getfourth() throws InterruptedException {
        int i;
        ArrayList<Float> b = new ArrayList<Float>(1000);
        for(i=300;i<400;i++){
            b.add(a.get(i));
        }
        return b;
    }
    public ArrayList<Float> getfifth() throws InterruptedException {
        int i;
        ArrayList<Float> b = new ArrayList<Float>(1000);
        for(i=400;i<500;i++){
            b.add(a.get(i));
        }
        return b;
    }
*/

    public void setValues(float a, float b, float f)
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

    public ArrayList<Float> a = new ArrayList<Float>(1000);
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

    public ArrayList<Float> getfa ()
    {
        return this.a;
    }
}

class Humidity implements Runnable{

    public ArrayList<Float> a = new ArrayList<Float>(1000);
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

    public ArrayList<Float> getfa ()
    {
        return this.a;
    }
}

class Qone implements Runnable{

    ArrayList<Float> a;
    Float min;
    Float max;
    Float avg;

    public Qone(ArrayList<Float> a){
        this.a = a;
    }

    float[] array = new float[3];

    public void run(){
        int i;
        min = a.get(0);
        max = a.get(0);
        int sum=0;
        for(i=0;i<a.size();i++){
            if(a.get(i)>max)
                max = a.get(i);
            if(a.get(i)<min)
                min = a.get(i);
            sum += a.get(i);
        }
        avg = Float.valueOf(sum/100);
        array[0]=min;
        array[1]=max;
        array[2]=avg;
    }

    public float[] getanswer(){
        return array;
    }

}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Temperature r = new Temperature();
        Thread t = new Thread(r);
        t.start();
        t.join();

        }

}