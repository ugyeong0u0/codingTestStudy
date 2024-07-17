import java.util.*;
import java.io.*;


class People {
    int w;
    int h;

    public People(int w, int h) {

        this.w = w;
        this.h = h;
    }

}


public class Main {


    static int n;
    static List<People> list = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];


        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new People(a, b));


        }


        for (int i = 0; i < n; i++) {
            int tear = 1;
            People tar = list.get(i);
            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                People p = list.get(j);

                if (tar.w < p.w && tar.h < p.h) {
                    tear++;
                }
            }
            arr[i] = tear;
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {

            int a = arr[i];
            sb.append(a).append(' ');
        }

        System.out.println(sb);

    }


}