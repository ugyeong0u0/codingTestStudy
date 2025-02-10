import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, vN, lineN, v1, v2;
    static boolean result;
    static int[] color;
    //    static int[][] maps, visited;
    static ArrayList<ArrayList<Integer>> a;
    static StringBuilder sb = new StringBuilder();


    //    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine()); // 케이스 개수

        for (int i = 0; i < n; i++) {
            a = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            vN = Integer.parseInt(st.nextToken());
            lineN = Integer.parseInt(st.nextToken());
            color = new int[vN + 1]; // 색이 같은지 확인

            for (int l = 0; l <= vN; l++) { // l 0부터 시작해야함
                a.add(new ArrayList<>()); // arr은 1부터 시작함
            }

            for (int j = 0; j < lineN; j++) {
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken()); // 정점 1부터 시작

                a.get(v1).add(v2);
                a.get(v2).add(v1);

            }

            result = false;

            for (int j = 1; j <= vN; j++) { // 한줄로 작성가능함!! 굳이 두개의 for문을 사용해서 벌써부터 arr에서 값 꺼낼 필요 없음
                if (color[j] == 0)
                    result = bfs(j);

                if (!result)
                    break;
            }

            if (!result) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }


        }
        System.out.println(sb);


    }
    static boolean bfs(int now){
        Queue<Integer> q= new LinkedList<>();

        q.add(now); // **
        color[now] =1;

        while(!q.isEmpty()){

            int cur = q.poll();

            for(int i :  a.get(cur)){ // *****
                if(color[i]==0){
                    q.offer(i);
                    color[i] = color[cur] * -1;
                }
                if(color[i]==color[cur]){
                    return false;
                }
            }
        }

        return true;
    }
}
