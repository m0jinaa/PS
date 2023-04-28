import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	static int[] order;
	static HashSet<Integer>[] graph;
	static int n;
	static boolean check(int x) {
		int y;
		
		int ind = 1;
		Stack<Integer> v = new Stack<>();
		int now = x;
		v.add(now);
		boolean answer = true;
		while(ind<n) {
			y = order[ind];
			if(graph[now].isEmpty()) {
				if(!v.isEmpty()) {
					now = v.pop();
				}
				else {
					answer = false;
					break;
				}
			}
			else if(graph[now].contains(y)) {
				graph[now].remove(y);
				graph[y].remove(now);
				v.add(now);
				now = y;
				ind++;
			}
			else {
				answer = false;
				break;
			}
		}
		
		return answer;
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		graph = new HashSet[n+1];
		
		for(int i = 1;i<=n;i++) {
			graph[i] = new HashSet<Integer>();
		}
		
		int a,b;
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		order = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		if(order[0]!=1) {
			System.out.println(0);
		}
		else if(check(1)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}