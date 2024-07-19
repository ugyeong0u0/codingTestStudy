
import java.util.*;
import java.io.*;
// 바텀업 방식

/*n을 1과 2로 분해 시키기
단, 1이 연속으로 3번나오면안됨 즉 2번까지 가능,
딘, 1이 띄어져서 나오는건 가능 */

/*해결방법 : top down 방식(재귀),bottomup방식(for, 배열에 넣는 메모라이제이션 방법)
 *  현재 i칸 /두칸전(i-2) 값, (i-1)값+(i-3) 중
큰 값을 현재 i번째 계단의 값과 합하여 함.
-> 주의 : i가 3미만의 수라면 음수로 인덱스 아웃오브 바운드 뜸 */
public class Main {
	static int n;
	static int stair[];
	static Integer dp[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		stair = new int[n + 1];
		dp = new Integer[n + 1]; // Integer 객체 배열은 default값이 null

		for (int i = 1; i < n + 1; i++)
			stair[i] = Integer.parseInt(br.readLine());

		dp[1] = stair[1];
		dp[0] = stair[0]; // 인티저 객체 배열은 디폴트값이 null이라 초기화필요

		if (n >= 2) { // **
			dp[2] = stair[1] + stair[2];
		}

		System.out.println(find(n));
	}// main

	static int find(int n) { // 반환값
		if (dp[n] == null) // **
			dp[n] = Math.max(find(n - 2), find(n - 3) + stair[n - 1]) + stair[n];
		return dp[n];
	}

}
