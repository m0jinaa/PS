import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] R, B;

	static int findR(int s, int e, int x) {// [R[s]~R[e]중 x보다 같거나 큰거 찾기
		int ret = e + 1;

		int mid;

		while (s <= e) {
			mid = (s + e) / 2;

			if (R[mid] >= x) {
				ret = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		return ret;
	}

	static int findB(int s, int e, int x) {// [B[s]~B[e]중 x보다 같거나 큰거 찾기
		int ret = e + 1;

		int mid;

		while (s <= e) {
			mid = (s + e) / 2;

			if (B[mid] >= x) {
				ret = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		char[] S = br.readLine().toCharArray();

		R = new int[n];
		B = new int[n];

		int rInd = 0;
		int bInd = 0;

		for (int i = 0; i < n; i++) {
			if (S[i] == 'R') {
				R[rInd++] = i;
			} else if (S[i] == 'B') {
				B[bInd++] = i;
			}
		}

		// a,b,c,d 찾기

		int l, r;

		int a = -1, b = -1, c = -1, d = -1;
		boolean possible;

		while (q-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			possible = true;

			a = findR(0, rInd - 1, l);

			if (a == rInd || R[a] > r) {
				possible = false;
			} else {

				b = findR(a + 1, rInd - 1, R[a] + 1);

				if (b == rInd || R[b] > r) {
					possible = false;
				} else {

					c = findB(0, bInd - 1, R[b] + 1);

					if (c == bInd || B[c] > r) {
						possible = false;
					} else {

						d = findB(c + 1, bInd - 1, B[c] + 1);

						if (d == bInd || B[d] > r) {
							possible = false;
						}
					}
				}
			}

			if (possible) {
				sb.append(R[a]).append(" ").append(R[b]).append(" ").append(B[c]).append(" ").append(B[d]).append("\n");
			} else {
				sb.append("-1\n");
			}
		}

		System.out.println(sb.toString());
	}
}