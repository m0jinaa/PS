import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] boss = new int[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1;i<=n;i++) {
			boss[i] = Integer.parseInt(st.nextToken());
		}
		int[] compliments = new int[n+1];
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int employee = Integer.parseInt(st.nextToken());
			int amount = Integer.parseInt(st.nextToken());
			compliments[employee]+=amount;
		}
		for(int i = 2;i<=n;i++) {
			compliments[i] +=compliments[boss[i]];
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=n;i++) {
			sb.append(compliments[i]).append(" ");
		}
		System.out.println(sb);
	}
}
