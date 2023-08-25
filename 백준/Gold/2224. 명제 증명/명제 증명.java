import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int getInd(char c) {
		if (65 <= c && c <= 90) {
			return c - 65;
		} else {
			return c - 97 + 26;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		boolean[][] graph = new boolean[52][52];

		char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int p, q;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " => ");
			p = getInd(st.nextToken().charAt(0));
			q = getInd(st.nextToken().charAt(0));

			graph[p][q] = true;
		}

		for (int k = 0; k < 52; k++) {
			for (int i = 0; i < 52; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < 52; j++) {
					if (k == j || i == j)
						continue;
					graph[i][j] = graph[i][j] | (graph[i][k] && graph[k][j]);
				}
			}
		}
		int cnt = 0;

		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				if (i == j || !graph[i][j])
					continue;
				cnt++;
				sb.append(alphabet[i]).append(" => ").append(alphabet[j]).append("\n");
			}
		}

		System.out.println(cnt + "\n" + sb.toString());
	}
}