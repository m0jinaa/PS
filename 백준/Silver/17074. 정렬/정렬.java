import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] nums = new int[n + 2];

		nums[0] = -1_000_000_007;
		nums[n + 1] = 1_000_000_007;

		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int c = 0;
		int ind = -1;

		for (int i = 1; i <= n; i++) {
			if (nums[i] < nums[i - 1]) {
				c++;
				ind = i;
			}
		}

		int answer = 0;

		if (c == 0)
			answer = n;
		else if (c > 1)
			answer = 0;
		else {
			// 현재 위치 뺐을 때 성립?
			if (nums[ind - 1] <= nums[ind + 1])
				answer++;
			// 이전 꺼 뺐을 때 성립?
			if (nums[ind - 2] <= nums[ind])
				answer++;
		}

		System.out.println(answer);
	}
}