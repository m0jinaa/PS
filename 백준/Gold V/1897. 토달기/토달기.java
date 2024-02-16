import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static String[] words;

	static boolean check(String a, String b) {
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();

		int i = 0;
		int j = 0;

		int n = A.length;
		int m = B.length;

		int cnt = 0;

		while (i < n && j < m) {
			if (A[i] == B[j]) {
				i++;
				j++;
			} else {
				j++;
				cnt++;
			}
		}

		if (j != m) {
			cnt += m - j;
		}

		return cnt == 1;
	}

	static String bfs(String start) {

		HashSet<String> set = new HashSet<>();
		LinkedList<String> q = new LinkedList<>();

		set.add(start);
		q.add(start);

		String answer = start;

		String now;

		while (!q.isEmpty()) {
			now = q.poll();

			answer = now;

			for (String w : words) {
				if (set.contains(w) || now.length() != w.length() - 1 || !check(now, w))
					continue;

				set.add(w);
				q.add(w);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		String start = st.nextToken();

		words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = br.readLine().trim();
		}

		String answer = bfs(start);

		System.out.println(answer);
	}
}