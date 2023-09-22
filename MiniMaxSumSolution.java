import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MiniMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long sumAll = 0,
            max = Integer.MIN_VALUE,
            min = Integer.MAX_VALUE;
        
        for(int n : arr) {
            sumAll += n;
            
            if(n > max) max = n;
            if(n < min) min = n;
        }
        
        long sumMax = sumAll - min,
            sumMin = sumAll - max;
        
        System.out.println(sumMin + " " + sumMax);
    }

}

public class MiniMaxSumSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        MiniMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}
