import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, k, answer;
    static int[] arr, v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 운동 개수
        k = Integer.parseInt(st.nextToken()); // 하루당 운동 감소량

        arr = new int[n];
        v= new int [n];

        answer= 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n ; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }


        dfs(0, 500);

        System.out.println(answer);
    }

    static void dfs(int dept, int sum){

        if(dept==n){
            answer++;
            return;
        }
        sum-=k; // 하루당 k만큼 운동량 감소
        for(int i =0; i< n ;i++){

            if(v[i]==0 && sum+arr[i]>=500){
                v[i]=1;
                dfs(dept+1, sum+arr[i]);
                v[i]=0;

            }

        }


    }


}
