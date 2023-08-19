import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] type = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			type[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		LinkedList<Integer> q = new LinkedList<>();

		int x;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			if (type[i] == 0)
				q.add(x);
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		while (m-- > 0) {
			x = Integer.parseInt(st.nextToken());
			q.addFirst(x);
			sb.append(q.pollLast()).append(m == 0 ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}