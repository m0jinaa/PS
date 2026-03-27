import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer> q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());

			if (!q.isEmpty() && ((x + q.peekLast()) % 2) == 0) {
				q.pollLast();
			} else {
				q.add(x);
			}
		}

		int answer = q.size();

		System.out.println(answer);
	}
}