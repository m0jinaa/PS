import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		sb.append(1);
		int bef = 1;
		int v = n-1;
		for(int i = 1;i<n;i++){
			if(i%2!=0) {
				sb.append(" ").append(bef+v);
				bef +=v;
			}
			else {
				sb.append(" ").append(bef-v);
				bef-=v;
			}
			v--;
		}
		System.out.println(sb.toString());
	}
}