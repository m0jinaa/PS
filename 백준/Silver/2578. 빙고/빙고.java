import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] loc = new int[26][2];

		int x;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 5; j++) {
				x = Integer.parseInt(st.nextToken());

				loc[x][0] = i;
				loc[x][1] = j;
			}
		}

		int[] h = new int[5];
		int[] v = new int[5];
		int[] d = new int[2];

		int answer = -1;

		int bingo = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 5; j++) {
				x = Integer.parseInt(st.nextToken());

				if (++h[loc[x][0]] == 5) {
					bingo++;
				}

				if (++v[loc[x][1]] == 5) {
					bingo++;
				}

				if (loc[x][0] == loc[x][1] && ++d[0] == 5) {
					bingo++;
				}

				if (loc[x][0] + loc[x][1] == 4 && ++d[1] == 5) {
					bingo++;
				}

				if (answer == -1 && bingo >= 3) {
					answer = i * 5 + j + 1;
				}
			}
		}

		System.out.println(answer);
	}
}