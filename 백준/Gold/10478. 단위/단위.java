import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class Unit implements Comparable<Unit> {
		int d;
		String u;

		public Unit(int d, String u) {
			super();
			this.d = d;
			this.u = u;
		}

		@Override
		public int compareTo(Unit unit) {
			return this.d - unit.d;
		}

		@Override
		public String toString() {
			return this.d + this.u;
		}
	}

	static String[] measure;
	static int ind = 0;
	static Map<String, Integer> map;

	static int getInd(String x) {
		if (!map.containsKey(x)) {
			map.put(x, ind++);
		}

		return map.get(x);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		map = new HashMap<>();
		String x;
		int index;

		String a, b;
		int indA, indB, c;
		int[][] mult, div;
		int start;
		Unit[] list;
		boolean zero;

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			map.clear();
			ind = 0;
			measure = new String[n];
			mult = new int[n][n];
			div = new int[n][n];
			list = new Unit[n];

			// 단위 종류 입력받기
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				x = st.nextToken();
				index = getInd(x);

				measure[index] = x;
				mult[i][i] = 1;
				div[i][i] = 1;
			}

			// 단위간의 관계 입력받기
			for (int i = 1; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				a = st.nextToken();
				st.nextToken();
				c = Integer.parseInt(st.nextToken());
				b = st.nextToken();

				indA = getInd(a);
				indB = getInd(b);

				mult[indA][indB] = c;
				div[indB][indA] = c;
			}

			// 플로이드 워셜
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (k == i || i == j || j == k)
							continue;

						if (mult[i][k] != 0 && mult[k][j] != 0) {
							mult[i][j] = mult[i][k] * mult[k][j];
							div[j][i] = mult[i][j];
						} else if (mult[i][k] != 0 && div[k][j] != 0) {
							if (mult[i][k] > div[k][j]) {
								mult[i][j] = mult[i][k] / div[k][j];
								div[j][i] = mult[i][j];
							} else {
								div[i][j] = div[k][j] / mult[i][k];
								mult[j][i] = div[i][j];
							}
						} else if (div[i][k] != 0 && mult[k][j] != 0) {
							if (div[i][k] > mult[k][j]) {
								div[i][j] = div[i][k] / mult[k][j];
								mult[j][i] = div[i][j];
							} else {
								mult[i][j] = mult[k][j] / div[i][k];
								div[j][i] = mult[i][j];
							}
						} else if (div[i][k] != 0 && div[k][j] != 0) {
							div[i][j] = div[i][k] * div[k][j];
							mult[j][i] = div[i][j];
						}
					}
				}
			}

			// 시작지점 찾기
			start = 0;

			for (int i = 0; i < n; i++) {
				zero = false;
				for (int j = 0; j < n; j++) {
					if (mult[i][j] == 0) {
						zero = true;
						break;
					}
				}
				if (!zero) {
					start = i;
					break;
				}
			}

			for (int i = 0; i < n; i++) {
				list[i] = new Unit(mult[start][i], measure[i]);
			}

			Arrays.sort(list);

			for (int i = 0; i < n; i++) {
				sb.append(i == 0 ? "" : " = ").append(list[i].toString());
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}