import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	static int n,m;
	static List<Integer>[] front,back;
	public static int getFront(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		int ans = 0;
		boolean[] v = new boolean[n+1];
		q.add(x);
		v[x] = true;
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int c:front[now]) {
				if(v[c])
					continue;
				v[c] = true;
				ans++;
				q.add(c);
			}
		}
		return ans;
	}
	public static int getBack(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		int ans = 0;
		boolean[] v = new boolean[n+1];
		q.add(x);
		v[x] = true;
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int c:back[now]) {
				if(v[c])
					continue;
				v[c] = true;
				ans++;
				q.add(c);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t = 1;t<=tc;t++) {
			
			n = Integer.parseInt(br.readLine().trim());
			m = Integer.parseInt(br.readLine().trim());
			
			front = new LinkedList[n+1];
			back = new LinkedList[n+1];
			
			for(int i = 1;i<=n;i++) {
				front[i] = new LinkedList<Integer>();
				back[i] = new LinkedList<Integer>();
			}
			int a, b;
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				back[a].add(b);
				front[b].add(a);
			}
			int answer = 0;
			for(int i = 1;i<=n;i++) {
				if(getFront(i)+getBack(i)==n-1)
					answer++;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}