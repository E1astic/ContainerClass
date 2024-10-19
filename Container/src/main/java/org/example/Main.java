package org.example;

public class Main
{
    public static void main(String[] args)
    {
        Container<Integer> container=new Container<>(1,2);
        System.out.println(container.toString());
        container.insert(1, 55);
        System.out.println(container.toString());

    }
}