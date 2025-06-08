import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()) + 1;

		int covered = 0;

		int size = 100;

		int[][] stacked = new int[size + 1][size + 1];

		int sx, sy, ex, ey;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			for (int x = sx; x <= ex; x++) {
				for (int y = sy; y <= ey; y++) {
					stacked[x][y]++;

					if (stacked[x][y] == m)
						covered++;
				}
			}
		}

		System.out.println(covered);
	}
}