import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int count = 0;
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(i<str.length()-1) {
				if(ch == 'c') {
					if(str.charAt(i+1) == '=' || str.charAt(i+1)=='-') 
						i++;
				}
				else if(ch=='d'&&i<str.length()-1) {
					if(str.charAt(i+1) == 'z'&&i<str.length()-2) {
						if(str.charAt(i+2)=='=')
							i+=2;
					}
					else if(str.charAt(i+1)=='-')
						i++;
				}
				else if(ch=='l') {
					if(str.charAt(i+1) == 'j')
						i++;
				}
				else if(ch=='n') {
					if(str.charAt(i+1) == 'j')
						i++;
				}
				else if(ch=='s') {
					if(str.charAt(i+1) == '=')
						i++;
				}
				else if(ch=='z') {
					if(str.charAt(i+1) == '=')
						i++;
				}
			}
			count++;
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();
	}
}