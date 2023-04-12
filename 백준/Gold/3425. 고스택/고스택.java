import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Query> order;
	static StringBuilder sb = new StringBuilder();
	static Stack<Long> stack;
	static class Query{
		String o;
		long x;
		public Query(String o, long x) {
			super();
			this.o = o;
			this.x = x;
		}
		
	}
	
	static void execute(long x) {
		stack.clear();
		stack.add(x);
		long x1,x2,v;
		boolean error = false;
		loop: for(Query q:order) {
			switch(q.o) {
			case "NUM":
				stack.add(q.x);
				break;
			case "POP":
				if(stack.isEmpty()) {
					error = true;
					break loop;
				}
				stack.pop();
				break;
			case "INV":
				if(!stack.isEmpty()) {
					stack.add(-stack.pop());
				}
				else {
					error = true;
					break loop;
				}
				break;
			case "DUP":
				if(stack.isEmpty()) {
					error = true;
					break loop;
				}
				stack.add(stack.peek());
				break;
			case "SWP":
				if(stack.size()>=2) {
					x1 = stack.pop();
					x2 = stack.pop();
					stack.add(x1);
					stack.add(x2);
				}
				else {
					error = true;
					break loop;
				}
				break;
			case "ADD":
				if(stack.size()>=2) {
					x1 = stack.pop();
					x2 = stack.pop();
					
					if(Math.abs(x2+x1)>1_000_000_000) {
						error = true;
						break loop;
					}
					stack.add(x1+x2);
				}
				else {
					error = true;
					break loop;
				}
				break;
			case "SUB":
				if(stack.size()>=2) {
					x1 = stack.pop();
					x2 = stack.pop();
					if(Math.abs(x2-x1)>1_000_000_000) {
						error = true;
						break loop;
					}
					stack.add(x2-x1);
				}
				else {
					error = true;
					break loop;
				}				
				break;
			case "MUL":
				if(stack.size()>=2) {
					x1 = stack.pop();
					x2 = stack.pop();
					if(Math.abs(x2*x1)>1_000_000_000) {
						error = true;
						break loop;
					}
					stack.add(x2*x1);
				}
				else {
					error = true;
					break loop;
				}	
				break;
			case "DIV":
				if(stack.size()>=2) {
					x1 = stack.pop();
					x2 = stack.pop();
					if(x1==0) {
						error = true;
						break loop;
					}
					v = Math.abs(x2)/Math.abs(x1);
					if(x1*x2<0) {
						stack.add(-v);
					}
					else {
						stack.add(v);
					}
				}
				else {
					error = true;
					break loop;
				}
				break;
			case "MOD":
				if(stack.size()>=2) {
					x1 = stack.pop();
					x2 = stack.pop();
					
					if(x1==0) {
						error = true;
						break loop;
					}
					v = Math.abs(x2)%Math.abs(x1);
					if(x2<0) {
						stack.add(-v);
					}
					else {
						stack.add(v);
					}
				}
				else {
					error = true;
					break loop;
				}
				break;
			}
		}
		
		if(error || stack.size()!=1 || Math.abs(stack.peek())>1_000_000_000) {
			sb.append("ERROR\n");
		}
		else {
			sb.append(stack.pop()).append("\n");
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		order = new ArrayList<Query>();
		String o;
		long x;
		int n;
		stack = new Stack<Long>();

		end: while(true) {
			order.clear();
			
			//명령어 입력받기
			while(true) {
				st = new StringTokenizer(br.readLine()," ");
				o = st.nextToken();
				
				if("QUIT".equals(o))
					break end;
				else if("NUM".equals(o)) {
					x = Long.parseLong(st.nextToken());
					order.add(new Query(o,x));
				}
				else {
					order.add(new Query(o,0));
				}
				
				if("END".equals(o)) {
					break;
				}
			}
			
			//시작 값들
			n = Integer.parseInt(br.readLine());
			while(n-->0) {
				x = Long.parseLong(br.readLine());
				execute(x);
			}
			
			br.readLine();
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}