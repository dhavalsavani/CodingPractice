package challenges.kickstart.ks2019.r1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/000000000006987d

3
3 3
101
000
101
1 2
11
5 5
10001
00000
00000
00000
10001
  
Case #1: 1
Case #2: 0
Case #3: 2

 */
public class Parcels {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			long startTime = new Date().getTime();
			for(int i = 1; i <= t; i++) {
//				int r = scanner.nextInt();
//				int c = scanner.nextInt();
//				scanner.nextLine();
//				//Creating grid array
//				int grid[][] = new int[r][c];
//				for(int j = 0; j < r; j++) {
//					grid[j] = Arrays.stream(scanner.nextLine().split("|"))
//									.mapToInt(s -> Integer.parseInt(s))
//									.toArray();
//				}
				
				//
				int r = 250;
				int c = 250;
				int grid[][] = new int[r][c];
				try {
					Scanner sc = new Scanner(new File("src/main/resources/parcels.txt"));
					for(int j = 0; j < r; j++) {
						grid[j] = Arrays.stream(sc.nextLine().split("|"))
										.mapToInt(s -> Integer.parseInt(s))
										.toArray();
					}
					sc.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				//
				
				List<Index> ones = new ArrayList<>();
				List<Index> zeros = new ArrayList<>();
				//Marking all 1's and 0's position
				for(int k = 0; k < r; k++) {
					for(int l = 0; l < c; l++) {
						if(grid[k][l] == 1) {
							ones.add(new Index(k, l));
						} else {
							zeros.add(new Index(k, l));
						}
					}
				}
				
				//If all are ones then printing '0' and continuing to next test case
				if(ones.size() == (r * c)) {
					System.out.println("Case #" + i + ": " + 0);
					continue;
				}
				
				int minDeliveryTimeAfterNewOffice = Integer.MAX_VALUE;
				for(Index zIndex : zeros) {
					int maxDeliveryTime = 0;
					int[][] temp = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
					temp[zIndex.x][zIndex.y] = 1;
					
					List<Index> onesTemp = new ArrayList<>();
					List<Index> zerosTemp = new ArrayList<>();
					//Marking all 1's and 0's position
					for(int k = 0; k < r; k++) {
						for(int l = 0; l < c; l++) {
							if(temp[k][l] == 1) {
								onesTemp.add(new Index(k, l));
							} else {
								zerosTemp.add(new Index(k, l));
							}
						}
					}
					
					for(int m = 0; m < r; m++) {
						for(int n = 0; n < c; n++) {
							if(temp[m][n] == 0) {
								int minDistance = Integer.MAX_VALUE;
								for(Index index : onesTemp) {
									int distance = Math.abs(index.x - m) + Math.abs(index.y - n);
									if(distance < minDistance) {
										minDistance = distance;
									}
								}
								if(minDistance > maxDeliveryTime) {
									maxDeliveryTime = minDistance;
								}
							}
						}
					}
					
					if(minDeliveryTimeAfterNewOffice > maxDeliveryTime) {
						minDeliveryTimeAfterNewOffice = maxDeliveryTime;
					}
				}
				
				System.out.println("Case #" + i + ": " + minDeliveryTimeAfterNewOffice);
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}

class Index {
	int x;
	int y;
	
	public Index(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}