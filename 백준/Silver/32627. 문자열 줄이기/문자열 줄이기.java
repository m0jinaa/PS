import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Word implements Comparable<Word> {
		char c;
		int ind;

		public Word(char c, int ind) {
			super();
			this.c = c;
			this.ind = ind;
		}

		@Override
		public int compareTo(Word w) {
			if (this.c != w.c) {
				return this.c - w.c;
			} else {
				return this.ind - w.ind;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Word[] words = new Word[n];

		char[] word = br.readLine().toCharArray();

		for (int i = 0; i < n; i++) {
			words[i] = new Word(word[i], i);
		}

		Arrays.sort(words);

		boolean[] erased = new boolean[n];

		for (int i = 0; i < m; i++) {
			erased[words[i].ind] = true;
		}

		for (int i = 0; i < n; i++) {
			if (erased[i])
				continue;
			sb.append(word[i]);
		}

		System.out.println(sb.toString());
	}
}