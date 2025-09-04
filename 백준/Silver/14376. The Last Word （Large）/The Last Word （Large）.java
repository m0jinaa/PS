import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		char[] word;
		LinkedList<Character> lastWord = new LinkedList<>();
		int n;

		for (int t = 1; t <= tc; t++) {
			lastWord.clear();

			word = br.readLine().toCharArray();
			n = word.length;

			for (int i = 0; i < n; i++) {
				if (lastWord.isEmpty() || lastWord.peekFirst() > word[i]) {
					lastWord.addLast(word[i]);
				} else {
					lastWord.addFirst(word[i]);
				}
			}

			sb.append("Case #").append(t).append(": ");
			while (!lastWord.isEmpty()) {
				sb.append(lastWord.pollFirst());
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}