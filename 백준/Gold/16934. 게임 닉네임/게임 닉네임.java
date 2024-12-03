import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static class Node {
		Node[] next;
		boolean end;
		int cnt;

		public Node() {
			super();
			next = new Node[26];
			end = false;
			cnt = 0;
		}
	}

	static Node head;

	public static String enroll(char[] name) {
		Node now = head;

		int n = name.length;
		boolean finished = false;
		String nickname = "";

		for (int i = 0; i < n; i++) {
			if (!finished)
				nickname += name[i];

			if (now.next[name[i] - 'a'] == null) {
				finished = true;
				now.next[name[i] - 'a'] = new Node();
			}
			now = now.next[name[i] - 'a'];
		}

		now.cnt += 1;

		if (!finished && now.end) {
			nickname += now.cnt;
		}
		now.end = true;

		return nickname;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		char[] name;

		head = new Node();

		while (n-- > 0) {
			name = br.readLine().toCharArray();

			sb.append(enroll(name)).append("\n");
		}

		System.out.println(sb.toString());
	}
}