import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int[] next;
	static int[] dp;

	static ArrayList<Node>[] canGo;

	static class Node {
		int x, s;

		public Node(int x, int s) {
			super();
			this.x = x;
			this.s = s;
		}

	}

	static int getScore(int x, boolean c) {
		if (x == 1 && c) {
			return 0;
		} else if (dp[x] != -1)
			return dp[x];
		int score = 0;
		int temp;
		for (Node node : canGo[x]) {
			temp = node.s + getScore(node.x, node.x == 1);
			if (temp > score) {
				score = temp;
				next[x] = node.x;
			}
		}

		return dp[x] = score;
	}

	public static void trace() {
		int x = 1;
		sb.append(x).append(" ");
		x = next[x];
		while(x!=1 && x!=0) {
			sb.append(x).append(" ");
			x = next[x];
		}
		if(x!=0) {
			sb.append(x).append("\n");
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		dp = new int[n + 1];
		next = new int[n + 1];
		canGo = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = -1;
			canGo[i] = new ArrayList<>();
		}
		
		int p,q,r;
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			canGo[p].add(new Node(q,r));
		}
		
		int answer = getScore(1,false);
		
		sb.append(answer).append("\n");
		trace();
		
		System.out.print(sb.toString());		
	}
}