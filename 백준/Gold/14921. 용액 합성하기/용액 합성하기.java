import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{

    static long[] map;

    static int n; // 용액 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 나라들
        map = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            map[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(map);


        int left = 0;
        int right =  map.length-1; // 인덱스
        long answer = Long.MAX_VALUE;
        while(left < right){

            long sum = (long)map[left] + (long)map[right];


            if(sum ==0){
                System.out.println(0);
                return;
            }

            if(sum > 0){
                right-=1;
            }else if(sum <0 ){
                left+=1;
            }
            if(Math.abs(answer)>Math.abs(sum)) {
                answer = sum;

            }

        }
        System.out.println(answer);

    }
}

