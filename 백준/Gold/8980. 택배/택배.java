import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int sender, receiver, amount;

		public Node(int sender, int receiver, int amount) {
			super();
			this.sender = sender;
			this.receiver = receiver;
			this.amount = amount;
		}

		@Override
		public int compareTo(Node node) {
			return this.receiver == node.receiver ? this.sender - node.sender : this.receiver - node.receiver;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] limit = new int[n + 1];

		Arrays.fill(limit, c);

		ArrayList<Node> list = new ArrayList<>();

		int x, y, size;

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			size = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x, y, size));
		}

		Collections.sort(list);

		int answer = 0;
		
		int amount;
		
		for (Node node : list) {
			amount = node.amount;
			for (int i = node.sender; i < node.receiver; i++) {
				amount = Math.min(amount, limit[i]);
			}

			answer += amount;

			for (int i = node.sender; i < node.receiver; i++) {
				limit[i] -= amount;
			}
		}

		System.out.println(answer);
	}
}