import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n, m;
	static int[] dx;
	static boolean[][] cantPut;
	static boolean[] used;
	static int[] put;

	static boolean domino(int x) {
		int y;
		for (int i = 0; i < 4; i++) {
			y = x + dx[i];
			if (cantPut[x][i] || used[y])
				continue;
			used[y] = true;
			if (put[y] == 0 || domino(put[y])) {
				put[y] = x;
				put[x] = y;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dx = new int[] { -m, -1, m, 1 };
		int N = n * m;

		cantPut = new boolean[N + 1][4];// 상,좌,하,우
		used = new boolean[N + 1];
		put = new int[N + 1];
		int l = Integer.parseInt(br.readLine());

		int x, y;
		while (l-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 4; i++) {
				if (x + dx[i] == y) {
					cantPut[x][i] = true;
					cantPut[y][(i + 2) % 4] = true;
				}
			}
		}
		
		for(int i = 1;i<=m;i++) {
			cantPut[i][0] = true;
			cantPut[N+1-i][2] = true;
		}
		
		for(int i = 0;i<n;i++) {
			cantPut[i*m+1][1] = true;
			cantPut[(i+1)*m][3] = true;
		}
		
		for (int i = 1; i < N; i++) {
			if (put[i] != 0)
				continue;
			Arrays.fill(used, false);
			domino(i);
		}

		for (int i = 1; i <= N; i++) {
			if (put[i] > i) {
				sb.append(i).append(" ").append(put[i]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}