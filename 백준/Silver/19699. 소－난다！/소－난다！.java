import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] visited, arr, sum; // 주어진

    static int n, m;
    static LinkedHashSet<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 부등호 개수
        m = Integer.parseInt(st.nextToken()); // 부등호 개수


        // 배열 초기화
        arr = new int[n]; // 숫자 0- 9까지 만든것
        visited = new int[n]; // 숫자 방문
        sum = new int[m];


        // 배열 입력값 넣기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

//        for(int i : arr){
//            System.out.println(i);
//        }

        
        
        dfs(0, 0);


        ArrayList <Integer> list = new ArrayList<>(set);

        Collections.sort(list);
        
        if (list.size() == 0) {
            sb.append(-1);
        } else {
            for (int i : list) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);


    }

    static void dfs(int dept, int next) {

        if (dept == m) {
            int sum2 = 0;
            for (int i : sum) {
                sum2 += i;
            }

            boolean result = isOdd(sum2);

            if (result) {
                set.add(sum2);
            }
            return;
        }

        for (int i = next; i < n; i++) {
            sum[dept] = arr[i];
            dfs(dept + 1, i + 1);
        }

    }

    static boolean isOdd(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) { // ** math. aqrt!!!
            if (num % i == 0) {
                return false;
            }

        }
        return true;

    }

}
