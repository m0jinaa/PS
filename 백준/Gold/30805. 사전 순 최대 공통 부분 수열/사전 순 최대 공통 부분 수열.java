import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Num implements Comparable<Num> {
		int x, ind;

		public Num(int x, int ind) {
			super();
			this.x = x;
			this.ind = ind;
		}

		@Override
		public int compareTo(Num num) {
			if (this.x != num.x) {
				return num.x - this.x;
			} else {
				return this.ind - num.ind;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int x;

		int n = Integer.parseInt(br.readLine());

		Num[] A = new Num[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			A[i] = new Num(x, i);
		}

		int m = Integer.parseInt(br.readLine());

		Num[] B = new Num[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			x = Integer.parseInt(st.nextToken());
			B[i] = new Num(x, i);
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int indA = 0;
		int indB = 0;
		int maxA = -1;
		int maxB = -1;

		int k = 0;

		while (indA < n && indB < m) {
			if (A[indA].x == B[indB].x) {
				if (A[indA].ind < maxA)
					indA++;
				else if (B[indB].ind < maxB)
					indB++;
				else {
					k++;
					sb.append(A[indA].x).append(" ");
					maxA = A[indA].ind;
					maxB = B[indB].ind;
					indA++;
					indB++;
				}
			} else if (A[indA].x > B[indB].x) {
				indA++;
			} else {
				indB++;
			}
		}

		System.out.println(k);

		if (k != 0)
			System.out.println(sb.toString());
	}
}