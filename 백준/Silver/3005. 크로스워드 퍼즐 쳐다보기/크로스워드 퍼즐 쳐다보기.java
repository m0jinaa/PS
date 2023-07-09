import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][];

		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		String word = "";
		TreeSet<String> words = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			word = "";
			for (int j = 0; j < m; j++) {
				if (board[i][j] == '#') {
					if (word.length() >= 2) {
						words.add(word);
					}
					word = "";
				} else {
					word += board[i][j];

					if (j == m - 1 && word.length() >= 2) {
						words.add(word);
						word = "";
					}
				}
			}
		}

		for (int j = 0; j < m; j++) {
			word = "";
			for (int i = 0; i < n; i++) {
				if (board[i][j] == '#') {
					if (word.length() >= 2) {
						words.add(word);
					}
					word = "";
				} else {
					word += board[i][j];

					if (i == n - 1 && word.length() >= 2) {
						words.add(word);
						word = "";
					}
				}
			}
		}

		System.out.println(words.first());
	}
}