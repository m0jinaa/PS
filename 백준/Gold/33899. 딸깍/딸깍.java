import java.util.*;
import java.io.*;

public class Main {
    static int n,m;

    static int[][] inDirectConnect = new int[][]{{-1,0,3},{0,1,5},{0,1,4},{1,0,0},{0,-1,2},{0,-1,1},{0,0,6}};
    static boolean[][][] v;
    static int[][][] data;
    static LinkedList<Segment> q;

    static boolean inRange(int x, int y){
        return !(x<0 || x>=n || y<0 || y>=m);
    }
    static class Segment{
        int x,y,d;

        public Segment(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    static void turnOn(int x, int y, int d){
        v[x][y][d] = true;

        q.add(new Segment(x,y,d));

        Segment now;
        int nx,ny,nd;
        
        while(!q.isEmpty()){
            now = q.poll();

            //shareConnect
            for(int i = 0;i<7;i++){
                if(data[now.x][now.y][i] == 0 || v[now.x][now.y][i]){
                    continue;
                }
                v[now.x][now.y][i] = true;
                q.add(new Segment(now.x, now.y, i));
            }

            //inDirectConnect
            nx = now.x+inDirectConnect[now.d][0];
            ny = now.y+inDirectConnect[now.d][1];
            nd = inDirectConnect[now.d][2];

            if(!inRange(nx,ny) || data[nx][ny][nd] == 0 || v[nx][ny][nd]){
                continue;
            }
            v[nx][ny][nd] = true;
            q.add(new Segment(nx,ny,nd));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] numbers = new int[][]{{1,1,1,1,1,1,0},
                                         {0,1,1,0,0,0,0},
                                         {1,1,0,1,1,0,1},
                                         {1,1,1,1,0,0,1},
                                         {0,1,1,0,0,1,1},
                                         {1,0,1,1,0,1,1},
                                         {1,0,1,1,1,1,1},
                                         {1,1,1,0,0,1,0},
                                         {1,1,1,1,1,1,1},
                                         {1,1,1,1,0,1,1}};
        

        st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());    
        m = Integer.parseInt(st.nextToken());    
    
        data = new int[n][m][];

        char[] row;
        int d;
        
        for(int i = 0;i<n;i++){
            row = br.readLine().toCharArray();
            
            for(int j = 0;j<m;j++){
                d = row[j]-'0';

                data[i][j] = numbers[d];
            }
        }

        v = new boolean[n][m][7];
        q = new LinkedList<>();
        
        int c = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int k = 0;k<7;k++){
                    if(data[i][j][k] == 1 && !v[i][j][k]){
                        c++;
                        turnOn(i,j,k);
                    }
                }
            }
        }

        System.out.println(c == 1?"YES":"NO");
    }
}