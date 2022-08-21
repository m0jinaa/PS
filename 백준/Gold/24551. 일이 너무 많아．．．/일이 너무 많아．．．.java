import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static BigInteger answer;
	static int target;
	static BigInteger n;
	static BigInteger[] ones = {BigInteger.valueOf(11),
								BigInteger.valueOf(111),
								BigInteger.valueOf(11111),
								BigInteger.valueOf(1111111),
								BigInteger.valueOf(11111111111L),
								BigInteger.valueOf(1111111111111L),
								BigInteger.valueOf(11111111111111111L)
								};
	
	static BigInteger lcm(BigInteger a,BigInteger b) {
		return a.multiply(b).divide(a.gcd(b));
	}
	
	static void combi(int ind, int cnt, BigInteger now) {
		if(cnt==target) {
			if(target%2==0) {
				answer = answer.subtract(n.divide(now));				
			}
			else
				answer = answer.add(n.divide(now));
			return;
		}
		if(now.compareTo(n)==1||ind>=7)
			return;
		else {
			for(int j = ind;j<7;j++) {
				combi(j+1,cnt+1,lcm(now,ones[j]));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = new BigInteger(br.readLine());
		answer = BigInteger.ZERO;
		for(target = 1;target<=7;target++) {
			combi(0,0,BigInteger.ONE);
		}		
		System.out.println(answer.toString());
	}
}
