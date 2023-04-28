import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] order,target;
	static ArrayList<Integer>[] graph;
	static int ind = 0;
	static boolean[] v;
	static boolean dfs(int x) {
		if(target[ind++]!=x)
			return false;
		
		for(int y: graph[x]) {
			if(v[y])
				continue;
			v[y] = true;
			return dfs(y);
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		int a,b;
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		order = new int[n+1];
		target = new int[n];
		v = new boolean[n+1];
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			target[i] = Integer.parseInt(st.nextToken());
			order[target[i]] = i;
		}
		for(int i = 1;i<=n;i++)
			Collections.sort(graph[i],new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return order[o1]-order[o2];
				}});
		
		v[1] = true;
		
		System.out.println(dfs(1)?1:0);
	}
}