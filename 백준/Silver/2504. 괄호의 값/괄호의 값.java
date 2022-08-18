import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack =  new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] carr = br.readLine().toCharArray();
		int temp;
		boolean pos = true;
		end:for(char c:carr) {
			//System.out.println(Arrays.toString(stack.toArray()));
			switch(c) {
			case '(':
				stack.push(-1);
				break;
			case '[':
				stack.push(-2);
				break;
			case ')':
				if(!stack.isEmpty()) {
					switch(stack.peek()) {
					case -1:
						stack.pop();
						if(!stack.isEmpty()&&stack.peek()>0) {
							stack.push(stack.pop()+2);
						}
						else
							stack.push(2);
						break;
					case -2:
						pos = false;
						break end;
					default:
						temp = stack.pop();
						if(!stack.isEmpty()&&stack.peek()==-1) {
							stack.pop();
							if(!stack.isEmpty()&&stack.peek()>0) {
								stack.push(temp*2+stack.pop());
							}
							else {
								stack.push(temp*2);								
							}
						}
						else {
							pos = false;
							break end;
						}
						break;
					}
				}
				else {
					pos = false;
					break end;
				}
				break;
			case ']':
				if(!stack.isEmpty()) {
					switch(stack.peek()) {
					case -2:
						stack.pop();
						if(!stack.isEmpty()&&stack.peek()>0) {
							stack.push(stack.pop()+3);
						}
						else
							stack.push(3);
						break;
					case -1:
						pos = false;
						break end;
					default:
						temp = stack.pop();
						if(!stack.isEmpty()&&stack.peek()==-2) {
							stack.pop();
							if(!stack.isEmpty()&&stack.peek()>0) {
								stack.push(temp*3+stack.pop());
							}
							else {
								stack.push(temp*3);								
							}
						}
						else {
							pos = false;
							break end;
						}
						break;
					}
				}
				else {
					pos = false;
					break end;
				}
				break;
			}
		}	
		if(pos&&stack.size()==1&&stack.peek()>0) {
			System.out.println(stack.pop());
		}
		else {
			System.out.println(0);
		}		
	}
}