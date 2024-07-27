import java.util.*;
import java.io.*;


public class Main {

    static int [][] visited, maps;
    static int col ,row, answer;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {-1,+1,0,-0};
    static Queue<int []> q= new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col =Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        answer =0;

        visited = new int[row][col];
        maps= new int[row][col];

        for(int i = 0; i< row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< col ; j++){
                int tmp = Integer.parseInt(st.nextToken());
                maps[i][j]=tmp;
                if(tmp == 1 ){
                    q.offer(new int [] {i,j});
                }
            }
        }

        bfs();

        for(int i = 0; i< row; i++){
            for(int j = 0; j< col ; j++){
                if(maps[i][j] == 0 ){
                   System.out.println(-1);
                   return;
                }
                answer = Math.max(answer, visited[i][j]);
            }
        }

        System.out.println(answer);





    }

    static void bfs(){

        while(!q.isEmpty()){
            int [] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            for(int i = 0; i< 4 ; i++){
                int nx=  dx[i] +r;
                int ny = dy[i] +c;
                if(nx>= 0&& ny>= 0&& nx< row&& ny < col && maps[nx][ny]==0 && visited[nx][ny]==0 ){
                    visited[nx][ny] = visited[r][c] +1;
                    maps[nx][ny]=1;
                    q.offer(new int[] {nx,ny});

                }

            }

        }



    }

}


