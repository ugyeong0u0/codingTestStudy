import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//class Circle implements Comparable<Circle> {
//    int st;
//    int w;
//
//    public Circle(int st, int w) {
//        this.st = st;
//        this.w = w;
//    }
//
//    public int compareTo(Circle tmp) {
//        return w - tmp.w;
//    }
//
//
////    public String toString() {
////        return   "->"+ end + " 비용: "+ cost + "   \\\\" ;
////    }
//}

public class Main {

//    static StringBuilder sb = new StringBuilder();
    static int[] arr; // 거리

//    static HashMap<Integer,Integer> map = new HashMap<>();
    static int n, m;
//    static int startPoint = 0;
//    static ArrayList<Circle>[] maps;
//    static int[] check;

//    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 주어진 개수
        m = Integer.parseInt(st.nextToken()); // 총 랜선 수

//        m = Integer.parseInt(st.nextToken()); // 비행기 개수
//        startNode = Integer.parseInt(br.readLine());
//        check = new int[n + 1];

//        dist = new int[n + 1];
//        maps = new ArrayList[n + 1];

        arr = new int[n];
        long max= 0;
//        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
//            maps[i] = new ArrayList<>(); // **
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
            
        }

//        Arrays.sort(arr);

        long right = max+1;
        long left = 1;


        while(right>left){

            long mid = (right+left)/2;
            long count =0 ; // 전선 개수
            for(int i = 0; i<arr.length; i++){
                count += arr[i]/mid;
            }

            if(count < m){
                right = mid;
            } else if(count>=m){ // 랜선 개수끼리 비교
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }
}

