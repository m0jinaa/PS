import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] student = new int[n];

		for (int i = 0; i < n; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(student);

		int answer = 0;

		int now = 1;

		for (int s : student) {
			if (now <= s) {
				now++;
				answer++;
			}
		}

		System.out.println(answer);
	}
}