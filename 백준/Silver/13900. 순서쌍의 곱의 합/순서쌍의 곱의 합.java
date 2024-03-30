import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long answer = 0;

		long sum = 0;

		st = new StringTokenizer(br.readLine(), " ");

		int x;
        
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			answer += x * sum;
			sum += x;
		}

		System.out.println(answer);
	}
}