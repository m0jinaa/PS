import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] used = new boolean[26];

		int n = Integer.parseInt(br.readLine());

		String input;

		String[] words;
		char[] word;

		char c;
		int m, ind;

		while (n-- > 0) {
			ind = -1;

			input = br.readLine();

			// 단어 단위로 살펴보기

			words = input.split(" ");
			m = words.length;

			for (int i = 0; i < m; i++) {
				c = words[i].charAt(0);
				if (c <= 'Z' && !used[c - 'A']) {
					used[c - 'A'] = true;
					ind = i;
					break;
				} else if (c >= 'a' && !used[c - 'a']) {
					used[c - 'a'] = true;
					ind = i;
					break;
				}
			}

			if (ind != -1) {
				for (int i = 0; i < m; i++) {
					if (ind != i) {
						sb.append(words[i]).append(" ");
					} else {
						word = words[i].toCharArray();
						int w = word.length;

						sb.append("[").append(word[0]).append("]");
						for (int j = 1; j < w; j++) {
							sb.append(word[j]);
						}
						sb.append(" ");
					}
				}
			} else {
				// 글자 단위로 살펴보기

				word = input.toCharArray();
				m = word.length;

				for (int i = 0; i < m; i++) {
					if (word[i] == ' ' || ind != -1) {
						sb.append(word[i]);
						continue;
					} else if (word[i] <= 'Z' && !used[word[i] - 'A']) {
						used[word[i] - 'A'] = true;
						sb.append("[").append(word[i]).append("]");
						ind = i;
					} else if (word[i] >= 'a' && !used[word[i] - 'a']) {
						used[word[i] - 'a'] = true;
						sb.append("[").append(word[i]).append("]");
						ind = i;
					} else {
						sb.append(word[i]);
					}
				}
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}
}