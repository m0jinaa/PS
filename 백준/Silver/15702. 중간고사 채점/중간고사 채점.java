import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] score = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}

		int max_id = 0;
		int max_score = -1;

		int s;
		int id;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			id = Integer.parseInt(st.nextToken());
			s = 0;
			for (int j = 0; j < n; j++) {
				s += "O".endsWith(st.nextToken()) ? score[j] : 0;
			}

			if (s > max_score) {
				max_score = s;
				max_id = id;
			} else if (s == max_score) {
				max_id = Math.min(max_id, id);
			}
		}

		System.out.println(max_id + " " + max_score);

	}

}
