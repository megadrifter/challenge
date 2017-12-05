package challenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class parametrizedTest
{
// сначала параметры
    @Parameterized.Parameters(name = "{index}:Operand1={0}, operand2={1}, operation={2}, expectedresult={3}")
    public static Iterable<Object[]> dataForTest()
    {
        List<Object[]> dataList = new ArrayList<>();
        dataList.add(new Object[] {1,2,'*',3});
        dataList.add(new Object[] {4,5,'/',6});
        dataList.add(new Object[] {7,8,'+',9});

        return dataList;
    }
// затем переменные
    private int operand1;
    private int operand2;
    private char operation;
    private int expected;

// затем конструктор
    public void ParameterizeTest(int operand1, int operand2, char operation, int expected)
    {
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
    public void firstTest()
    {
        System.out.println(operand1);
        System.out.println(operand2);
        System.out.println(operation);
        System.out.println(expected);
    }

}
