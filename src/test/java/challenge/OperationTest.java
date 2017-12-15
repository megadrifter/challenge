/*
 * OperationTest
 *
 * @version 12/2017
 *
 * @author Andrey Sentsov
 */
package challenge;      // не соответствует рекомендации (напр., com.github.megadrifter.challenge)

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Класс для юнит (JUnit) тестов арифметических действий.
 * По заданию потенциального работодателя.
 * Тип данных принят int, поскольку не указано иное.
 */
@RunWith(Parameterized.class)
public class OperationTest {
    /* Класс проводит юнит тест на основе данных в файле, путь к которому в нём
     жестко прописан. Файл должен лежать в ресурсах теста и называться file.csv */

    // Многие комментарии приведены для себя на время разработки

    // сначала переменные
    private String operand1;
    private String operand2;
    private String operation;
    private String expected;

    // затем конструктор
    public OperationTest(String operand1, String operand2,
                         String operation, String expected) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.expected = expected;
    }

    // потом методы
    // параметры для параметризированного теста и заголовок
    @Parameterized.Parameters(name = "Строка {index}: Проверка операции {0} {2} {1} = {3}")
    public static Iterable<Object[]> dataForTest() {
        String myFile = "src\\test\\resources\\file.csv"; // путь к файлу
        List<Object[]> dataList = new ArrayList<>();      // Список с данными
        Object[] myVarsArray;                             // элемент списка с данными
        String line;                                      // для считывания строки

        System.out.println("Test data:");                 // для меня

        // открыть и считать строки. Основано на примере открытия файла.
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(myFile), StandardCharsets.UTF_8))) {
            /* читаю строку */
            while ((line = reader.readLine()) != null) {
                /* разбиваю на элементы */
                myVarsArray = line.split(";");
                for (Object x : myVarsArray) {            // для меня
                    System.out.print(x.toString() + "; ");
                }
                System.out.println();                     // для меня
                /* добавляю массив в список */
                dataList.add(myVarsArray);
            }
        } catch (IOException e) {   // так было в примере чтения.
            // Прямой задачи обработки исключений не поставлено, пока не делаю.
            // log error
        }
        return dataList;
    }

    // потом сам тест
    @DisplayName("Тест арифметических действий, запротоколированных в файле " +
            "Строка {index}: Проверка операции {0} {2} {1} = {3}")
    @Test
    public void firstTest() {
        /* входные данные сразу преобразовать в int. Нужна ли проверка, что там
        именно числа? */
        int intOperand1 = Integer.parseInt(operand1);
        int intOperand2 = Integer.parseInt(operand2);
        int intExpected = Integer.parseInt(expected);

        assertEquals(intExpected,
                doOperation(intOperand1, intOperand2, operation));
    }

    /**
     * Метод выполняет операцию oper над операндами op1, op2
     * @param op1
     * @param op2
     * @param oper
     * @return
     */
    @Step("Строка {index}: Проверка операции {0} {2} {1} = {3}")
    private static int doOperation(int op1, int op2,String oper) {
        int result = 0;

        switch (oper) {            // лучше бы использовать чар?
            case "+":
                result = op1 + op2;
                break;

            case "-":
                result = op1 - op2;
                break;

            case "*":
                result = op1 * op2;
                break;

            case "/":
                result = op1 / op2;
                break;

            default:
                System.out.println("not valid operation");
        }
        return result;
    }

}
