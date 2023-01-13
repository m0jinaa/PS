import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int target = 123456789;
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0 || a>=3 || b<0 || b>=3)
			return false;
		return true;
	}
	
	static int swap(String s, int i, int j) {
		String ns="";
		if(i<j) {
			ns = (i>0?s.substring(0,i):"")
					+s.charAt(j)
					+s.substring(i+1,j)
					+s.charAt(i)
					+(j+1<s.length()?s.substring(j+1):"");
		}
		else {
			ns = (j>0?s.substring(0,j):"")
					+s.charAt(i)
					+s.substring(j+1,i)
					+s.charAt(j)
					+(i+1<s.length()?s.substring(i+1):"");
			
		}
		return Integer.parseInt(ns);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 0;
		int[][] board = new int[3][3];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0;i<3;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<3;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) {
					board[i][j] = 9;
				}
				n = n*10+board[i][j];
			}
		}
		q.add(n);
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(n,0);
		
		int now;
		int ans=-1;
		String str;
		int ind,x,y,nx,ny;
		
		while(!q.isEmpty()) {
			now = q.poll();
			if(now==target) {
				ans = map.get(now);
				break;
			}
			str = ""+now;
			ind = str.indexOf("9");
			x = ind/3;
			y = ind%3;
			for(int i = 0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(!inRange(nx,ny))
					continue;
				int next = swap(str,3*x+y,3*nx+ny);
				if(map.containsKey(next))
					continue;
				map.put(next, map.get(now)+1);
				q.add(next);
				
			}
		}
		
		System.out.println(ans);		
	}
}