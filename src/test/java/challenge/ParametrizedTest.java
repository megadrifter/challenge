package challenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedTest {

    // Все комментарии приведены для себя
    // сначала параметры и заголовок
    @Parameterized.Parameters(name = "{index}:Operand1={0}, operand2={1}, " +
                                     "operation={2}, expectedresult={3}")
    public static Iterable<Object[]> dataForTest() {

        // файл подготовлен заранее
        String myFile = "C:\\Temp\\file.csv";

        // Приготовить список
        List<Object[]> dataList = new ArrayList<>();
        /**/
        System.out.println("Test data:");

        // открыть и считать строки
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(myFile), StandardCharsets.UTF_8))) {
            String line;
            // читаю строку
            while ((line = reader.readLine()) != null) {
                // разбиваю на элементы
                Object[] myVarsArray = line.split(";");
                for (Object x : myVarsArray) {
                    System.out.print(x.toString() + "; ");
                } // вывод на экран
                System.out.println();
                // добавляю массив в список
                dataList.add(myVarsArray);

            }
            //       // проверка содержимого
            //        for (Object x: dataList)
            //        {
            //            System.out.println(x.toString());
            //        }

            // так было в примере чтения
        } catch (IOException e) {
            // log error
        }
        /**/
/*
        // остатки от ручной подстановки
        dataList.add(new Object[] {1,2,'*',3});
        dataList.add(new Object[] {4,5,'/',6});
        dataList.add(new Object[] {7,8,'+',9});
*/
        return dataList;
    }

    // затем переменные
    private String operand1;
    private String operand2;
    private String operation;
    private String expected;

    // затем конструктор
    public ParametrizedTest(String operand1, String operand2,
                             String operation, String expected) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.expected = expected;
        System.out.println(operand1);
        System.out.println(operand2);
        System.out.println(operation);
        System.out.println(expected);
    }

    // потом сам тест
    @Test
    public void firstTest() {
        // пробую вывести на экран
        // принял тип String
        System.out.println(operand1);
        System.out.println(operand2);
        System.out.println(operation);
        System.out.println(expected);

    }

}
