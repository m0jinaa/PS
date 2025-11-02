import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] original = br.readLine().toCharArray();
		char[] input = br.readLine().toCharArray();

		int i = 0;
		int j = 0;

		int n = original.length;
		int m = input.length;

		Set<Character> sticky = new HashSet<>();

		while (j < m) {
			if (i < n && original[i] == input[j]) {
				i++;
			} else if (!sticky.contains(input[j])) {
				sticky.add(input[j]);
				sb.append(input[j]);
			}

			j++;
		}

		System.out.println(sb.toString());
	}
}