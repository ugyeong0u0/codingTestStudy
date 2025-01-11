    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    //class Loc {
    //    int m; // 보석 무게
    //    int v; // 보석 가격
    //
    //    Loc(int m, int v) {
    //
    //        this.m = m;
    //        this.v = v;
    //    }
    //}


    public class Main {

        static int n;
        static ArrayList<int []> arr1 = new ArrayList<>(); // 실제 배열 들어가 있는 곳

        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = 1;
            while(n!=0){
                StringTokenizer st = new StringTokenizer(br.readLine());

                n = Integer.parseInt(st.nextToken());

                int [] tmp = new int[n];
                int i = 0;
                while(st.hasMoreTokens()){
                    tmp[i++] = Integer.parseInt(st.nextToken());
                }
                arr1.add(tmp);
            }

            for(int i = 0 ; i< arr1.size(); i++){
                int [] tmpArr = arr1.get(i);
                int [] co = new int [6];

                dfs(tmpArr, 0, co, 0);
                sb.append("\n");

            }


            System.out.println(sb);


        }

        static void dfs(int [] target , int dept, int [] co, int next){

            if(dept == 6){
                for(int i =0 ;i< co.length ; i++){
                    sb.append(co[i] + " ");
                }
                sb.append("\n");
                return;
            }

            for(int i=next; i<target.length;i++){

                co[dept]=target[i];
                dfs(target, dept+1, co, i+1);

            }

        }


    }



