import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] confetti = new int[]{0,5,5,5,5,5};
	static int n = 10;
	static int[][] map;
	static int answer;
	
	static boolean check(int a, int b, int l) {
		int al = a+l;
		int bl = b+l;
		for(int i = a; i<al;i++) {
			for(int j = b;j<bl;j++) {
				if(map[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	static void changeState(int a, int b, int l,int s) {
		int al = a+l;
		int bl = b+l;
		for(int i = a; i<al;i++) {
			for(int j = b;j<bl;j++) {
				map[i][j] = s;
			}
		}
	}
	
	static boolean inRange(int a, int b) {
		if(a<n&&b<n)
			return true;
		return false;
	}
	static void getMinCount(int a, int b, int c) {
		if(a==n) {
			answer = answer>c?c:answer;
			return;
		}
		if(b==n)
			getMinCount(a+1,0,c);
		else if(map[a][b]==0)
			getMinCount(a,b+1,c);
		else {
			for(int l = 5;l>0;l--) {
				if(confetti[l]<1||!inRange(a+l-1,b+l-1)||!check(a,b,l))
					continue;
				changeState(a,b,l,0);
				confetti[l]--;
				getMinCount(a,b+1,c+1);
				confetti[l]++;
				changeState(a,b,l,1);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[n][n];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}	
		answer = Integer.MAX_VALUE;
		
		getMinCount(0,0,0);
		
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);	
	}
}