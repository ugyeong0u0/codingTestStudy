import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m; // 용액 개수
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int starter =0;
        int end = n-1;

        int answer= 0;

        while(starter < end){
            int sum = 0;
            sum = arr[starter] + arr[end];

            if(sum <= m){
                if(sum==m)
                    answer++;
                starter++;
            }else{
                end--;
            }

        }


        System.out.println(answer);
    }
}

