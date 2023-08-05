import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		boolean[][] check = new boolean[2][2];

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x, y;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			check[(x + y) % 2][x % 2] = true;
		}
		boolean answer = true;
		end: for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (!check[i][j]) {
					answer = false;
					break end;
				}
			}
		}

		System.out.println(answer ? "YES" : "NO");
	}
}