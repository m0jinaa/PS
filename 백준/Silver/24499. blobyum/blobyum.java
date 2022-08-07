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
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int[] pie = new int[n+k-1];
		for(int i = 0;i<n;i++) {
			pie[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0;i<k-1;i++) {
			pie[i+n] = pie[i];
		}
		int pl = pie.length;
		int answer = 0;
		int sum = 0;
		for(int i = 0;i<pl;i++) {
			sum+=pie[i];
			if(i>=k)
				sum-=pie[i-k];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
