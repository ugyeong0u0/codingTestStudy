
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
/*
 *
 *
 * */

public class Main {

    static int t, sX, sY, convi, fX, fY;
    static int[][] conArr, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine()); // case 수

        for (int i = 0; i < t; i++) { // 테케

            convi = Integer.parseInt(br.readLine()); // 편의점 수
            conArr = new int[convi][2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            sX = Integer.parseInt(st.nextToken()); // 출발 좌표
            sY = Integer.parseInt(st.nextToken());

            for (int j = 0; j < convi; j++) { // 편의점 좌표
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 2; k++) {
                    conArr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            fX = Integer.parseInt(st.nextToken()); // 패스티벌 좌표
            fY = Integer.parseInt(st.nextToken());

            // 패스티벌과 시작좌표 사이 거리
            int interX = Math.abs(fX - sX);
            int interY = Math.abs(fY - sY);

            if (interX + interY <= 1000) {
                System.out.println("happy");
                continue;
            }


            bfs();


        }


    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sX, sY});
        visited = new int[convi][convi]; // 편의점 방문 처리

        while (!q.isEmpty()) {

            int tmp[] = q.poll();
            int dx = tmp[0];
            int dy = tmp[1];

            int fiX = Math.abs(dx - fX);
            int fiY = Math.abs(dy - fY);
            if (fiX + fiY <= 1000) {
                System.out.println("happy");
                return;
            }


            for (int i = 0; i < convi; i++) {
                for (int j = 0; j < convi; j++) {
                    int cX = conArr[i][0];
                    int cY = conArr[i][1];

                    int interX = Math.abs(dx - cX);
                    int interY = Math.abs(dy - cY);

                    if (interX + interY <= 1000 && visited[i][j] == 0) {
                        q.offer(new int[]{cX, cY});
                        visited[i][j] = 1;
                    }
                }
            }


        }
        System.out.println("sad");
    }


}
