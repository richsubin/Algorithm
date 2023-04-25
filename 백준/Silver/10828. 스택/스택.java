import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			if(comm.equals("push"))
				stack.push(Integer.parseInt(st.nextToken()));
			if(comm.equals("pop")) {
				if(stack.isEmpty()) 
					sb.append(-1+"\n");
				
				else
					sb.append(stack.pop()+"\n");
			}
			
			if(comm.equals("size"))
				sb.append(stack.size()+"\n");
			
			if(comm.equals("empty")) {
				if(stack.isEmpty()) 
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
			}
			if(comm.equals("top")){
				if(stack.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(stack.peek()+"\n");
			}
		}
		bw.write(sb+"");
		bw.flush();
		bw.close();
		br.close();
	}
}