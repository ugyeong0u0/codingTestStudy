import java.util.*;
import java.io.*;


public class Main {


    static int n;

    static int[] arr; // [자식의 번호] => 부모

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());



        for(int i = 0 ; i< n ; i++){
            st= new StringTokenizer(br.readLine());
            st.nextToken(); // 번호

            int cnt = 0;
            arr = new int [20];

            for(int j = 0 ; j< 20 ; j++){
                arr[j]= Integer.parseInt(st.nextToken());
            }

            for(int k = 0 ; k< 20 ;k++){
                for(int a = k ; a <20; a++){
                    if(arr[k]>arr[a]){
                        cnt++;
                    }
                }

            }
            System.out.println(i+1+" "+cnt);
        }








    }

}


