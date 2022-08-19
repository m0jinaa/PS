import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int answer;
	
	public static void combi(int i,int cnt) {
		if(cnt== m) {
			if(i==n)
				answer++;
			return;
		}
		else {
			for(int j = i;j<=i+1 &&i+1<=n;j++) {
				combi(j,cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		combi(0,0);
		
		System.out.println(answer);	
	}
}
