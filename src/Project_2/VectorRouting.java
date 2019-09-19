/**
 * 
 */
package Project_2;

/**
 * @author Taylor Gutzmann
 *
 */
public class VectorRouting {

	private static Double[][] routeVectors(int startNode, Double[][] graph) {
		int neighborNodeLeft;
		int neighborNodeRight;
		int neighborNodeUp;
		int neighborNodeDown;
		Double[][] vectors = graph;
		if(startNode > 1) {
			neighborNodeLeft = startNode-1;
			for(int i = 1; i < 31; i++) {
				if(vectors[neighborNodeLeft][i] != Double.POSITIVE_INFINITY && vectors[startNode][i]>(vectors[startNode][neighborNodeLeft]+vectors[neighborNodeLeft][i])) {
					vectors[startNode][i] = vectors[startNode][neighborNodeLeft]+vectors[neighborNodeLeft][i];
				}
			}
		}
		if(startNode < 30) {
			neighborNodeRight = startNode+1;
			for(int i = 1; i < 31; i++) {
				if(vectors[neighborNodeRight][i] != Double.POSITIVE_INFINITY && vectors[startNode][i]>(vectors[startNode][neighborNodeRight]+vectors[neighborNodeRight][i])) {
					vectors[startNode][i] = vectors[startNode][neighborNodeRight] + vectors[neighborNodeRight][i];
				}
			}
		}
		if(startNode > 6) {
			neighborNodeUp = startNode-6;
			for(int i = 1; i < 31; i++) {
				if(vectors[neighborNodeUp][i] != Double.POSITIVE_INFINITY && vectors[startNode][i]>(vectors[startNode][neighborNodeUp]+vectors[neighborNodeUp][i])) {
					vectors[startNode][i] = vectors[startNode][neighborNodeUp] + vectors[neighborNodeUp][i];
				}
			}
		}
		if(startNode < 25) {
			neighborNodeDown = startNode+6;
			for(int i = 1; i < 31; i++) {
				if(vectors[neighborNodeDown][i] != Double.POSITIVE_INFINITY && vectors[startNode][i]>(vectors[startNode][neighborNodeDown]+vectors[neighborNodeDown][i])) {
					vectors[startNode][i] = vectors[startNode][neighborNodeDown] + vectors[neighborNodeDown][i];
				}
			}
		}
		return vectors;
	}

