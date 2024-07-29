import javax.sound.midi.Soundbank;
import java.util.*;
import java.io.*;


public class Main {

    static int n, min, start, link;
    static int[][] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;


        arr = new int[n + 1][n + 1];
        visited = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0); // 최기화 오류
        System.out.println(min);
    }

    static void dfs(int fir, int person) {

        if (person == n / 2) {
            int tmp;
            start = 0;
            link = 0;
            for (int i = 1; i < n; i++) { // **
                for(int j = i+1; j<= n ; j++){

                    if (visited[i] == 1 && visited[j]==1 ) { // **
//                        System.out.print(i + "-" + j);
                        start += arr[i][j];
                        start += arr[j][i];
//                        System.out.println("start=>"+start);
                    } else if(visited[i]==0 && visited[j]==0) {
//                        System.out.print("link=>"+i+ " + "+j);
                        link += arr[i][j];
                        link += arr[j][i];
//
                    }
                }
            }
//            System.out.println();
//            System.out.println(start + "-" + link);
            tmp = Math.abs(start - link);
            min = Math.min(tmp, min);
            if(min ==0){
                System.out.println(0);
                System.exit(0);
            }

            return;
        }

        for (int i = fir; i <= n; i++) {
            if (visited[i]==0) {
                visited[i] = 1;
                dfs(i+1, person + 1);
                visited[i] = 0;

            }
        }


    }
}


