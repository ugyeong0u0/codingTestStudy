import java.util.*;
import java.io.*;


public class Main {

    static int n, max, min;
    static int [] arr, de;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        max= Integer.MIN_VALUE;
        min= Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr= new int[n];
        de = new int [4];
        for(int i = 0 ;i< n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i< 4 ;i++){
            de[i]= Integer.parseInt(st.nextToken());
        }
        dfs(arr[0],1);
        System.out.println(max);
        System.out.println(min);


    }
    static void dfs(int fir , int tIdx){

        if(tIdx==n){
            max=Math.max(max,fir);
            min=Math.min(min,fir);
        }
        for(int i = 0; i< 4;i++){

            if(de[i]!=0){
                de[i]--;
                int result;
                switch(i){
                    case 0 :{
                        result = fir + arr[tIdx];
                        dfs(result, tIdx+1);
                        break;
                    }
                    case 1 :{
                        result = fir - arr[tIdx];
                        dfs(result, tIdx+1);
                        break;
                    }
                    case 2 :{
                        result = fir * arr[tIdx];
                        dfs(result, tIdx+1);
                        break;
                    }
                    case 3 :{

                        int tmp = fir;
                        if(tmp<0){
                            tmp = -1*tmp;
                            result = tmp / arr[tIdx]; // 양수
                            dfs(-result, tIdx+1);
                            break;
                        }
                        result = tmp / arr[tIdx]; // 양수
                        dfs(result, tIdx+1);
                        break;
                    }
                }
                de[i]++;
            }



        }


    }

}


