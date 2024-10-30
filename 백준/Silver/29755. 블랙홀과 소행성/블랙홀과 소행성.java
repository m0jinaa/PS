import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] A, B, W;

	static int check(int p) {
		int s = 0;
		int e = n - 1;
		int mid;

		// 소행성과 가장 무게가 가까운 블랙홀 찾기
		while (s <= e) {
			mid = (s + e) / 2;
			if (B[mid] == p) {
				return p;
			} else if (B[mid] > p) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		// 둘 중 가장 차이가 적은 쪽 return
		if (e < 0) {
			return B[0];
		} else if (s >= n) {
			return B[n - 1];
		} else {
			return Math.abs(p - B[s]) < Math.abs(p - B[e]) ? B[s] : B[e];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		B = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		A = new int[m];
		W = new int[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			A[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(B);

		int answer = 0;

		int p;

		for (int i = 0; i < m; i++) {
			// i번째 소행성을 블랙홀이 빨아들이기 위해 필요한 최소의 P;
			p = Math.abs(check(A[i]) - A[i]) * W[i];

			answer = Math.max(answer, p);
		}

		System.out.println(answer);
	}
}