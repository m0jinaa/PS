import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] lightburb = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			lightburb[i] = Integer.parseInt(st.nextToken());
		}

		int[] group = new int[n];

		int ind = 0;

		int cnt = 1;

		// 교차로 놓여있는 전구의 그룹 및 개수 구하기

		for (int i = 1; i < n; i++) {
			if (lightburb[i] == lightburb[i - 1]) {
				group[ind++] = cnt;
				cnt = 1;
			} else {
				cnt++;
			}
		}

		group[ind] = cnt;

		int answer = 0;

		int sum = 0;

		// 최대 3그룹의 합이 가장 큰거 구하기
		for (int i = 0; i <= ind; i++) {
			sum += group[i];

			if (i >= 3) {
				sum -= group[i - 3];
			}
			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}