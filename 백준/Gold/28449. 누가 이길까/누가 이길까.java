import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] A;
	static int[] B;

	static int findLeft(int x) {
		int s = 0;
		int e = m - 1;

		int ret = -1;

		int mid;

		while (s <= e) {
			mid = (s + e) / 2;

			if (B[mid] < x) {
				ret = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		A = new int[n];
		B = new int[m];
		int[] Bcount = new int[100001];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			Bcount[B[i]]++;
		}

		Arrays.sort(B);

		long win = 0;
		long lose = 0;
		long tie = 0;

		int l;

		for (int a : A) {
			l = findLeft(a);

			win += (l + 1);
			tie += Bcount[a];
			lose += (m - l - 1 - Bcount[a]);
		}

		sb.append(win).append(" ").append(lose).append(" ").append(tie);

		System.out.println(sb.toString());
	}
}