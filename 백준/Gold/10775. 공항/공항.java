import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] gate;
	public static int find(int x) {
		if(gate[x]!=x)
			gate[x] = find(gate[x]);
		return gate[x];
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			gate[a]= b;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] planes = new int[P];
		
		gate = new int[G+1];
		for(int i = 1;i<=G;i++)
			gate[i] = i;
		
		for(int i = 0;i<P;i++) {
			planes[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for(int p:planes) {
			int v = find(p);
			if(v==0){
  				break;              
            }
			answer++;
			union(v,v-1);
		}	
		System.out.println(answer);
	}

}
