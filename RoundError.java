/*S*M*BQ,
где
S – знак числа (мантиссы);
M – мантисса числа;
B – основание системы счисления, у нас 10;
Q – порядок числа.*/
public class RoundError {
	
	   public static void main(String[] args) {
		        double x1 = 0.7324e3 , x2 = 0.8261e-1;
			    double mantissa1 = 0.7324 , mantissa2 = 0.8261;
			    double exp1 = 3 ,  exp2 = -1;
				double xx = 0;
				double sum = 0;
			    double roundResult1 , roundResult2 ;
			
			if (x1>x2) {xx = mantissa2 * Math.pow(10,-exp1+exp2);
			sum = xx+mantissa1;
			System.out.println ("точное значение: " + sum* Math.pow(10,exp1));
			}
			else { xx=mantissa1 * Math.pow(10,-exp2+exp1);
			sum = xx+ mantissa2;
			System.out.println ("точное значение: " + sum* Math.pow(10,exp2));
			}
			
			roundResult1 = (double)Math.round(sum* Math.pow(10,exp1) * 10d) / 10d;
			System.out.println("округленное значение 1 : " + roundResult1);
			System.out.println("aбсолютная  ошибка 1 : " + (sum* Math.pow(10,exp1)  - roundResult1));
			System.out.println("относительная ошибка 1 : " + ( (sum* Math.pow(10,exp1)  - roundResult1)/roundResult1));
			
			roundResult2 = (double)Math.floor(sum* Math.pow(10,exp1) * 10d) / 10d;
			System.out.println("округленное значение 1 : " + roundResult2);
			System.out.println("aбсолютная  ошибка 2 : " + (sum* Math.pow(10,exp1)  - roundResult2));
			System.out.println("относительная ошибка 2 : " + ( (sum* Math.pow(10,exp1)  - roundResult2)/roundResult2));
			
	}

}
