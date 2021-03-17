

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
	private static int[] prices;
	public final static String SPLIT =" ";
	public static void main(String args[]) throws NumberFormatException, IOException {
		List<Integer> miLista = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		String line =  br.readLine();
		int numOfBooks ;
		int[]position = new int[2];
			while(line != null) {
					numOfBooks = Integer.parseInt(line);
					prices = new int[numOfBooks];
					
					String[] numberArrays = null;
				line = br.readLine();
			
			numberArrays = line.split(SPLIT);
			for(int i =0; i<numOfBooks;i++) {
				prices[i] = Integer.parseInt(numberArrays[i]);
			}
			Arrays.sort(prices);
		
			line= br.readLine();
			int money = Integer.parseInt(line);	

		position= binarySerch(money,numOfBooks,prices);
		miLista.add(position[0]);
		miLista.add(position[1]);
		line= br.readLine();
		line= br.readLine();
		}
			for(int i=0;i<miLista.size();i+=2) {
				wr.write("Peter should buy books whose prices are "+miLista.get(i)+" and "+miLista.get(i+1)+".\n\n");
				}
		
		br.close();
		wr.close();
	}
	public static int[] binarySerch(int money,int numOfBooks, int[] prices){
		int min = 0;
		int max = money;
		int[] out = new int[2];
		for(int i = 0; i<numOfBooks; i++) {
			boolean found = false;
			int start = 0;
			int end = prices.length-1;
			while(start <= end && !found) {
				int min2 = (start+end)/2;
				if(min2 != i && prices[min2]+prices[i] == money && prices[min2]-prices[i]<max-min && prices[min2]-prices[i]>=0) {
					out[0] = prices[i];
					out[1] = prices[min2];
					found = true;
				}else if(prices[min2]+prices[i] > money) {
					end = min2-1;
				}else start = min2+1;
			}
		}
		return out;
	}
	
}
