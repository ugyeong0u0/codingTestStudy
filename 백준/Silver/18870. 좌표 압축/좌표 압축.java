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

    static StringBuilder sb = new StringBuilder();
    static int[] arr, answer; // 거리

    static HashMap<Integer,Integer> map = new HashMap<>();
    static int t, n, m, count, startNode;
    static int startPoint = 0;
//    static ArrayList<Circle>[] maps;
//    static int[] check;

//    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 좌표 개수
//        m = Integer.parseInt(st.nextToken()); // 비행기 개수
//        startNode = Integer.parseInt(br.readLine());
//        check = new int[n + 1];

//        dist = new int[n + 1];
//        maps = new ArrayList[n + 1];

        arr = new int[n];
        answer= new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
//            maps[i] = new ArrayList<>(); // **
            arr[i] = Integer.parseInt(st.nextToken());
            answer[i]= arr[i];
        }

        Arrays.sort(arr);





        int k = 0;

        // 상한 하한 정해야 같은 수로 만듦

        int i = 0;
        while (i < n) {
            int start = findFirst(arr[i]);
            int end = findEnd(arr[i]);
//            System.out.println(k);

//            System.out.println(arr[i] + "  " + start+"   "+ end);

//            System.out.println(i);
            map.put(arr[i], k);

            for (int j = start; j < end; j++) {
               i++;
            }


            k++;
        }

        for(int j =0 ;j <n;j++){
            sb.append(map.get(answer[j])).append(" ");
        }


        System.out.println(sb);
    }

    static int findFirst(int target) {
        int l = startPoint;
        int r = arr.length - 1;

        // 하한 구하기
        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] >= target) { //중요한건 mid 값이 target 일때 어디를 높일건지임 이건 내가 하한을 idx로해서 이렇게되니 그걸 기준으로 생각하기
                r = mid; // mid-1 이든 상관 x ? 있음 타겟 인덱스가 r이 되어버림 근데 m는 /2할때 내림이라 전 mid이자 현재 r에 mid가 될 수 없음!!
            } else if (arr[mid] < target) {
                l = mid + 1; // ㅣ은 mid 구할때 /2는 내림해버려서 무조건 +1 해줘야함 안그럼 mid/2 == l하고 같아져서 무한루프돔
            }

        }
        return l;


    }

    // 상한 구하기
    static int findEnd(int target) {
        int l = startPoint;
        int r = arr.length; // ** 상한은 idx+1이기 때문


        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] > target) {
                r = mid;
            } else if (arr[mid] <= target) {
                l = mid + 1;
            }

        }
        return l;

    }


}

