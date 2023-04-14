import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String eggPlant;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//사진은 1~n번까지 존재
		long n = Long.parseLong(br.readLine());
		
		//가지 이름 알아내기 
		long mid = (n+1)/2;
		System.out.println("? "+mid);
		System.out.flush();
		eggPlant = br.readLine();
		
		long left = mid;
		long s = 1;
		long e = mid;
		long m;
		String res;
		while(s<=e) {
			m = (s+e)/2;
			System.out.println("? "+m);
			System.out.flush();
			res = br.readLine();
			if(eggPlant.equals(res)) {
				left = m;
				e = m-1;
			}
			else {
				s = m+1;
			}
			
		}
		
		long right = mid;

		s = mid;
		e = n;
		while(s<=e) {
			m = (s+e)/2;
			System.out.println("? "+m);
			System.out.flush();
			res = br.readLine();
			if(eggPlant.equals(res)) {
				right = m;
				s = m+1;
			}
			else {
				e = m-1;
			}
			
		}
	
		System.out.println("! "+left+" "+right);
		System.out.flush();
	}
}