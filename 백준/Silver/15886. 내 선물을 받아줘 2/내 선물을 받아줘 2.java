import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] map = br.readLine().toCharArray();

		int answer = 0;

		for (int i = 0; i + 1 < n; i++) {
			if (map[i] == 'E' && map[i + 1] == 'W') {
				answer++;
			}
		}

		System.out.println(answer);
	}
}