import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int budget = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());

		int[] present = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			present[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(present);

		int s = n - 1;
		int e = n - 1;
		long cost = 0;
		long estimate = 0;

		int answer = 0;

		while (s >= 0) {
			if ((e - s + 1) <= a) { // 할인 가능
				estimate = cost + present[s] / 2;
			} else {// 할인 안됨
				estimate = cost + present[s];
			}

			if (estimate <= budget) {// 예산내로 가능
				answer = Math.max(answer, e - s + 1);
				s--;

				cost = estimate;
			} else {// 예산 안됨
				cost -= present[e--] / 2;

				if ((e - s) >= a) { // 할인 적용 가능한게 있을 때
					cost -= present[e - a + 1] / 2;
				}
			}
		}

		System.out.println(answer);
	}
}