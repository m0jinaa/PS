import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static int[] dp;
	static int k;
	static char[] word;
	static HashSet<String> set;

	static int count(int x) {
		if (dp[x] != -1) {
			return dp[x];
		}

		int cnt = 0;

		if (set.contains(word[x] + ""))
			cnt += count(x + 1);

		if (x + 1 < k && set.contains("" + word[x] + word[x + 1]))
			cnt += count(x + 2);

		return dp[x] = (cnt > 0) ? 1 : 0;
	}

	public static void init() {
		String[] words = new String[] { "h", "b", "c", "n", "o", "f", "p", "s", "k", "v", "y", "i", "w", "u", "ba",
				"ca", "ga", "la", "na", "pa", "ra", "ta", "db", "nb", "pb", "rb", "sb", "tb", "yb", "ac", "sc", "tc",
				"cd", "gd", "md", "nd", "pd", "be", "ce", "fe", "ge", "he", "ne", "re", "se", "te", "xe", "cf", "hf",
				"rf", "ag", "hg", "mg", "rg", "sg", "bh", "rh", "th", "bi", "li", "ni", "si", "ti", "bk", "al", "cl",
				"fl", "tl", "am", "cm", "fm", "pm", "sm", "tm", "cn", "in", "mn", "rn", "sn", "zn", "co", "ho", "mo",
				"no", "po", "np", "ar", "br", "cr", "er", "fr", "ir", "kr", "lr", "pr", "sr", "zr", "as", "cs", "ds",
				"es", "hs", "os", "at", "mt", "pt", "au", "cu", "eu", "lu", "pu", "ru", "lv", "dy" };

		set.addAll(Arrays.asList(words));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		set = new HashSet<>();

		init();

		while (n-- > 0) {
			word = br.readLine().toCharArray();

			k = word.length;
			dp = new int[k + 1];
			Arrays.fill(dp, -1);
			dp[k] = 1;
			sb.append(count(0) > 0 ? "YES\n" : "NO\n");
		}

		System.out.print(sb.toString());
	}
}