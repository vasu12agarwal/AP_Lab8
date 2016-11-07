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

    public Qone(){
        this.a = null;
    }

    public void setQ(ArrayList<Float> b) {
        this.a = b;
    }

    public void reset(){
        this.a = null;
    }

    int x=1;

    public void run(){
        while(x<5) {
            x++;
            synchronized (a) {
                while(a!=null)
                {
                    try {
                        int i;
                        min = a.get(0);
                        int sum=0;
                        for(i=0;i<a.size();i++){
                            if(a.get(i)<min) {
                                min = a.get(i);
                            }
                        }
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            a.notifyAll();
            reset();
            System.out.println(min);
        }
    }

    public String toString(){
        System.out.println(String.valueOf(min));
        return null;
    }

}


class Qtwo implements Runnable{

    ArrayList<Float> a;
    Float max;

    public Qtwo(){
        this.a = null;
    }

    public void setQ(ArrayList<Float> b) {
        this.a = b;
    }

    public void reset(){
        this.a = null;
    }

    public void run(){
        int i;
        max = a.get(0);
        int sum=0;
        for(i=0;i<a.size();i++){
            if(a.get(i)>max)
                max = a.get(i);
        }
    }

    public float getanswer(){
        return max;
    }

}



class Qthree implements Runnable{

    ArrayList<Float> a;
    Float avg;

    public Qthree(){
        this.a = null;
    }

    public void setQ(ArrayList<Float> b) {
        this.a = b;
    }

    public void reset(){
        this.a = null;
    }

    public void run(){
        int i;
        int sum=0;
        for(i=0;i<a.size();i++){
            sum+=a.get(i);
        }
        avg = Float.valueOf(sum/100);
    }

    public float getanswer(){
        return avg;
    }

}



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Temperature temp = new Temperature();
        Qone q11 = new Qone();
        Rainfall rain = new Rainfall();
        Qtwo q12 = new Qtwo();
        Qthree q13 = new Qthree();
        Humidity humi = new Humidity();




        Thread th_temp = new Thread(temp);
        Thread th_rain = new Thread(rain);
        Thread th_humi = new Thread(humi);
        Thread q1 = new Thread(q11);
        Thread q2 = new Thread(q12);
        Thread q3 = new Thread(q13);


        th_temp.start();
        q11.setQ(temp.getfa(1));
        q1.start();




        }
}