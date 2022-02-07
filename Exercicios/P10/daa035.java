import java.util.*;


public class daa035{


	static void floydMarshall(int m[][], int n) {
		boolean connected[][] = new boolean[n][n];
		for (int i=0 ; i<n ; i++) connected[i][i] = true;

		for (int i=0 ; i<n ; i++) {
			for (int j=0 ; j<n ; j++) {
				if (m[i][j] == 1) connected[i][j] = true;	// as cidades com voos diretos, estão conetadas
			}
		}
		for (int k=0 ; k<n ; k++) {
			for (int i=0 ; i<n ; i++) {
				for (int j=0 ; j<n ; j++) {
					if(connected[i][k] && connected[k][j]) connected[i][j] = true;
				}
			}
		}
		show(m, n, connected);
	}

	static void show(int m[][], int n, boolean connected[][]) {
		char c;
		System.out.print(" ");
		for (int i=0 ; i<n ; i++) {
			c = (char)('A' + i);
			System.out.print(" " + c);
		}
		System.out.println();

		for (int i=0 ; i<n ; i++) {
			c = (char)('A' + i);
			System.out.print(c);
			for (int j=0 ; j<n ; j++) {
				if (connected[i][j]) System.out.print(" 1");
				else System.out.print(" 0");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();									// nº de cidades
		int m[][] = new int[n][n];

		for (int i=0 ; i<n ; i++) {
			int origin = in.next().charAt(0) - 'A';						// nº do pais de origem
			int nDest = in.nextInt();				// nº de destinos;
			for (int j=0 ; j<nDest ; j++) {
				int destination = in.next().charAt(0) - 'A';
				m[origin][destination] = 1;
			}
		}
		floydMarshall(m, n);
	}


}
