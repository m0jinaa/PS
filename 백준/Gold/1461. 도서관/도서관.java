import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>minus = new ArrayList<Integer>();
		ArrayList<Integer>plus = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num<0)
				minus.add(num);
			else
				plus.add(num);
		}
		minus.sort((n1,n2)->n1-n2);
		plus.sort((n1,n2)->n2-n1);
		
		int max = 0;
		int v;
		int answer = 0;
		for(int i = 0;i<minus.size();i+=m) {
			v = Math.abs(minus.get(i));
			answer+=v*2;
			max = max<v?v:max;
		}
		for(int i = 0;i<plus.size();i+=m) {
			v = Math.abs(plus.get(i));
			answer+=v*2;
			max = max<v?v:max;
		}	
		answer-=max;
		System.out.println(answer);		
	}
}