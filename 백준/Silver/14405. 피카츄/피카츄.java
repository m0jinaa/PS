import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray();

		int n = S.length;

		boolean possible = true;

		for (int i = 0; i < n;) {
			if (S[i] == 'p') {
				if (i + 1 < n && S[i + 1] == 'i') {
					i += 2;
				} else {
					possible = false;
					break;
				}
			} else if (S[i] == 'k') {
				if (i + 1 < n && S[i + 1] == 'a') {
					i += 2;
				} else {
					possible = false;
					break;
				}
			} else if (S[i] == 'c') {
				if (i + 2 < n && S[i + 1] == 'h' && S[i + 2] == 'u') {
					i += 3;
				} else {
					possible = false;
					break;
				}
			} else {
				possible = false;
				break;
			}
		}

		System.out.println(possible ? "YES" : "NO");
	}
}