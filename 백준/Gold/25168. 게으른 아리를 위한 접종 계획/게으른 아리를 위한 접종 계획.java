import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] inBound = new int[n+1];
		ArrayList<int[]>[] graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			inBound[b]++;
			graph[a].add(new int[] {b,c});
		}
		//System.out.println(Arrays.toString(inBound));
		int[] time = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1;i<=n;i++) {
			if(inBound[i] == 0) {
				q.add(i);
				time[i] = 1;
			}
		}
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int[] next:graph[now]) {
				if(--inBound[next[0]]==0)
					q.add(next[0]);
				time[next[0]] = Math.max(time[next[0]],time[now]+next[1]+(next[1]>=7?1:0));
			}
			
		}
		//System.out.println(Arrays.toString(inBound));
		//System.out.println(Arrays.toString(time));
		int answer = 0;
		for(int i = 1;i<=n;i++) {
			answer = answer<time[i]?time[i]:answer;
		}
		System.out.println(answer);
	}
}
