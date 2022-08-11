import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int[][] price;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		price = new int[n][n];
		
		for(int i = 0;i<n;i++) {
			char[] carr = br.readLine().toCharArray();
			for(int j = 0;j<n;j++) {
				price[i][j] = carr[j]-'0';
				
			}
		}
		
		int h = (int)Math.pow(2, n);
		dp = new int[h][n];
		for(int i = 0;i<h;i++) {
			Arrays.fill(dp[i],10);
		}
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {1,0,1,0});//가지고있던사람들 비트마스킹, 현재 가지고 있는 사람, 거쳐간 사람수, 가격
		int d, p, cnt, money,c;
		int answer = 1;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			d = now[0];
			p = now[1];
			cnt = now[2];
			money = now[3];
			c = 0;
			for(int i = 0, v = 1;i<n;i++,v*=2) {
				if((v&d)==0&&price[p][i]>=money&&price[p][i]<dp[v|d][i]) {
					q.offer(new int[] {v|d,i,cnt+1,price[p][i]});
					dp[v|d][i] = price[p][i];
				}
				else
					c++;
			}
			if(c==n) {
				answer = Math.max(answer, cnt);
			}		
		}
		System.out.println(answer);
	}
}
