import java.util.*;
import java.io.*;


public class Main {

    static int money, bnpM,timM, bnp, timing ;
    static int[]  stock;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        money = Integer.parseInt(br.readLine());
        bnpM = timM = money;

        bnp = 0;
        timing = 0;
        stock = new int [14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {

            stock[i] =Integer.parseInt(st.nextToken());

        }
        int minus= 0;
        int up =0; // 3일 연속 상승
        for(int i =0 ; i< 14 ; i++){
            int today = stock[i];
            // bnp
            if(today<=bnpM){
                int tmp =bnpM/today;
                bnp += tmp; // 산 주식 수
                bnpM -= tmp *today; // 남은 현금
            }

            if(i-1>0 && stock[i-1]<stock[i]){
                up++;
                minus=0;
            }
            else if(i-1>0 && stock[i-1]>stock[i]){
                minus++;
                up=0;
            }else{
                minus= 0;
                up=0;
            }

            if(up==3 ){
                up=0;
                timM+=today * timing;
                timing = 0;
            }
            if(minus==3){
                minus=0;

                int tmp = timM/today;
                timing+=tmp;
                timM -= today *tmp;
            }


        }

        int b = bnpM + bnp * stock[13];
        int a = timM + timing * stock[13];

        if(b==a){
            System.out.println("SAMESAME");
        }else{
            if(a<b){
                System.out.println("BNP");
            }if(a>b){
                System.out.println("TIMING");
            }
        }
    }



}


