
import java.util.*;
import java.io.*;
// 입력이 4 5 6 이런경우 StringTokenizer(br.readLine(), " ") 후 nextToken이용
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long road[]=new long[n-1];
		long city[] =new long[n];
		for(int i =0 ;i<n-1;i++) {
			road[i]=Long.parseLong(st.nextToken());
//			System.out.println(road[i]);
		}
		st= new StringTokenizer(br.readLine()," ");
		for(int i =0 ;i<n;i++) {
			city[i]=Long.parseLong(st.nextToken());// 다시 초기화 해줌
//			System.out.println(city[i]);
		}
		long min = city[0];
		long ans= 0;
		for(int i=0; i<n-1;i++) {
			if(min>city[i])
				min=city[i];
			ans+=min*road[i];
		}
		System.out.println(ans);
	}

}
