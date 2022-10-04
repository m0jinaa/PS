import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
	static int[][] board;
	static ArrayList<int[]>blank = new ArrayList<int[]>();
	static int n = 9;
	static StringBuilder sb = new StringBuilder();
	static boolean fill(int ind) {
		if(ind==blank.size()) {
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			return true;
			
		}
		int[] now = blank.get(ind);
		int x = now[0];
		int y = now[1];
		
		boolean[] used = new boolean[10];
		//horizontal
		for(int i = 0;i<n;i++) {
			if(board[i][y]!=0) {
				used[board[i][y]]=true;
			}
		}
		//vertical
		for(int i = 0;i<n;i++) {
			if(board[x][i]!=0) {
				used[board[x][i]]=true;
			}
		}
		//square
		int a = x/3*3;
		int b = y/3*3;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(board[a+i][b+j]!=0) {
					used[board[a+i][b+j]]=true;
				}				
			}
		}
		for(int i = 1;i<=9;i++) {
			if(!used[i]) {
				board[x][y] = i;
				if(fill(ind+1)) {
					return true;
				}
				board[x][y] = 0;
			}
		}
		return false;
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		board = new int[n][n];
		for(int i = 0;i<n;i++) {
			s = br.readLine();
			for(int j = 0;j<n;j++) {
				board[i][j] = s.charAt(j)-'0';
				if(board[i][j]==0)
					blank.add(new int[] {i,j});
			}
		}
		fill(0);
		
		System.out.println(sb.toString());		
	}
}