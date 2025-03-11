    import javax.crypto.spec.PSource;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;


    public class Main {

        static int n, m; // 용액 개수
        static int[] arr;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //        StringTokenizer st = new StringTokenizer(br.readLine());
            // 변수 초기화
            n = Integer.parseInt(br.readLine());
    //        m = Integer.parseInt(br.readLine());

            arr = new int[n]; // arr 정렬하면 arr[0] = 0 도 같이 정렬됨!!! 주의 !

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i <n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int answer = 0;

            for (int i =0; i < n; i++) { // 음수있을 경우 움 + 양수면  i 는 1부터 가능
                int target = arr[i];

                int starter = 0;
                int end = n-1; // **

                while (starter < end) {

                    if(starter == i || end ==i){
                        if(starter== i){
                            starter++;
                        }else if(end==i){
                            end--;
                        }
                        continue;
                    }

                    int sum = arr[starter] + arr[end];

                    if (sum <= target) {
                        if (sum == target) {
//                            System.out.println(arr[i] + "  " +arr[starter]+":" + starter+ " "+"   "+ arr[end]+ " : "+ end);

                            answer++;
                            break;
                        }

                        starter++;
                    } else {
                        end--;
                    }

                }



            }


            System.out.println(answer);
        }
    }

