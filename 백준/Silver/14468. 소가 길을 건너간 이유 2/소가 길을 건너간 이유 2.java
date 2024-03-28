import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] row = br.readLine().toCharArray();

		int[] index = new int[26];

		Arrays.fill(index, -1);

		int ind;

		int cnt = 0;

		for (int i = 0; i < 52; i++) {
			ind = row[i] - 'A';

			if (index[ind] != -1) {
				for (int j = 0; j < 26; j++) {
					if (index[j] > index[ind]) {
						cnt++;
					}
				}
				index[ind] = -1;
			} else {
				index[ind] = i;
			}
		}

		System.out.println(cnt);
	}
}