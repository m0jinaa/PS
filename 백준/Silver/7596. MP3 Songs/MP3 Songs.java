import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n;

		String[] songs;

		int t = 0;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			t++;

			songs = new String[n];

			for (int i = 0; i < n; i++) {
				songs[i] = br.readLine();
			}

			Arrays.sort(songs);

			sb.append(t).append("\n");

			for (String title : songs) {
				sb.append(title).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}