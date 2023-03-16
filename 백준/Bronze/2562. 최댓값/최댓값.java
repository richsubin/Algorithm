import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int max = 0;
		int num;
		int maxpoint=0;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			num =Integer.parseInt(st.nextToken());
			
			if(max < num) {
				max = num;
				maxpoint = i;
			}
			
		}
		
		bw.write(String.valueOf(max)+"\n"+String.valueOf(maxpoint+1));
		bw.flush();
		bw.close();
	}
}