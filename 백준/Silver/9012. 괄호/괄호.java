import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cnt;i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			Boolean vps = true;
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				
				if(c=='(') {
					stack.push(c);
				}
				else if(stack.empty()) {
					vps = false;
					break;
				}
				else {
					stack.pop();
				}
			}
			if(!stack.isEmpty()||!vps) {
				sb.append("NO\n");
			}
			else {
				sb.append("YES\n");
			}
			
		}
		
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}

}