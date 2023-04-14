import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] v;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		v = new boolean[n+1];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<=n;i++) {
			graph.add(new ArrayList<Integer>());
		}
		int a,b;
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		v[1] = true;
		int[] parent = new int[n+1];
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int p:graph.get(now)) {
				if(!v[p]) {
					parent[p] = now;
					v[p] = true;
					q.offer(p);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 2;i<=n;i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.print(sb);		
	}
}
