package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public final static String SPLIT =" ";
	@SuppressWarnings("unused")
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int numOfBooks = Integer.parseInt(line);
		int[] prices = new int[numOfBooks];
		int money;
		String[] numberArrays = null;
		int countain = 0;
		while(line != null) {
			if(countain == 0) {
				line = br.readLine();
			}
			numberArrays = line.split(SPLIT);
			for(int i =0; i<numOfBooks;i++) {
				prices[i] = Integer.parseInt(numberArrays[i]);
				System.out.println(prices[i]);

			}
			Arrays.sort(prices);
		
			line= br.readLine();
			money = Integer.parseInt(line);	
			System.out.println("LLEGA");
			
		int[]position = differenceFind(prices,money);
		System.out.println("Peter should buy books whose prices are "+position[0] +" and "+position[1]+"\n");
		System.out.println("final");
		line= br.readLine();
		}
		br.close();
		wr.close();
	}
	public static int binarySerch(int[] values, int cash){
		int i= 0;
		int j = values.length-1;
		int fond = -1;
		int m =0;
		while(fond<0 && i<=j) {
			m = (i+j)/2;
			if(values[m] == cash) {
				fond = m;
			}else if(values[m]>cash) {
				j=m-1;
			}else {
				i=m+1;
			}
		}
		return fond;
		
	}
	public static int[] differenceFind(int []values, int cash ) {
		int diference = 0;
		int temporal = Integer.MAX_VALUE;
		int[]positions = new int[2];
		for(int i=0;i<values.length;i++) {
			if(binarySerch(values,(cash-values[i]))>=0) {
				if(values[i]-values[binarySerch(values,(cash-values[i]))]<Integer.MAX_VALUE) {
					diference = Math.abs(values[i]-values[binarySerch(values,(cash-values[i]))]);
					if((temporal)>(diference)) {
						temporal = diference;
						positions[0] = values[i];
						positions[1]= values[binarySerch(values,(cash-values[i]))];
					}
				}
			}
		}
		return positions;
		
	}
}
