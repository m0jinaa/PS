import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] day = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<n;i++) {
			day[i] = Integer.parseInt(st.nextToken());
		}
		
		int amount = 0;
		for(int i = 0;i<x;i++) {
			amount+=day[i];
		}
		int cnt = 1;
		int answer = amount;
		for(int i = x;i<n;i++) {
			amount-=day[i-x];
			amount+=day[i];
			if(amount>answer) {
				answer = amount;
				cnt = 1;
			}
			else if(amount==answer) {
				cnt++;
			}
		}
		if(answer == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(answer);
			System.out.println(cnt);			
		}
	}

}
