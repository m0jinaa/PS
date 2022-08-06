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
		int[] place = new int[1000001];//0~1000000까지 있음

		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			place[x] = g;
		}
		int amount = 0;
		int len = 2*k+1;
		long answer = amount;
		for(int i = 0;i<1000001;i++) {
			if(i>=len)
				amount-=place[i-len];
			amount+=place[i];
			if(amount>answer)
				answer = amount;
			
		}
		System.out.println(answer);
	}

}
