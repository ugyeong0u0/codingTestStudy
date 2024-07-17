import java.util.*;
import java.io.*;


public class Main {


    static int n, sum = 0;

    static int[] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            int a = Integer.parseInt(st.nextToken());

            arr[i] = a;


        }

        Arrays.sort(arr);


        int sum[] = new int[n];


        sum[0] = arr[0];

        for (int i = 1; i < n; i++) {

            int a = arr[i];

            sum[i] = sum[i - 1] + a;

        }

        int result = 0;
        for (int i = 0; i < n; i++)
            result += sum[i];

        System.out.println(result);

    }


}