import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long m;
	static long answer;
	static int[] prime;
	static int target;
	
	static void part(int cnt, int ind, long x) {
		if(cnt==target) {
			if(target%2==0) {
				answer-=m/x;
			}
			else {
				answer+=m/x;
			}
			return;
		}
		if(x>m||ind>=n)
			return;
		else {
			for(int i = ind;i<n;i++) {
				part(cnt+1,i+1,x*prime[i]);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		prime = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			prime[i] = Integer.parseInt(st.nextToken());
		}	
		for(int i = 1;i<=n;i++) {
			target = i;
			part(0,0,1);
		}
		System.out.println(answer);	
	}
}