import java.util.*;
import java.io.*;


public class Main {

    static int n,m,result;
    static int [][] maps, visited;
    static int [] dx = {0,0,-1,-1,-1, 1, 1, 1};
    static int [] dy = {+1, -1 ,+1,0,-1, +1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        maps = new int[n][m];

        for(int i = 0 ; i<n ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m ;j++)
                maps[i][j]= Integer.parseInt(st.nextToken());
        }
        result =0;

        for(int i = 0 ; i<n ;i++){

            for(int j = 0; j<m ;j++)
                if(maps[i][j]==0){
                    result = Math.max(bfs(i,j,0), result);

                }
        }
        System.out.println(result);

    }

    static int bfs(int st , int end, int answer){
        Queue<int []> q= new LinkedList<>();
        visited = new int[n][m];
        q.add(new int [] {st, end ,answer});
        visited[st][end] =1;

        while(!q.isEmpty()){
            int [] tmp = q.poll();

            for(int i = 0; i< 8 ;i++){

                int nx = dx[i]+tmp[0];
                int ny = dy[i]+tmp[1];
                int nA = tmp[2]+1;



                if(nx >= 0 && ny >=0 && nx<n && ny <m && visited[nx][ny]==0  ){
                    if(maps[nx][ny] == 1){
                        return nA;
                    }
                    q.add(new int [] {nx, ny, nA});
                    visited[nx][ny]=1;
                }

            }
        }

       return -1;
    }

}


