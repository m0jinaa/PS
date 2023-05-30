import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static boolean[][] map;
	static int[] put;
	static boolean[] used;
	static ArrayList<Integer>[] canPut;

	static boolean match(int x) {
		for (int y = 1; y <= C; y++) {

			if (map[x][y] || used[y])
				continue;
			used[y] = true;
			if (put[y] == 0 || match(put[y])) {
				put[y] = x;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		map = new boolean[R+1][C+1];
		int x, y;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			map[x][y] = true;
		}

		used = new boolean[C + 1];
		put = new int[C + 1];

		int cnt = 0;

		for (int i = 1; i <= R; i++) {
			Arrays.fill(used, false);
			if (match(i)) {
				cnt++;
			}
		}
        
		System.out.println(cnt);
	}
}