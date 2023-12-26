import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static boolean[] v;
	static int[] A, B, C;

	static int answer = -1;

	static void getMax(int cnt, int bef, int flavor) {
		if (cnt == n) {
			answer = Math.max(answer, flavor);
		} else {
			for (int i = 0; i < n; i++) {
				if (v[i])
					continue;
				if (bef == -1) {
					v[i] = true;
					getMax(cnt + 1, i, flavor);
					v[i] = false;
				} else if (C[bef] * C[i] > k)
					continue;
				else {
					v[i] = true;
					getMax(cnt + 1, i, flavor + A[bef] * B[i]);
					v[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		A = new int[n];
		B = new int[n];
		C = new int[n];
		v = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}

		getMax(0, -1, 0);

		System.out.println(answer);

	}
}