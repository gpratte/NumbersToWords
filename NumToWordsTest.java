import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumToWordsTest {

    public static void main(String[] args) throws IOException {

        NumToWords numToWords = new NumToWords();

        String actual = numToWords.convert("0");
        String expected = "ZeroDollars";
        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL: expected " + expected + " actual " + actual);
        }

        actual = numToWords.convert("1000");
        expected = "OneThousandDollars";
        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL: expected " + expected + " actual " + actual);
        }

        actual = numToWords.convert("1234560");
        expected = "OneMillionTwoHundredThirtyFourThousandFiveHundredSixtyDollars";
        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL: expected " + expected + " actual " + actual);
        }

    }
}
