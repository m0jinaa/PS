import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;

	static String swap(String str, int ind) {

		String ret = str.substring(0, ind);
		for (int i = ind + k - 1; i >= ind; i--)
			ret += str.charAt(i);
		ret += str.substring(ind + k);

		return ret;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();

		LinkedList<String> q = new LinkedList<>();

		String original = br.readLine().replaceAll(" ", "");
		String target = "";

		for (int i = 1; i <= n; i++) {
			target += i;
		}

		q.add(original);

		set.add(original);
		int qsize, t = 0;
		String now, next;

		int answer = -1;

		end: while (!q.isEmpty()) {

			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();
				if (target.equals(now)) {
					answer = t;
					break end;
				}
				for (int i = 0; i <= n - k; i++) {
					next = swap(now, i);
					if (set.contains(next))
						continue;
					set.add(next);
					q.add(next);
				}
			}
			t++;
		}

		System.out.println(answer);
	}
}