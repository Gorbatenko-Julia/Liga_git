package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Second commit");

        Cat firstCat = new Cat("Барсик", "Чёрный", 2);
        Cat SecondCat = new Cat("Мурзик", "Белый", 1);

        System.out.println( "Данные первого кота: " +  firstCat.getName() + " ," + firstCat.getAge()
        + " ," + firstCat.getColor());
        System.out.println( "Данные второго кота: " +  SecondCat.getName()+ " ," + SecondCat.getAge()
                + " ," + SecondCat.getColor());
    }
}