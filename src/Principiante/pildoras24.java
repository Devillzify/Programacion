package Principiante;

import javax.swing.*;
public class pildoras24
{
    public static void main(String[] args)
    {
       int [] randoms = new int[10];

       for ( int i = 0; i < randoms.length; i++)
       {
           randoms[i] = (int)Math.round(Math.random()*100);
       }
       for(int j = 0; j < randoms.length; j++)
       {
           System.out.println(randoms[j]);
       }
    }
}
