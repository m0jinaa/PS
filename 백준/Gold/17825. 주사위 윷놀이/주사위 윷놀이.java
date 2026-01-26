import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int D = 10;
	static int n = 33;
	static int[][] piece = new int[][] { { 0, 1, 2, 3, 4, 5 }, { 0, 2, 3, 4, 5, 6 }, { 0, 3, 4, 5, 6, 7 },
			{ 0, 4, 5, 6, 7, 8 }, { 0, 5, 6, 7, 8, 9 }, { 0, 22, 23, 24, 25, 26 }, { 0, 7, 8, 9, 10, 11 },
			{ 0, 8, 9, 10, 11, 12 }, { 0, 9, 10, 11, 12, 13 }, { 0, 10, 11, 12, 13, 14 }, { 0, 28, 29, 25, 26, 27 },
			{ 0, 12, 13, 14, 15, 16 }, { 0, 13, 14, 15, 16, 17 }, { 0, 14, 15, 16, 17, 18 }, { 0, 15, 16, 17, 18, 19 },
			{ 0, 32, 31, 30, 25, 26 }, { 0, 17, 18, 19, 20, 21 }, { 0, 18, 19, 20, 21, 21 }, { 0, 19, 20, 21, 21, 21 },
			{ 0, 20, 21, 21, 21, 21 }, { 0, 21, 21, 21, 21, 21 }, { 0, 21, 21, 21, 21, 21 }, { 0, 23, 24, 25, 26, 27 },
			{ 0, 24, 25, 26, 27, 20 }, { 0, 25, 26, 27, 20, 21 }, { 0, 26, 27, 20, 21, 21 }, { 0, 27, 20, 21, 21, 21 },
			{ 0, 20, 21, 21, 21, 21 }, { 0, 29, 25, 26, 27, 20 }, { 0, 25, 26, 27, 20, 21 }, { 0, 25, 26, 27, 20, 21 },
			{ 0, 30, 25, 26, 27, 20 }, { 0, 31, 30, 25, 26, 27 } };
	static int[] v = new int[] { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, 13,
			16, 19, 25, 30, 35, 22, 24, 26, 27, 28 };

	static boolean[] occupied;
	static int[] dice;

	static int move(int ind, int a, int b, int c, int d) {
		if (ind == D)
			return 0;
		else {
			int na, nb, nc, nd;
			int max = 0;
			// a 움직이기
			if (a != 21) {
				na = piece[a][dice[ind]];
				if (na == 21 || !occupied[na]) {
					occupied[a] = false;
					occupied[na] = true;
					max = Math.max(max, move(ind + 1, na, b, c, d) + v[na]);
					occupied[a] = true;
					occupied[na] = false;
				}
			}
			// b 움직이기
			if (b != 21) {
				nb = piece[b][dice[ind]];
				if (nb == 21 || !occupied[nb]) {
					occupied[b] = false;
					occupied[nb] = true;
					max = Math.max(max, move(ind + 1, a, nb, c, d) + v[nb]);
					occupied[b] = true;
					occupied[nb] = false;
				}
			}
			// c 움직이기
			if (c != 21) {
				nc = piece[c][dice[ind]];
				if (!occupied[nc]) {
					occupied[c] = false;
					occupied[nc] = true;
					max = Math.max(max, move(ind + 1, a, b, nc, d) + v[nc]);
					occupied[c] = true;
					occupied[nc] = false;
				}
			}
			// d 움직이기
			if (d != 21) {
				nd = piece[d][dice[ind]];
				if (!occupied[nd]) {
					occupied[d] = false;
					occupied[nd] = true;
					max = Math.max(max, move(ind + 1, a, b, c, nd) + v[nd]);
					occupied[d] = true;
					occupied[nd] = false;
				}
			}

			return max;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		dice = new int[D];
		occupied = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < D; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		int answer = move(0, 0, 0, 0, 0);

		System.out.println(answer);
	}
}