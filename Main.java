import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        // 길이가 같다
        if( first.length() == second.length() ){
            //각 단어가 들어간 dict 객체를 생성
            Map<Character, Integer> dict = new HashMap();
            for( char c : first.toCharArray() ){
                dict.compute(c, (k, v) -> (v == null) ? 1 : v + 1); // 해당 키에 대한 값을 1 증가시킴
            }
            for( char c : second.toCharArray() ){
                dict.compute(c, (k, v) -> (v == null) ? null : v - 1); // 해당 키에 대한 값을 1 감소시킴
            }
            for (Integer value : dict.values()) {
                if (value != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}