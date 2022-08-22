import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static LinkedList<Integer>[] available;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void init() {
		visited = new boolean[101];
		available = new LinkedList[101];
		for(int i = 0;i<101;i++) {
			available[i] = new LinkedList<Integer>();
		}
		q.clear();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int l,start,p,answer,qsize,a,b;
		for(int t = 1;t<=10;t++) {
			init();
			st = new StringTokenizer(br.readLine()," ");
			l = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<l;i+=2) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				available[a].add(b);
			}
			answer = start;
			q.offer(start);
			visited[start]=true;
			int ans;
			while (!q.isEmpty()) {
				ans = 0;
				qsize = q.size();
				for(int i = 0;i<qsize;i++) {
					p = q.poll();
					ans = ans<p?p:ans;
					for(int next:available[p]) {
						if(!visited[next]) {
							visited[next] = true;
							q.offer(next);
						}
					}
				}
				answer = ans;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
}