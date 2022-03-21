// в порядке возрастания су-столбцов
 
public class Matrix {
    private double[][] a;
    private int n;
    private int m;
 
    private void create(int k, int l) {
        a = new double[k][];
        int i;
        for (i = 0; i < k; i++)
            a[i] = new double[l];
    }
 
    public void print() {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                System.out.printf("%15.6E", a[i][j]);
            System.out.println();
        }
    }
 
    public void transposePrint() {
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++)
                System.out.printf("%15.6E", a[i][j]);
            System.out.println();
        }
    }
 
    public void init(String s) throws FileNotFoundException {
        File file = new File(s);
        Scanner scan = new Scanner(file);
        Pattern pat = Pattern.compile("[\\s\\t]+");
        String str = scan.nextLine();
        String[] sn = pat.split(str);
        n = Integer.parseInt(sn[0]);
        m = Integer.parseInt(sn[1]);
        create(n, m);
        int i, j;
        for (i = 0; i < n; i++) {
            str = scan.nextLine();
            sn = pat.split(str);
            for (j = 0; j < m; j++)
                a[i][j] = Double.parseDouble(sn[j]);
        }
        scan.close();
    }
 
    public double[][] transposeMatrix() {
        double[][] temp = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                temp[j][i] = a[i][j];
            }
        }
        a = temp;
        return a;
    }
    public double[][] sortMatrix() {
 
        double[] summa = new double[a.length];
 
 
        int i, j;
 
        for (i = 0; i < a.length; i++) {
            int summ = 0;
            for (j = 0; j < a[i].length; j++) {
                summ += a[i][j];
                summa[i] = summ;
            }
        }
 
 
        for (i = 0; i < a.length; i++) {
        	 j =a.length-1;
        	 double c = summa[j - 1];
        	 double[] tmp = a[j];
            for (; j >= 1; j--) {
 
                if (summa[j - 1] > summa[j]) {
                    summa[j - 1] = summa[j];
                    summa[j] = c;
                    
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
 
                }
            }
        }
		return a;
    } 
}


import java.io.FileNotFoundException;

public class MatrixTest {

	public static void main(String[] args) {
		Matrix mat = new Matrix();
		try
		{
		mat.init("data.txt");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found!");
		}
		mat.print();
		System.out.println(" ");
		
		mat.transposeMatrix();
	    mat.sortMatrix();
	    mat.transposeMatrix();
	    mat.print();
	    System.out.println(" ");
	     
		
		
	}
}
