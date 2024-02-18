import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		int n;
		char[][] mbti;

		int diff, min;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");

			if (n > 32) {
				sb.append(0).append("\n");
				continue;
			}

			mbti = new char[n][4];

			for (int i = 0; i < n; i++) {
				mbti[i] = st.nextToken().toCharArray();
			}
			min = 100;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						diff = 0;
						for (int l = 0; l < 4; l++) {
							if (mbti[i][l] != mbti[j][l])
								diff++;
							if (mbti[i][l] != mbti[k][l])
								diff++;
							if (mbti[k][l] != mbti[j][l])
								diff++;
						}
						min = Math.min(min, diff);
					}
				}
			}

			sb.append(min).append("\n");
		}

		System.out.println(sb.toString());
	}
}