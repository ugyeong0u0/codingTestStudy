import java.util.*;
import java.io.*;


public class Main {

    static int n, m, picture, width;
    static int[][] maps, visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {+1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[n][m];
        maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        picture =0 ;
        width=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]==0 && maps[i][j]==1){

                    int tmp = dfs(i,j,1); // 가장 큰 그림 크기
                    picture++;
                    width= Math.max(tmp,width);
                }

            }
        }

        System.out.println(picture + "\n" + width);

    }

    static int dfs(int st, int end, int count) {
        visited[st][end] =1;
        for(int i = 0 ;i < 4; i++){
            int nx = dx[i]+st;
            int ny = dy[i]+end;

            if(nx>=0 && ny>=0 && nx<n && ny <m && visited[nx][ny]==0 && maps[nx][ny]==1){
                visited[nx][ny]=1;// ** 위에 있을 때랑 다른점 ?
                count = dfs(nx,ny, count+1);

            }

        }

        return count;
    }

}


