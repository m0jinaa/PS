import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int c,l;
	static char[] chr;
	static boolean[] check;
	public static void combi(int ind, int cnt, int v,int vc,int cc) {
		if(cnt==l) {
			if(vc<1||cc<2)
				return;
			for(int i = 0;i<c;i++) {
				if((v&(1<<i))==(1<<i))
					sb.append(chr[i]);
			}
			sb.append("\n");
		}
		else {
			for(int j = ind;j<c;j++) {
				if(check[j])
					combi(j+1,cnt+1,v|1<<j,vc+1,cc);
				else
					combi(j+1,cnt+1,v|1<<j,vc,cc+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		chr = new char[c];
		String s = br.readLine();
		int len = s.length();
		for(int i = 0,ind = 0;i<len;i+=2,ind++) {
			chr[ind] = s.charAt(i);
		}
		Arrays.sort(chr);
		check = new boolean[c];
		for(int i = 0;i<c;i++) {
			if(chr[i]=='a'||chr[i]=='e'||chr[i]=='i'||chr[i]=='o'||chr[i]=='u')
				check[i] = true;
		}
		combi(0,0,0,0,0);
		System.out.print(sb);
	}
}