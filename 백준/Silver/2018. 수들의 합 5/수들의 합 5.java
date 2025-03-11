import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n; // 용액 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(br.readLine());

        int starter =1;
        int end = 2;

        int answer= 0;

        while(starter < end){

            int sum = 0;
            for(int i = starter; i<=end; i++){
                sum+=i;
            }

            if(sum>=n){
                if(sum==n){
                    answer++;
                }
                starter++;
            }else {
                end++;
            }
        }


        System.out.println(answer +1);
    }
}

