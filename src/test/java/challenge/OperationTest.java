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
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OperationTest {

    @Parameterized.Parameters(name = "{index}: {0}{2}{1}={3}")
    public static Iterable<Object[]> data() {
        List<Object[]> dataList = new ArrayList<>();

        /* // присвоение вручную работает верно
        Object[] row1 = {"0", "0", "+", "0"};
        dataList.add(row1);
        Object[] row2 = {"0", "0", "+", "0"};
        dataList.add(row2);
        System.out.println("dataList=" + dataList);
        */

        // Присвоение из файла:
        String myFile = "C:\\Temp\\file.csv";
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


        return dataList;
// return Arrays.asList(new Object[][]{{"0", "0", "+", "0"}, {"1", "1", "+", "2"}, {"1", "2", "+", "2"}});
    }

    private String operand1;
    private String operand2;
    private String operation;
    private String expected;

    public OperationTest(String operand1, String operand2, String operation, String expected) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.expected = expected;
    }

    @Test
    public void test() {
        // convert args here

        // chose operation with swtich-case or if-else

        assertEquals(expected, operand1 + operand2);
    }
}