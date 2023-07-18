import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static class Code {
		char c;
		int ind;
		char[] words;

		public Code(char c, int ind, int n) {
			super();
			this.c = c;
			this.ind = ind;
			this.words = new char[n];
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] word = br.readLine().toCharArray();
		char[] arr = br.readLine().toCharArray();

		int n = word.length;
		int m = arr.length;
		int l = m / n;

		Code[] codes = new Code[n];

		for (int i = 0; i < n; i++) {
			codes[i] = new Code(word[i], i, l);
		}

		Arrays.sort(codes, new Comparator<Code>() {

			@Override
			public int compare(Code c1, Code c2) {
				return c1.c - c2.c;
			}

		});
		int x, y;
		for (int i = 0; i < m; i++) {
			x = i / l;
			y = i % l;
			codes[x].words[y] = arr[i];
		}

		Arrays.sort(codes, new Comparator<Code>() {

			@Override
			public int compare(Code c1, Code c2) {
				return c1.ind - c2.ind;
			}

		});

		char[] original = new char[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < l; j++) {
				original[j * n + i] = codes[i].words[j];
			}
		}

		System.out.println(String.valueOf(original));
	}
}