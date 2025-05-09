import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int min = 0;
		int max = 0;

		// 최솟값 찾기
		// 0부터 시작해서 A에 없으면 답, 있으면 개수 세서 없앨 수 있으면 답,아니면 하나 증가
		int ind = 0;
		int c = 0;

		while (ind < n) {
			// 개수 세기
			while (ind < n && min == A[ind]) {
				c++;
				ind++;
			}

			// 없앨 수 있는 개수의 숫자거나 없는 숫자인 경우
			if (c <= k) {
				break;
			}

			c = 0;
			min++;
		}

		// 최댓값 찾기
		// 0부터 살펴보면서 있으면 패스 없으면 k 개수 줄이고 패스
		ind = 0;
		int dk;
		while (ind < n) {
			if (A[ind] == max) {
				ind++;
				max++;
			} else if (A[ind] < max) {
				ind++;
			} else if (k == 0) {
				break;
			} else {
				dk = Math.min(A[ind] - max, k);
				k -= dk;
				max += dk;
			}
		}

		max += k;

		sb.append(min).append("\n").append(max).append("\n");

		System.out.print(sb.toString());
	}
}