import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		boolean[] students = new boolean[30];
		
		for(int i=0;i<28;i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int ck = Integer.parseInt(st.nextToken());
			 students[ck-1] = true;
		}
		
		for(int i=0;i<30;i++) {
			if(!students[i]) bw.write(String.valueOf(i+1)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}