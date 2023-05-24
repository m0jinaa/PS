import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] drive;
	static boolean[] used;
	static ArrayList<Integer>[] canDrive;
	static boolean dfs(int x) {
		for(int y : canDrive[x]) {
			if(used[y])
				continue;
			used[y] = true;
			if(drive[y]== 0 || dfs(drive[y])) {
				drive[y] = x;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		int c,x;
		int n,m;
		int cnt;
		for(int t = 1;t<=k;t++) {
			st = new StringTokenizer(br.readLine()," ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			drive = new int[m+1];
			used = new boolean[m+1];
			canDrive = new ArrayList[n+1];
			
			for(int i = 1;i<=n;i++) {
				canDrive[i] = new ArrayList<>();
				st = new StringTokenizer(br.readLine()," ");
				c = Integer.parseInt(st.nextToken());
				while(c-->0) {
					x = Integer.parseInt(st.nextToken());
					canDrive[i].add(x);
				}
			}
			
			cnt = 0;
			
			for(int i = 1;i<=n;i++) {
				Arrays.fill(used, false);
				if(dfs(i)) {
					cnt++;
				}
			}
			
			sb.append("Data Set ").append(t).append(":\n");
			sb.append(cnt).append("\n\n");
			
		}
		
		System.out.print(sb.toString());		
	}
}