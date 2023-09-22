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

class HackerrankInAStringResult {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
        if (subsequenceHasHackerrankRec(s)) {
            return "YES";
        } else {
            return "NO";
        }
    }
    
    private static final char[] HACKERRANK_CHARS = ("hackerrank").toCharArray();
    
    public static boolean subsequenceHasHackerrankRec(String s) {
        return subsequenceHasHackerrankRec(s, 0, -1);
    }
    
    public static boolean subsequenceHasHackerrankRec(String s, int i, int previousIndexChecked) {
        if (i >= HACKERRANK_CHARS.length) return true;
        
        char c = HACKERRANK_CHARS[i];
        int nextCharacterIndex = s.indexOf(c, previousIndexChecked + 1);
        if (nextCharacterIndex == -1) return false;
        
        return subsequenceHasHackerrankRec(s, i + 1, nextCharacterIndex);
    }

}

public class HackerrankInAStringSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = HackerrankInAStringResult.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
