import java.util.*;
import java.io.*;


public class Main {
    static int kase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        kase = Integer.parseInt(br.readLine());

        for (int i = 0; i < kase; i++) {
            int day = Integer.parseInt(br.readLine());

            Long answer =0L;

            int ju [] = new int [day];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < day; j++) {
                ju[j] = Integer.parseInt(st.nextToken());
            }
            int cur= 0;
            for (int j = day-1; j >= 0; j--) {
                    if(j-1 >=0){
                        cur = Math.max( ju[j] , cur);

                        if(cur > ju[j-1]){
                           answer+= cur - ju[j-1];
                        }
                    }
            }

            System.out.println(answer);


        }



    }


}


