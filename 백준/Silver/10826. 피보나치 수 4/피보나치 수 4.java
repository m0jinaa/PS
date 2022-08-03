import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] fibo = new BigInteger[n+1];
		fibo[0] =BigInteger.ZERO;
		if(n>=1) {
			fibo[1] = BigInteger.ONE;
			for(int i = 2;i<=n;i++) {
				fibo[i] = fibo[i-1].add(fibo[i-2]);
			}
			
		}
		System.out.println(fibo[n].toString());
	}

}
