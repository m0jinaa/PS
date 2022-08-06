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
		st = new StringTokenizer(br.readLine()," ");
		int[] money = new int[n];
		for(int i = 0;i<n;i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		long answer = 0;
		long sum = 0;
		for(int i = 0;i<n;i++) {
			sum+=money[i];
			if(i>=m) {
				sum-=money[i-m];
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
