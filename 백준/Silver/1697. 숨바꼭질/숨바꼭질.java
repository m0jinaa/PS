import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		int answer = 0;
		int[] map = new int[100001];
		Arrays.fill(map, -1);
		int now,c;
		map[n] = 0;
		while(!q.isEmpty()) {
			now = q.poll();
			c = map[now];
			if(now==k) {
				answer = c;
				break;
			}	
			if(now>0 &&map[now-1]==-1) {
				q.offer(now-1);
				map[now-1] = c+1;
			}
			if(now<100000 &&map[now+1]==-1) {
				q.offer(now+1);
				map[now+1] = c+1;
			}
			if(now<=50000 &&map[now*2] == -1) {
				q.offer(now*2);
				map[now*2] = c+1;
			}
		}
		System.out.println(answer);
	}
}
