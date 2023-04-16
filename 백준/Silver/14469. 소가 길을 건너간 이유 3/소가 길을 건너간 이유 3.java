import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Cow implements Comparable<Cow>{
	int arrive;
	int enter;

	public Cow(int arrive, int enter) {
		super();
		this.arrive = arrive;
		this.enter = enter;
	}
	
	//도착시간으로 정렬해줘야함 만약 도착 시간 같으면 검문시간 짧은애부터인가...?
	@Override
	public int compareTo(Cow c) {
		return this.arrive != c.arrive? this.arrive-c.arrive : this.enter-c.enter;
	}
}

public class Main {
	
	static Cow[] cows;
	static int N;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		cows = new Cow[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		getResult();
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void getResult() {
		Arrays.sort(cows);
		int endTime = 0;
		for(int i=0;i<N;i++) {
			if(endTime< cows[i].arrive) {
				endTime = cows[i].arrive + cows[i].enter;
			}
			else if(endTime >= cows[i].arrive) {
				endTime += cows[i].enter;
			}
		}
		result = endTime;
	}
}