package javaSamet;

import java.util.Scanner;

public class second0ne {

	public static void main(String[] args) {
	
		
		// De i kenler Ba lad //
	
		int startXCoord;
		int endXCoord;
		int startYCoord;
		int endYCoord;
		int i, j, k;
		int plantingCount;
		Plant[] Plants = new Plant[5];
		Plant artichoke = new Plant(1, "artichoke", 6);
		Plant Tomato = new Plant(2, "Tomato", 4);
		Plant Wheat = new Plant(3, "Wheat", 2);
		Plant Corn = new Plant(4, "Corn", 3);
		Plant Potato = new Plant(5, "Potato", 1);

		
		Plants[0]=artichoke;
		Plants[1]=Tomato;
		Plants[2]=Wheat;
		Plants[3]=Corn;
		Plants[4]=Potato;
		
		// De i kenler Bitti//
		
		// Scanner b l m  Ba lad //
		Scanner input = new Scanner(System.in);
		int sizeX = input.nextInt();
		if(sizeX>40) {
			System.out.println("Size should be less than 40. Please enter again");
			sizeX = input.nextInt();
		}
		int sizeY = input.nextInt();
		if(sizeY>40) {
			System.out.println("Size should be less than 40. Please enter again");
			sizeY = input.nextInt();
		}
		int currentYear = input.nextInt();
		// Scanner Bitti//
		
		
		// Listeler Ba lad //
		int[][] list = new int[sizeY][sizeX];
		int[][] chclist = new int[sizeY][sizeX];
		// Listeler Bitti//

		// Ana Metod Ba lad //
		for (int m = currentYear; m<=2018; m++) {
			plantingCount = input.nextInt();
			int[] plantTypes = new int[plantingCount];
			
			for (i = 0; i < plantingCount; i++) {
				plantTypes[i]=input.nextInt();
			}
			
			for (i = 0; i < sizeY; i++) {
				for (j = 0; j < sizeX; j++) {
					chclist[i][j] = list[i][j];
				}
			}

			// ilk kontrol Ba lad //
			for (i = 0; i < plantingCount; i++) {
				startXCoord = input.nextInt();
				startYCoord = input.nextInt();
				endXCoord = input.nextInt();
				endYCoord = input.nextInt();

				for (j = startYCoord; j < endYCoord + 1; j++) {
					for (k = startXCoord; k < endXCoord + 1; k++) {
						list[j][k] = list[j][k] + Plants[plantTypes[i]-1].tiredness_level;
					}

				}

			}
			//   karma Ba lad //
			for (i = 0; i < sizeY; i++) {
				for (j = 0; j < sizeX; j++) {
					if (list[i][j] == chclist[i][j] && chclist[i][j] != 0)
						list[i][j] = list[i][j] - 3;
						if(list[i][j]<0) {
							list[i][j]=0;
						}
				}
			}

			if (m== 2018)
				break;

			currentYear = input.nextInt();

		}

		// Yazd rma Ba lad //

		for (i = 0; i < sizeY; i++) {
			for (j = 0; j < sizeX; j++) {
				System.out.printf("%d ", list[i][j]);
			}
			System.out.printf("\n");
		}
		// Yazd rma Bitti//
	}

}
