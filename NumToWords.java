import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumToWords {

    static final String[] UNITS = {"", "Thousand", "Million"};

    public String convert(String line) {
        if (line.equals("0")) {
            return "ZeroDollars";
        }

        int unitIndex = 0;

        int endOfInput = line.length() - 1;
        StringBuilder result = new StringBuilder("Dollars");
        while (endOfInput >= 0) {
            StringBuilder tuple = new StringBuilder();
            Character ones = line.charAt(endOfInput--);
            Character tens = null;
            Character hundreds = null;
            if (endOfInput >= 0) {
                tens = line.charAt(endOfInput--);
                tuple.append(getTens(tens, ones));
            } else {
                tuple.append(getOnes(ones));
            }

            if (endOfInput >= 0) {
                hundreds = line.charAt(endOfInput--);
                if (hundreds != '0') {
                    tuple.insert(0, getOnes(hundreds) + "Hundred");
                }
            }
            result.insert(0, UNITS[unitIndex++]);
            result.insert(0, tuple.toString());
        }
        return result.toString();
    }

    public String getOnes(char ones) {
        switch (ones) {
            case '0': return "";
            case '1': return "One";
            case '2': return "Two";
            case '3': return "Three";
            case '4': return "Four";
            case '5': return "Five";
            case '6': return "Six";
            case '7': return "Seven";
            case '8': return "Eight";
            case '9': return "Nine";
            default: return "";
        }
    }

    public String getTens(Character tens, Character ones) {
        switch (tens) {
            case '0': return getOnes(ones);
            case '1': return getTeens(ones);
            case '2': return "Twenty" + getOnes(ones);
            case '3': return "Thirty" + getOnes(ones);
            case '4': return "Forty" + getOnes(ones);
            case '5': return "Fifty" + getOnes(ones);
            case '6': return "Sixty" + getOnes(ones);
            case '7': return "Seventy" + getOnes(ones);
            case '8': return "Eighty" + getOnes(ones);
            case '9': return "Ninety" + getOnes(ones);
            default: return "";
        }
    }

    public String getTeens(Character ones) {
        switch (ones) {
            case '0': return "Ten";
            case '1': return "Eleven";
            case '2': return "Twelve";
            case '3': return "Thirteen";
            case '4': return "Fourteen";
            case '5': return "Fifteen";
            case '6': return "Sixteen";
            case '7': return "Seventeen";
            case '8': return "Eightteen";
            case '9': return "Nineteen";
            default: return "";
        }
    }

    public static void main(String[] args) throws IOException {
        NumToWords numToWords = new NumToWords();

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(numToWords.convert(line));
        }
    }

}
