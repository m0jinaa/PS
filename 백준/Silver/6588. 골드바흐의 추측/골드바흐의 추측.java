import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] primes = new boolean[1000001];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		
		ArrayList<Integer> prime = new ArrayList<Integer>();
		
		for(int i = 2;i<1000001;i++) {
			if(primes[i]) {
				prime.add(i);
				for(int j = i*2;j<1000001;j+=i) {
					primes[j] = false;
				}
			}
		}
		
		int n;
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			for(int p:prime) {
				if(p>n/2) {
					sb.append("Goldbach's conjecture is wrong.\n");
					break;
				}
				
				if(primes[n-p]) {
					sb.append(n+" = "+p+" + "+(n-p)+"\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());

	}

}
