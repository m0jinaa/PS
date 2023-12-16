import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 0;
		int d = 0; // -1 : 감소하는 방향 , 1: 증가하는 방향

		long answer = 0;

		while (e < n) {

			if (d == 0 || (A[e] - A[e - 1]) * d < 0) {
				if (e - s > 0) {
					if (A[e] - A[e - 1] > 0) {
						d = 1;
					} else {
						d = -1;
					}
				}
			} else if (A[e] == A[e - 1]) {
				s = e;
				d = 0;
			} else if (A[e] < A[e - 1]) {
				s = e - 1;
				d = -1;
			} else {
				s = e - 1;
				d = 1;
			}

			answer += (e - s + 1);

			e++;
		}

		System.out.println(answer);
	}
}