import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[][] locations = new int[8][];

		int x, y;
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		locations[0] = new int[] { x, y };
		
		st = new StringTokenizer(br.readLine()," ");
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		locations[7] = new int[] { x, y };
		
		long[][] dist = new long[8][8];
		int INF = 2_000_000_007;
		for (int i = 0; i < 8; i++) {
			Arrays.fill(dist[i], INF);
		}

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				locations[i * 2 + j + 1] = new int[] { x, y };
			}
		}
		int d;

		dist[1][2] = dist[2][1] = dist[3][4] = dist[4][3] = dist[5][6] = dist[6][5] = 10;

		for (int i = 0; i < 8; i++) {
			dist[i][i] = 0;
			for (int j = i+1; j < 8; j++) {
				d = Math.abs(locations[i][0] - locations[j][0]) + Math.abs(locations[i][1] - locations[j][1]);

				dist[i][j] = Math.min(dist[i][j], d);
				dist[j][i] = Math.min(dist[j][i], d);

			}
		}
		
		for (int k = 0; k < 8; k++) {
			for (int i = 0; i < 8; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < 8; j++) {
					if (k == j || i == j)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		System.out.println(dist[0][7]);
	}
}