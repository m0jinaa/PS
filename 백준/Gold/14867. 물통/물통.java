import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] emptyA, fullA, emptyB, fullB;

    static class Node{
        int x,y,c;

        public Node(int x, int y, int c) {
            super();
            this.x = x;
            this.y = y;
            this.c = c;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        emptyA = new int[b+1];
        fullA = new int[b+1];
        emptyB = new int[a+1];
        fullB = new int[a+1];

        Arrays.fill(emptyA, -1);
        Arrays.fill(fullA, -1);
        Arrays.fill(emptyB, -1);
        Arrays.fill(fullB, -1);
        emptyA[0] = emptyB[0] = 0;

        int answer = -1;

        LinkedList<Node> q = new LinkedList<>();

        q.add(new Node(0,0,0));
        int x,y,nx,ny;
        Node now;
        while(!q.isEmpty()) {
            now = q.poll();
            x = now.x;
            y = now.y;

            if(x==c && y==d) {
                answer = now.c;
                break;
            }

            //A 채워넣기
            nx = a;
            ny = y;
            if(fullA[ny]==-1) {
                fullA[ny] = now.c+1;
                q.add(new Node(nx,ny,now.c+1));
            }

            //A 비우기
            nx = 0;
            ny = y;
            if(emptyA[ny]==-1) {
                emptyA[ny] = now.c+1;
                q.add(new Node(nx,ny,now.c+1));
            }

            //B로 옮기기
            nx = (x+y<=b)?0:(x+y-b);
            ny = (x+y<=b)?(x+y):b;

            if(ny==b) {
                if(nx==0 && emptyA[ny]==-1) {
                    emptyA[ny] = now.c+1;
                    q.add(new Node(nx,ny,now.c+1));
                }
                if(fullB[nx]==-1) {
                    fullB[nx] = now.c+1;
                    q.add(new Node(nx,ny,now.c+1));
                }
            }
            else if(emptyA[ny]==-1){ //x==0
                emptyA[ny] = now.c+1;
                q.add(new Node(nx,ny,now.c+1));
            }

            //B 채워넣기
            nx = x;
            ny = b;
            if(fullB[nx]==-1) {
                fullB[nx] = now.c+1;
                q.add(new Node(nx,ny,now.c+1));
            }

            //B 비우기
            nx = x;
            ny = 0;
            if(emptyB[nx]==-1) {
                emptyB[nx] = now.c+1;
                q.add(new Node(nx,ny,now.c+1));
            }

            //A로 옮기기
            nx = (x+y<=a)?(x+y):a;
            ny = (x+y<=a)?0:(x+y-a);

            if(nx==a) {
                if(ny==0 && emptyB[nx]==-1) {
                    emptyB[nx] = now.c+1;
                    q.add(new Node(nx,ny,now.c+1));
                }
                if(fullA[ny]==-1) {
                    fullA[ny] = now.c+1;
                    q.add(new Node(nx,ny,now.c+1));
                }
            }
            else if(emptyB[nx]==-1){ //x==0
                emptyB[nx] = now.c+1;
                q.add(new Node(nx,ny,now.c+1));
            }
        }
        System.out.println(answer);
    }
}