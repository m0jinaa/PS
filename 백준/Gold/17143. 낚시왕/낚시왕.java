import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark{
	int r;
	int c;
	int s;//속력
	int d;//이동방향
	int z;//크기
	
	public Shark( int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}	
}

public class Main {
	static int R,C;
	static Queue<Shark> shark;
	static Shark[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static boolean inRange(int a, int b) {
		if(a<0||a>=R||b<0||b>=C)
			return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r,c,s,d,z;
		map = new Shark[R][C];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			switch(d) {
			case 1:
				d = 0;
				s%=(R-1)*2;
				break;
			case 2:
				d = 2;
				s%=(R-1)*2;
				break;
			case 3:
				d = 3;
				s%=(C-1)*2;
				break;
			case 4:
				d = 1;
				s%=(C-1)*2;
				break;
			}
			z = Integer.parseInt(st.nextToken());
			
			Shark sk = new Shark(r,c,s,d,z);
			map[r][c] = sk;		
		}
		int answer = 0;
		int nr,nc;
		Shark sk;
		for(int fisher = 0;fisher<C;fisher++) {
			//낚시
			for(int i = 0;i<R;i++) {
				if(map[i][fisher]==null)
					continue;
				answer+=map[i][fisher].z;
				map[i][fisher] = null;
				break;
			}
			
			//상어이동
			shark = new LinkedList<Shark>();
			for(int i = 0;i<R;i++) {
				for(int j = 0;j<C;j++) {
					if(map[i][j]!=null) {
						shark.offer(map[i][j]);
						map[i][j] = null;
					}
				}
			}
			while(!shark.isEmpty()) {
				sk = shark.poll();
				r = sk.r;
				c = sk.c;
				s = sk.s;
				d = sk.d;
				z = sk.z;

				for(int i = 0;i<s;i++) {
					nr = r+dx[d];
					nc = c+dy[d];
					if(!inRange(nr,nc)) {
						nr-=2*dx[d];
						nc-=2*dy[d];
						d = (d+2)%4;
					}
					r = nr;
					c = nc;
				}
				
				Shark sr = new Shark(r,c,s,d,z);
				if(map[r][c]==null)
					map[r][c]= sr;
				else
					map[r][c] = map[r][c].z<sr.z?sr:map[r][c];
			}
		}
		System.out.println(answer);
	}
}