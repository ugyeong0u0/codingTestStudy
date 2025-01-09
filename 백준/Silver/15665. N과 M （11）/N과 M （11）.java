import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

//class Loc {
//    int m; // 보석 무게
//    int v; // 보석 가격
//
//    Loc(int m, int v) {
//
//        this.m = m;
//        this.v = v;
//    }
//}


public class Main {

    static int n, m;
    static StringBuilder answer;
    static int[] arr;
    static String[] nums;
    static int[] numsT;
    static boolean[] visited;
    static LinkedHashSet<String> ht;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 몇번째까지 구할지
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        answer = new StringBuilder();
        arr = new int[m];
        numsT = new int[n];
        nums = br.readLine().split(" ");
        ht = new LinkedHashSet<>();


        for (int i = 0; i < n; i++) {
            numsT[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(numsT);

        dfs(0);

        for(String h : ht)
            System.out.println(h);


    }

    static void dfs(int dept) {

        if (dept == m) {
            for (int i = 0; i < dept; i++) {
                answer.append(arr[i] + " ");
            }
            ht.add(answer.toString());
            answer=  new StringBuilder();
            return;

        }

        for (int i = 0; i < n; i++) {


                arr[dept] = numsT[i];
                dfs(dept + 1);



        }

    }
}



