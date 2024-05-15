import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] height = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			height[i] = Long.parseLong(st.nextToken());
		}

		long answer = 0;
		long l, r, p;
		l = height[1];
		p = height[1];
		r = height[1];

		int i = 2;

		while (i <= n) {
			// peak 찾기
			while (i <= n && height[i] >= height[i - 1]) {
				p = height[i];
				r = height[i];
				i++;
			}

			// 오른쪽 찾기

			while (i <= n && height[i] <= height[i - 1]) {
				r = height[i];
				i++;
			}

			answer = Math.max(answer, Math.min(p - l, p - r));

			if (i <= n) {
				l = height[i - 1];
				p = height[i - 1];
				r = height[i - 1];
			}
		}
        
		System.out.println(answer);
	}
}