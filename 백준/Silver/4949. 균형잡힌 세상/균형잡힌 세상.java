import java.io.*;
import java.util.*;

	
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			
			for(int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				}
				else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}
					else
						stack.push(c);
				}
				else if(c == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}
					else
						stack.push(c);
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("yes\n");
			}
			else {
				sb.append("no\n");
			}
		}
		System.out.print(sb);
	}
}