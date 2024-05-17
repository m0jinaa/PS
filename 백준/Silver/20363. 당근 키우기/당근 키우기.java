import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());

		long answer = x + y + Math.min(x, y) / 10;

		System.out.println(answer);
	}
}