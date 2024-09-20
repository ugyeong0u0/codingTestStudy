import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
/*
 *
 *
 * */

class Loc{
    int x;
    int y, answer ;
    int z;

    public Loc (int x, int y, int z){
        this.x= x;
        this.y=y;
        this.z=z;
    }


}

public class Main {

    static int row, col, n, h, line, answer, tar1, tar2, k;
    static int[][][] maps;
    static int[][][] visited;
    //    static ArrayList<Integer> list ;
    static int[] dx = {0, 0, 0, 0, +1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {+1, -1, 0, 0, 0, 0};
    static Queue<Loc> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        n = Integer.parseInt(br.readLine()); // 사람
//        list = new ArrayList();
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        answer = 0; // 몇일
        maps = new int[row][col][h];
        visited =new int[row][col][h];
//        visited = new int[n + 1];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    int a = Integer.parseInt(st.nextToken());
                    maps[j][k][i] = a;
                }
            }
        }


        q= new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if(maps[j][k][i] ==1){
                        q.add(new Loc(j, k, i));
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if(maps[j][k][i] ==0){
                        System.out.println(-1);
                        return;
                    }

                }
            }
        }

        System.out.println(answer);

    }

    static void bfs() {

        while(!q.isEmpty()){
            Loc tmp = q.poll();

            for(int i = 0; i< 6 ;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int nz = tmp.z + dz[i];

                if(nx >= 0 &&ny >= 0 &&nz >= 0 && nx<row && ny < col && nz< h && visited[nx][ny][nz] ==0 && maps[nx][ny][nz]==0){

                    visited[nx][ny][nz]  = visited[tmp.x][tmp.y][tmp.z]+1;
                    answer = Math.max(visited[nx][ny][nz], answer);
                    maps[nx][ny][nz]=1;
                    q.offer(new Loc(nx,ny,nz));

                }
            }
        }
    }

}
