import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int target;
	static int answer;
	
	public static void combi(int i,int cnt) {
		if(cnt == target) {
			answer++;
			return;
		}
		else {
			for(int j = i;j<n;j++) {
				combi(j,cnt+1);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		target = m-n;

		combi(0,0);
		
		System.out.println(answer);	
	}
}
