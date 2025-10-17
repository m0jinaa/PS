import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Set<String> words = new HashSet<>();

		boolean first = true;

		String word;
		int player = 0;
		char last = 'a';

		boolean fair = true;

		while (n-- > 0) {
			word = br.readLine();

			if (words.contains(word) || (!first && last != word.charAt(0))) {
				fair = false;
				sb.append("Player ").append(player + 1).append(" lost\n");
				break;
			}

			first = false;
			player = 1 - player;
			last = word.charAt(word.length() - 1);
			words.add(word);
		}

		if (fair) {
			sb.append("Fair Game\n");
		}

		System.out.print(sb.toString());
	}
}