import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] a, b;

    static int n, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 주어진 개수
        m = Integer.parseInt(st.nextToken()); // 주어진 개수
        a = new int[n];
        b = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 상한 하한 구해야함
        Arrays.sort(a);
        Arrays.sort(b);

        StringBuilder sb = new StringBuilder();
        int count =0 ;
        for (int i = 0; i < a.length; i++) {
            boolean result = binary(a[i]);
            if (result) {
                count++;
                sb.append(a[i]).append(" ");
            }
        }


          System.out.println(count+"\n" + sb);

//        System.out.println(sb.length() + "\n"+sb);


    }

    static boolean binary(int target) {

        int left = 0;
        int right = m;

        while (left < right) {
            int mid = (left + right) / 2;
            if (b[mid] == target) {
                return false;
            }

            if (b[mid] > target) {
                right = mid;
            } else if (b[mid] < target) {
                left = mid + 1;
            }
        }

        return true;


    }


}

