import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.sound.midi.Synthesizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] pair = new int[5][5];
		boolean[] can = new boolean[5];
		int t;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 5; j++) {
				t = Integer.parseInt(st.nextToken());
				can[j] = 1 == t;
			}
			for (int j = 0; j < 5; j++) {
				if (!can[j])
					continue;
				for (int k = j + 1; k < 5; k++) {
					if (!can[k])
						continue;
					pair[j][k]++;
				}
			}

		}

		int answer = -1;
		int x = -1, y = -1;

		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (pair[i][j] > answer) {
					answer = pair[i][j];
					x = i;
					y = j;
				}
			}
		}
		sb.append(answer).append("\n");

		for (int i = 0; i < 5; i++) {
			if (x == i || y == i) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			if (i < 4)
				sb.append(" ");
		}

		System.out.println(sb.toString());
	}
}