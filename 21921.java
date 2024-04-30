import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static int[] countVisitors( int[] visitors, int days ) {
        int sum = 0;
        int countMax = 1;

        for (int i = 0; i < days; i++) {
            sum += visitors[i];
        }
        int max = sum;
        System.out.println("first sum="+sum);

        for (int i = 1; i <= visitors.length-days; i++) {
            sum = sum - visitors[i - 1] + visitors[i+days-1];
            //sum += visitors[i] - visitors[i - days];
            System.out.println(i+"번째 sum="+sum);
            if( sum !=0 && sum==max ){
                countMax++;
            } else if (sum > max){
                max = sum;
            }
        }

        return new int[]{max, countMax};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalDays = sc.nextInt(); // 블로그 시작하고 지난 일수
        int unitDays = sc.nextInt(); // 최대 방문자수를 구할 단위

        int[] visitors = new int[totalDays]; //방문자수를 담은 배열
        for (int i = 0; i < totalDays; i++) {
            visitors[i] = sc.nextInt();
        }

        int[] answer = countVisitors(visitors, unitDays);
        if( answer[0] == 0 ){
            System.out.print("SAD");
        } else {
            System.out.println(answer[0]);
            System.out.println(answer[1]);
        }
    }
}
