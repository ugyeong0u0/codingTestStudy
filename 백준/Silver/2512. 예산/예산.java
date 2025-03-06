import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{

    static int[] map;

    static int n; // 나라들
    static long m; // 예산


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 나라들
        map = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        m = Long.parseLong(br.readLine()); // 예산

        Arrays.sort(map);


        long left = 1;
        long right = map[n - 1] + 1;
        long answer = 0;

        while (left < right) {

            long mid = (left + right) / 2; // 130
            long count = 0;
            int flag = 0;
            for (int i = 0; i < map.length; i++) {
                if (mid < map[i]) {
                    flag = 1; // 모든 요청이 배정 x
                }
            }

            if (flag == 1) { // 모든 요청이 배정 x
                for (int i = 0; i < map.length; i++) {
                    if (mid >= map[i]) {
                        count += map[i];
                    } else {
                        count += mid;
                    }
                }

            } else { // 모든 요청이 배정 o
                for (int i = 0; i < map.length; i++) {
                    count += map[i];
                }
            }

            if(count> m ){ // 총 count 가 예산을 넘어버리면
                right = mid;
            }else if( count <= m ){
                left = mid+1;
            }

//            answer= Math.max(left-1, answer); // 이거 안되는 이유는?
        }

        System.out.println(left-1);

    }
}

