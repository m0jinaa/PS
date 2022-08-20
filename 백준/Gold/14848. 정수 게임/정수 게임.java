import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long n;
	static int k;
	static long answer;
	static long[] numbers;
	static int target;
	
	public static long gcd(long a, long b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
	public static long lcm(long a, long b) {

		return a*b/gcd(a,b);
	}
	public static void game(int ind, int cnt, long x) {
		if(cnt==target) {
			if(target%2==0)
				answer+=n/x;
			else
				answer-=n/x;
			return;
		}
		
		if(x>n||ind>=k)
			return;
		else {
			for(int i = ind;i<k;i++) {
				game(i+1,cnt+1,lcm(x,numbers[i]));
			}
		}	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		answer = n;
		k = Integer.parseInt(st.nextToken());
		numbers = new long[k];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<k;i++) {
			numbers[i] = Long.parseLong(st.nextToken());
		}	
		for(int i = 1;i<=k;i++) {
			target = i;
			game(0,0,1);
		}		
		System.out.println(answer);
	}
}