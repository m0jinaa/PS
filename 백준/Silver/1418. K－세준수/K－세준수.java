import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int[] maxDivider = new int[n + 1];

		maxDivider[1] = 1;

		for (int i = 2; i <= n; i++) {
			// 소수인지 확인
			if (maxDivider[i] != 0)
				continue;

			maxDivider[i] = i;

			for (int j = i * 2; j <= n; j += i) {
				maxDivider[j] = i;
			}
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (maxDivider[i] == 0 || maxDivider[i] > k)
				continue;
			answer++;
		}

		System.out.println(answer);
	}
}