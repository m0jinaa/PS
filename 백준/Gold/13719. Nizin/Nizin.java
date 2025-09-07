import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] nums = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		int answer = 0;

		int s = 0;
		int e = n - 1;

		long left = nums[s];
		long right = nums[e];

		// 왼쪽 오른쪽 비교해서 작은 쪽을 중앙 방향 원소와 합친다
		// 합칠 때마다 answer++ 해주기
		// 일치하면 둘 다 중앙 쪽으로 이동
		while (s < e) {
			if (left == right) {
				left = nums[++s];
				right = nums[--e];
			} else if (left < right) {
				left += nums[++s];
				answer++;
			} else {
				right += nums[--e];
				answer++;
			}
		}

		System.out.println(answer);
	}
}