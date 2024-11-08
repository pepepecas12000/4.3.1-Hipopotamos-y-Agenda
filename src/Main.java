import exceptions.EmptyException;
import exceptions.FullException;
import listas.DLnkedList;
import stack_DL.Stack_DL;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws FullException, EmptyException {
        Stack_DL<Double> stack_hipopotamos = new Stack_DL<>(10);

        stack_hipopotamos.push(2027.89);
        stack_hipopotamos.push(1689.45);
        stack_hipopotamos.push(2478.22);
        stack_hipopotamos.push(1573.24);
        stack_hipopotamos.push(2256.78);
        stack_hipopotamos.push(2134.34);
        stack_hipopotamos.push(2642.88);
        stack_hipopotamos.push(1955.12);
        stack_hipopotamos.push(2389.56);
        stack_hipopotamos.push(1812.67);

        System.out.println("Pesos de los hipopotamos:");
        Iterator<Double> iterator = stack_hipopotamos.get_stack().left();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Stack_DL<Double> tmp1= new Stack_DL<>(10);
        Stack_DL<Double> ordenados= new Stack_DL<>(10);

        while (!stack_hipopotamos.isEmpty()) {
            double valor= stack_hipopotamos.pop();

            while(!ordenados.isEmpty()&&valor< ordenados.peek()){
                tmp1.push(ordenados.pop());
            }
            ordenados.push(valor);
            while(!tmp1.isEmpty()){
                ordenados.push(tmp1.pop());
            }

        }
        System.out.println("\nPesos hipopotamos Ordenados:");
        Iterator<Double> iterator1 = ordenados.get_stack().left();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }



    }
}