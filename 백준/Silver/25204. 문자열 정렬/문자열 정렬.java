import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int n;
		String[] words;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			words = new String[n];

			for (int i = 0; i < n; i++) {
				words[i] = br.readLine();
			}

			Arrays.sort(words, new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					char[] w1 = s1.toCharArray();
					char[] w2 = s2.toCharArray();
					int l1 = w1.length;
					int l2 = w2.length;

					int ind = 0;
					char a, b;

					while (ind < l1 && ind < l2) {
						if (w1[ind] == w2[ind])
							ind++;
						else {
							if (w1[ind] == '-')
								return 1;
							else if (w2[ind] == '-')
								return -1;
							a = Character.toLowerCase(w1[ind]);
							b = Character.toLowerCase(w2[ind]);

							if (a != b)
								return a - b;
							else
								return w1[ind] - w2[ind];
						}
					}

					return s1.compareTo(s2);
				}

			});

			for (String w : words) {
				sb.append(w).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}