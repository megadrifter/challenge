package challenge;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String myFile = "C:\\Temp\\file.csv";
        readTheFile(myFile);
    }

    private static void readTheFile(String fileFullPath)
    {

        List<Object> dataList = new ArrayList<>();

        // need to check if fileFullPath is not empty
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileFullPath), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null)
            {

                String[] myVarsArray = line.split(";");
                for (String x: myVarsArray) {System.out.println(x);}
                dataList.add(line);

//                System.out.println(line);

            }
            for (Object x: dataList)
            {
                System.out.println(x);
            }


        } catch (IOException e) {
            // log error
        }
    }

    /*
    private void readTheFileLambda(String fileFullPath)
    {
        Files.readAllLines(Paths.get(fileFullPath), StandardCharsets.UTF_8).forEach(System.out::println);
    }
    */
}
