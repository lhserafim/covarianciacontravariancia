package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

        /* covariância
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);
        List<? extends Number> list = intList;
        Number x = list.get(0);
        list.add(20); // erro de compilacao
        get - OK
        put - ERROR
         */

        /* contravariância
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        List<? super Number> myNums = myObjs;
        myNums.add(10);
        myNums.add(3.14);
        Number x = myNums.get(0); // erro de compilacao
        get - ERROR
        put - OK
         */

public class Program {
    public static void main(String[] args) {
        // Criei variás listas de diferentes tipos
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        // Chamada do método copy (que usa curinga e faz a covariancia e contravariancia
        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);
    }

    // Lista de ORIGEM qualquer tipo numérico (extends Number) (Java Wrapper) covariância posso ler
    // Lista de DESTINO contravariancia posso adicionar (super de number = objeto)
    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {
            destiny.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}