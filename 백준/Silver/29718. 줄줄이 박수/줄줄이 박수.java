import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] col = new int[m+1];
		int[] sum = new int[m+1];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j = 1;j<=m;j++) {
				col[j]+=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1;i<=m;i++) {
			sum[i] = sum[i-1]+col[i];
		}
		
		int a = Integer.parseInt(br.readLine());
		
		int max = 0;
		
		for(int i = 1;i+a-1<=m;i++) {
			max = Math.max(max, sum[i+a-1]-sum[i-1]);
		}
		
		System.out.println(max);		
	}
}