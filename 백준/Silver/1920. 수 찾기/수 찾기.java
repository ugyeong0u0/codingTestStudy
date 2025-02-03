import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
/*
 *
 *
 * */

class Loc {
    int x;
    int y, answer;


    public Loc(int x, int y) {
        this.x = x;
        this.y = y;

    }


}

public class Main {

    static int n, m;

//    static int[][] convi, san, goa;
//    static int[] visited;

    static int[] arr1, arr2;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 테케 수

        arr1 = new int[n];
      
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine()); // 테케 수
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }



        Arrays.sort(arr1);

        for (int i = 0; i < arr2.length; i++) {
            int le = 0; // 왼쪽 인덱스
            int right = arr1.length - 1; // 오른쪽 인덱스
            int mid = (le + right) / 2;
            int flag = 0;

            while (le <= right) {
                mid = (le + right) / 2;

                if (arr1[mid] == arr2[i]) {
                    flag = 1;
                    break;
                }else if (arr1[mid] < arr2[i]) {
                    le = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
            if (flag == 1) {
                arr.add(1);
            } else {
                arr.add(0);
            }


        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }


    }


}
