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
		LinkedList<Integer> q = new LinkedList<>();

		int o, x;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				q.offerFirst(x);
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				q.offerLast(x);
				break;
			case 3:
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.pollFirst()).append("\n");
				}
				break;
			case 4:
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.pollLast()).append("\n");
				}
				break;
			case 5:
				sb.append(q.size()).append("\n");
				break;
			case 6:
				sb.append(q.isEmpty() ? "1" : "0").append("\n");
				break;
			case 7:
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekFirst()).append("\n");
				}
				break;
			case 8:
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.print(sb.toString());
	}
}