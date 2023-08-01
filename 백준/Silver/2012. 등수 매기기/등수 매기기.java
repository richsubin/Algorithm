import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] predict = new int[N];
		int[] real = new int[N];
		long result = 0;
		
		for(int i=0;i<N;i++) {
			predict[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(predict);
		
		for(int i=0;i<N;i++) {
			result += Math.abs(predict[i]-(i+1));
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
