import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static long[] map;

    static int n, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 조카 수
        m = Integer.parseInt(st.nextToken()); // 사탕 수

        map = new long[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            map [i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(map);



        long min = 1;
        long max = map[m-1]+1; // 11

        while(min < max){
            long mid = (min+max)/2; // cm
            long count = 0;
            for(int i = 0 ; i<map.length; i++){
                count += map[i]/mid;
            }

            if(count < n){
                max= mid;
            }else if(count >= n){
                min = mid +1 ;
            }

//            System.out.println(min +"  "+max + "  "+ mid + "  "+ count);
        }

        System.out.println(min-1);


    }


}

