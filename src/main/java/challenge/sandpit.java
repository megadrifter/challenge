package challenge;      // не соответствует рекомендации (напр., com.github.megadrifter.challenge)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sandpit {
    public static void main(String[] args) {
        List<Object[]> myObjects = new ArrayList<>();
        myObjects.add(new Object[]{"The string", "Another string"});


        for (Object[] L : myObjects) {
            for (Object o : L) {
                System.out.println(o);
            }
        }

        Iterable<Object[]> iter = myObjects;

        int a = doMath(3, 4, '*');
    }

    private static int doMath(int operand1, int operand2, char operation) {
        int r = 0;
        switch (operation) {
            case '+':
                r = operand1 + operand2;
                break;

            case '-':
                r = operand1 - operand2;
                break;

            case '*':
                r = operand1 * operand2;
                break;

            case '/':
                r = operand1 / operand2;
                break;

            default:
                System.out.println("not valid operation");
        }
        System.out.println(r);
        return r;
    }
}