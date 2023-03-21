import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] finished;
    static ArrayList<Integer>[] graph;
    static Stack<Integer> stack;
    static int ind = 1;
    static int cnt = 1;

    static int SCC(int x) {
        parent[x] = ind++;
        stack.add(x);
        int p = parent[x];

        for (int i : graph[x]) {
            if (parent[i] == 0) {
                p = Math.min(p, SCC(i));
            } else if (finished[i] == 0) {
                p = Math.min(p, parent[i]);
            }
        }
        int now;
        if (p == parent[x]) {
            while ((now = stack.peek()) != x) {
                finished[now] = cnt;
                stack.pop();
            }
            finished[now] = cnt;
            stack.pop();
            cnt++;
        }

        return p;
    }

    static int getOpposite(int x) {
        if (x % 2 == 0)
            return x + 1;
        else
            return x - 1;
    }

    static int getInd(int x) {
        if (x < 0)
            return -2 * (x + 1);
        else
            return 2 * x - 1;

    }

    static class Node implements Comparable<Node> {
        int o, x;

        public Node(int o, int x) {
            super();
            this.o = o;
            this.x = x;
        }

        @Override
        public int compareTo(Node node) {
            if (this.o != node.o)
                return this.o - node.o;
            else
                return this.x - node.x;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        StringTokenizer st;
        
        int m,n,x,y,answer;
        
        stack = new Stack<Integer>();
        parent = new int[40000];
        finished = new int[40000];
        graph = new ArrayList[40000];
        for(int i = 0;i<40000;i++) {
        	graph[i] = new ArrayList<Integer>();
        }
        while(true) {
        	
        	st = new StringTokenizer(br.readLine()," ");
        	
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	
        	if(m==0 && n==0)
        		break;
        	Arrays.fill(parent, 0);
        	Arrays.fill(finished, 0);
        	stack.clear();
        	for(int i = 0;i<40000;i++) {
        		graph[i].clear();
        	}
        	
        	cnt = 1;
        	ind = 1;
        	
        	
        	
        	for(int i = 0;i<n;i++) {
        		st = new StringTokenizer(br.readLine()," ");
        		x = Integer.parseInt(st.nextToken());
        		y = Integer.parseInt(st.nextToken());
        		
        		x = getInd(x);          
        		y = getInd(y);          
        		graph[getOpposite(x)].add(y);
        		graph[getOpposite(y)].add(x);
        	}
        	
        	for(int i = 0;i<2*m;i++) {
        		if(finished[i]==0) {
        			SCC(i);
        		}
        	}
        	answer = 1;
        	for(int i = 0;i<2*m;i+=2) {
        		if(finished[i]==finished[i+1]) {
        			answer = 0;
        			break;
        		}
        	}
        	
        	sb.append(answer).append("\n");
        }


        System.out.println(sb.toString());

    }

}