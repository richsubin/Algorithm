import java.io.*;
import java.util.*;

	
class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<T;i++) {
			String str = br.readLine();
			int next = Integer.parseInt(str.substring(2));
			int num = Integer.parseInt(str)+1;
			
			if(num % next != 0) result.append("Bye\n");
			else result.append("Good\n");
		}
		System.out.print(result);
	}
}