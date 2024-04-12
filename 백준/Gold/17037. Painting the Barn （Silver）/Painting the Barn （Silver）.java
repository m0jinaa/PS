import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] coat = new int[1001][1001];

		int x1, y1, x2, y2;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				coat[i][y1]++;
				coat[i][y2]--;
			}
		}

		int answer = 0;

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (coat[i][j] == k)
					answer++;
				coat[i][j + 1] += coat[i][j];
			}
		}

		System.out.println(answer);

	}
}