	public static void main(String[] args) {
		
		Double[][] vectors = new Double[31][31];
		
		for(int i = 0; i < 31; i++) {
			for(int j = 0; j < 31; j++) {
				vectors[i][j] = Double.POSITIVE_INFINITY;
			}
		}
//		Neighbors of 1			Neighbors of 10			Neighbors of 19			Neighbors of 28
		vectors[1][1] = 0.0;	vectors[10][10] = 0.0;	vectors[19][19] = 0.0;	vectors[28][28] = 0.0;
		vectors[1][2] = 1.0;	vectors[10][9] = 1.0;	vectors[19][20] = 1.0;	vectors[28][27] = 1.0;
		vectors[1][7] = 5.0;	vectors[10][11] = 1.0;	vectors[19][13] = 6.0;	vectors[28][29] = 1.0;
								vectors[10][4] = 4.0;	vectors[19][25] = 4.0;	vectors[28][22] = 2.0;
								vectors[10][16] = 8.0;
								
//		Neighbors of 2			Neighbors of 11			Neighbors of 20			Neighbors of 29
		vectors[2][2] = 0.0;	vectors[11][11] = 0.0;	vectors[20][20] = 0.0;	vectors[29][29] = 0.0;
		vectors[2][1] = 1.0;	vectors[11][10] = 1.0;	vectors[20][19] = 1.0;	vectors[29][28] = 1.0;
		vectors[2][3] = 1.0;	vectors[11][12] = 1.0;	vectors[20][21] = 1.0;	vectors[29][30] = 1.0;
		vectors[2][8] = 3.0;	vectors[11][5] = 5.0;	vectors[20][14] = 3.0;	vectors[29][23] = 2.0;
								vectors[11][17] = 11.0;	vectors[20][26] = 4.0;
		
//		Neighbors of 3			Neighbors of 12			Neighbors of 21			Neighbors of 30
		vectors[3][3] = 0.0;	vectors[12][12] = 0.0;	vectors[21][21] = 0.0;	vectors[30][30] = 0.0;
		vectors[3][2] = 1.0;	vectors[12][11] = 1.0;	vectors[21][20] = 1.0;	vectors[30][29] = 1.0;
		vectors[3][4] = 1.0;	vectors[12][6] = 9.0;	vectors[21][22] = 1.0;	vectors[30][24] = 3.0;
		vectors[3][9] = 10.0;	vectors[12][18] = 10.0;	vectors[21][15] = 5.0;
														vectors[21][27] = 3.0;
		
//	    Neighbors of 4			Neighbors of 13			Neighbors of 22
		vectors[4][4] = 0.0;	vectors[13][13] = 0.0;	vectors[22][22] = 0.0;								
		vectors[4][3] = 1.0;	vectors[13][14] = 1.0;	vectors[22][21] = 1.0;
		vectors[4][5] = 1.0;	vectors[13][7] = 12.0;	vectors[22][23] = 1.0;
		vectors[4][10] = 4.0;	vectors[13][19] = 6.0;	vectors[22][16] = 4.0;
														vectors[22][28] = 2.0;
		
//		Neighbors of 5			Neighbors of 14			Neighbors of 23
		vectors[5][5] = 0.0;	vectors[14][14] = 0.0;	vectors[23][23] = 0.0;								
		vectors[5][4] = 1.0;	vectors[14][13] = 1.0;	vectors[23][22] = 1.0;
		vectors[5][6] = 1.0;	vectors[14][15] = 1.0;	vectors[23][24] = 1.0;
		vectors[5][1] = 5.0;	vectors[14][8] = 10.0;	vectors[23][17] = 2.0;
								vectors[14][20] = 3.0;	vectors[23][29] = 2.0;
		
//		Neighbors of 6			Neighbors of 15			Neighbors of 24
		vectors[6][6] = 0.0;	vectors[15][15] = 0.0;	vectors[24][24] = 0.0;				
		vectors[6][5] = 1.0;	vectors[15][14] = 1.0;	vectors[24][23] = 1.0;
		vectors[6][12] = 9.0;	vectors[15][16] = 1.0;	vectors[24][18] = 3.0;
								vectors[15][9] = 9.0;	vectors[24][30] = 3.0;
								vectors[15][21] = 5.0;
		
//		Neighbors of 7			Neighbors of 16			Neighbors of 25
		vectors[7][7] = 0.0;	vectors[16][16] = 0.0;	vectors[25][25] = 0.0;			
		vectors[7][8] = 1.0;	vectors[16][15] = 1.0;	vectors[25][26] = 1.0;
		vectors[7][1] = 5.0;	vectors[16][17] = 1.0;	vectors[25][19] = 4.0;
		vectors[7][13] = 12.0;	vectors[16][10] = 8.0;
								vectors[16][22] = 4.0;
		
//		Neighbors of 8			Neighbors of 17			Neighbors of 26
		vectors[8][8] = 0.0;	vectors[17][17] = 0.0;	vectors[26][26] = 0.0;			
		vectors[8][7] = 1.0;	vectors[17][16] = 1.0;	vectors[26][25] = 1.0;
		vectors[8][9] = 1.0;	vectors[17][18] = 1.0;	vectors[26][27] = 1.0;
		vectors[8][2] = 3.0;	vectors[17][11] = 11.0;	vectors[26][20] = 4.0;
		vectors[8][14] = 10.0;	vectors[17][23] = 2.0;
		
//		Neighbors of 9			Neighbors of 18			Neighbors of 27
		vectors[9][9] = 0.0;	vectors[18][18] = 0.0;	vectors[27][27] = 0.0;
		vectors[9][8] = 1.0;	vectors[18][17] = 1.0;	vectors[27][26] = 1.0;
		vectors[9][10] = 1.0;	vectors[18][12] = 10.0;	vectors[27][28] = 1.0;
		vectors[9][3] = 10.0;	vectors[18][24] = 3.0;	vectors[27][21] = 3.0;
		vectors[9][15] = 9.0;
		
		int updater = 1;
		while(vectors[1][30] != 20) {
			int randoNumber = (int) ((Math.random()*30)+1);
			vectors = routeVectors(randoNumber, vectors);
			System.out.println("Update#"+updater+":\t"+vectors[1][30]);
			updater++;
		}
		
	}

}
