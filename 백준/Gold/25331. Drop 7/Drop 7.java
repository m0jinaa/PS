import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n = 7;
	static int[][] map;
	static int[] vertical;

	static void gravity() {
		int c;

		for (int i = 0; i < n; i++) {
			vertical[i] = 0;
		}

		for (int j = 0; j < n; j++) {
			c = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (map[i][j] == 0)
					c++;
				else {
					map[i + c][j] = map[i][j];

					vertical[j]++;

					if (c != 0) {
						map[i][j] = 0;
					}
				}
			}
		}
	}

	static boolean check() {
		boolean changed = false;
		int c = 0;
		int s, e;
		for (int i = 0; i < n; i++) {
			s = 0;
			e = -1;
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					c = e - s + 1;

					while (c != 0 && s <= e) {
						if (map[i][s] == c) {
							map[i][s] = 0;
							changed = true;
						}
						s++;
					}

					s = j + 1;
					e = j;
					continue;
				} else {
					e++;
				}
			}

			c = e - s + 1;

			while (c != 0 && s <= e) {
				if (map[i][s] == c) {
					map[i][s] = 0;
					changed = true;
				}
				s++;
			}

			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0)
					continue;
				else if (vertical[j] == map[i][j]) {
					map[i][j] = 0;
					changed = true;
				}
			}
		}

		return changed;
	}

	static int drop(int ind, int x) {
		map[n - 1 - vertical[ind]][ind] = x;
		vertical[ind]++;

		while (check()) {
			gravity();
		}

		int c = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0)
					continue;
				c++;
			}
		}

		return c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] init = new int[n][n];
		int[] v = new int[n];

		vertical = new int[n];
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				init[i][j] = Integer.parseInt(st.nextToken());

				if (init[i][j] != 0) {
					v[j]++;
				}
			}
		}

		int x = Integer.parseInt(br.readLine());

		int answer = n * n;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.arraycopy(init[j], 0, map[j], 0, n);
			}
			System.arraycopy(v, 0, vertical, 0, n);

			answer = Math.min(answer, drop(i, x));
		}

		System.out.println(answer);
	}
}