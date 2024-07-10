import java.util.*;
import java.io.*;
public class Main {
    static int row, col ;

    static int [][] maps, visited ;

    static int [] dx = {+1,0,0,-1};
    static int [] dy = {0,+1, -1, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());


        maps = new int[row][col];
        visited = new int[row][col];

        for(int i = 0 ;i< row ; i++){
            String a= br.readLine();
//            st = new StringTokenizer(a, "");

            for(int j = 0; j< col ; j++){
                maps[i][j] = Integer.parseInt(a.charAt(j)+"");
            }
        }

        bfs(0,0);

        System.out.println(visited[row-1][col-1]);
    }


    public static void bfs(int x , int y ){

        Queue<int []> q= new LinkedList<>();

        visited[x][y] = 1;
        q.offer(new int [] {0,0});

        while(!q.isEmpty()){


           int [] tmp = q.poll();
           int a= tmp[0];
           int b= tmp[1];
           for(int i = 0 ; i< 4 ; i++){

                int nx = dx[i] + tmp[0];
                int ny = dy[i] + tmp[1];

                if(nx>=0 && ny >=0 && nx< row && ny<col && maps[nx][ny] == 1 && visited[nx][ny]==0 ){
                    visited[nx][ny] = visited[a][b] +1;
                    q.offer(new int [] {nx, ny});

                }

           }



        }


    }
}