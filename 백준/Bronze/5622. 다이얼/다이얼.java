import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		int total=0;
		for(int i=0;i<str.length();i++) {
			char chr = str.charAt(i);
			switch(chr) {
				case 'A' : case 'B' : case 'C' :
					total+=3; break;
				case 'D' : case 'E' : case 'F' :
					total+=4; break;
				case 'G' : case 'H' : case 'I' :
					total+=5; break;
				case 'J' : case 'K' : case 'L' :
					total+=6; break;
				case 'M' : case 'N' : case 'O' :
					total+=7; break;
				case 'P' : case 'Q' : case 'R' : case 'S':
					total+=8; break;
				case 'T' : case 'U' : case 'V' :
					total+=9; break;
				case 'W' : case 'X' : case 'Y' : case 'Z':
					total+=10; break;			
			}
		}
		bw.write(total+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
