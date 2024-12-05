import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
/*
 *
 *
 * */

//class Loc {
//    int x;
//    int y, answer;
//
//
//    public Loc(int x, int y) {
//        this.x = x;
//        this.y = y;
//
//    }
//
//
//}

public class Main {

    static int n, answer, sum, arrN;
    static int[] maps;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 테케 수
        arrN = Integer.parseInt(st.nextToken());



        answer = 0;
        sum = 0;
        maps = new int[n+1]; // 인덱스가 행, 값이 열

        /*
         * 1. 몇 번 반복할지 -> 재귀호출로 정함
         * 2.
         *
         * */
        ArrayList<Integer> list2 = new ArrayList<>();
        bfs(0, 1,list2);

//        Collections.sort(list);

//        System.out.println(list.size());

        for(int i= 0; i<list.size(); i++){
            ArrayList<Integer> tmp =list.get(i);
            for(int j =0 ; j< tmp.size(); j++){
                System.out.print(tmp.get(j)+" ");
            }
            System.out.println();

        }



    }

    static void bfs(int dept, int next, ArrayList<Integer> arr3) { // dept

        if(dept == arrN){
            list.add(new ArrayList<>(arr3)); // 얼레이리스트는 참조로 저장되기 때문에 최종 arr3가 list에 저장됨. 복사본 저장이 필요
            return;
        }


        for(int i =next; i<= n; i++){

            arr3.add(i);
//            System.out.println("결과"+arr3.get(arr3.size()-1));
            bfs(dept+1, i+1, arr3);
            arr3.remove(arr3.size()-1);

        }
    }


}
