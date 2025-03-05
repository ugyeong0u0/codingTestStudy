import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{

    static long[] map;

    static int n;
    static long m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 나무 수
        m = Long.parseLong(st.nextToken()); // 원하는 cm

        map = new long[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            map[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(map);

        long left = 0;
        long right = map[n - 1] + 1;

        while (left < right) {

            long mid = (left + right) / 2;

            long count = 0;

            for (int i = 0; i < map.length; i++) {

                if (map[i] - mid > 0) {
                    count += (map[i] - mid);
                }
            }

            if(count < m){
                right=mid;
            }else if(count >= m){
                left = mid +1;
            }


        }


        System.out.println(left-1);


    }


}

