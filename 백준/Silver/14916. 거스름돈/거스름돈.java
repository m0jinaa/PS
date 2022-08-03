import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] money = new int[n+1];
		Arrays.fill(money, n+1);
		money[0] = 0;
		if(n>=2)
			money[2] = 1;
		if(n>=5)
			money[5] = 1;
		for(int i = 3;i<n+1;i++) {
			money[i] = Math.min(money[i-2]+1, money[i]);
			if(i>5) {
				money[i] = Math.min(money[i-5]+1, money[i]);
			}
		}
		if(money[n]>n) {
			System.out.println(-1);
		}
		else
			System.out.println(money[n]);
	}

}
