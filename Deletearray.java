/*Задача:
Дан массив целых чисел и ещё одно целое число. 
Удалите все вхождения этого числа из массива (пропусков быть не должно).*/
import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;
public class Deletearray {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Введите размер массива:");
	        int size = sc.nextInt();
	       // Scanner console = new Scanner(System.in);
	        System.out.println("Введите удаляемое число:");
	        int number = sc.nextInt();
	        System.out.println("Введите массив: ");
	        int array[] = new int[size];
	        for (int i=0; i< size ; i++) {
	        	array[i]=sc.nextInt();
	        }
	        System.out.println("Старый массив: " + Arrays.toString(array));
	        for (int i=0 ; i < array.length ; i++) {
	        		if (array[i]== number) {
	        			array=ArrayUtils.removeAllOccurrences(array, number);
	        		}
	        }
	        System.out.println("Новый массив:" + Arrays.toString(array));
	    sc.close();
	 }
	
}
