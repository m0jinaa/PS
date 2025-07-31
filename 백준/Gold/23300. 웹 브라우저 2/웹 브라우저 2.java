import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		LinkedList<Integer> forward = new LinkedList<>();
		LinkedList<Integer> backward = new LinkedList<>();
		LinkedList<Integer> compress;

		int now = -1;

		String o;
		int p, bef;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = st.nextToken();

			if ("B".equals(o)) {
				if (!backward.isEmpty()) {
					forward.addFirst(now);
					now = backward.pollLast();
				}
			} else if ("F".equals(o)) {
				if (!forward.isEmpty()) {
					backward.addLast(now);
					now = forward.pollFirst();
				}
			} else if ("A".equals(o)) {

				p = Integer.parseInt(st.nextToken());

				if (now != -1) {
					forward.clear();
					backward.addLast(now);
				}

				now = p;
			} else if ("C".equals(o)) {
				compress = new LinkedList<>();
				bef = -1;

				while (!backward.isEmpty()) {
					p = backward.pollFirst();

					if (bef != p) {
						compress.addLast(p);
						bef = p;
					}
				}

				backward = compress;
			}
		}

		sb.append(now).append("\n");

		if (backward.isEmpty()) {
			sb.append("-1\n");
		} else {
			while (!backward.isEmpty()) {
				sb.append(backward.pollLast()).append(" ");
			}
			sb.append("\n");
		}

		if (forward.isEmpty()) {
			sb.append("-1\n");
		} else {
			while (!forward.isEmpty()) {
				sb.append(forward.pollFirst()).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}