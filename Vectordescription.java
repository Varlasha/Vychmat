/*Задача:
Создайте класс, который описывает вектор (в трёхмерном пространстве).
У него должны быть:
конструктор с параметрами в виде списка координат x, y, z
метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt():
sqrt{x^2 + y^2 + z^2}

метод, вычисляющий скалярное произведение:
x1*x2 + y1*y2 + z1*z2

метод, вычисляющий векторное произведение с другим вектором:
(y1*z2 - z1*y2, z1*x2 - x1*z2, x1*y2 - y1*x2)

метод, вычисляющий угол между векторами (или косинус угла): 
косинус угла между векторами равен скалярному произведению векторов, деленному на произведение модулей (длин) векторов:
frac{(a,b)}{|a| \cdot |b|}

методы для суммы и разности:
(x1 + x2, y1 + y2, z1 + z2)

(x1 - x2, y1 - y2, z1 - z2)
статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N.
Если метод возвращает вектор, то он должен возвращать новый объект, а не менять базовый. 
То есть, нужно реализовать шаблон "Неизменяемый объект"*/
public class Vectordescription {
	//вектора
	private double x,y,z; 
	//конструктор (ссылки на переменные для статического метода)
	public Vectordescription  (double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	// Длина вектора. Корень из суммы квадратов
	public double length() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	// метод, вычисляющий скалярное произведение
	public int scalarMult (Vectordescription vector) {
		return  (int) (x*vector.x + y*vector.y + z*vector.z) ;
	}
	// метод, вычисляющий векторное произведение
	public Vectordescription vectMult (Vectordescription vector) {
		return new Vectordescription ( y*vector.z - z*vector.y, z*vector.x - x*vector.z, x*vector.y - y*vector.x );
	}
	//метод, вычисляющий угол между векторами
	public double cosNook (Vectordescription vector) {
		return scalarMult(vector)/ (length()*vector.length()); 
	}
	//методы для суммы и разности
	public Vectordescription sum (Vectordescription vector) {
		return new Vectordescription (x + vector.x, y + vector.y, z + vector.z);
	}
	public Vectordescription diff (Vectordescription vector) {
		return new Vectordescription (x - vector.x, y - vector.y, z - vector.z);
	}
	/*статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N.
	Если метод возвращает вектор, то он должен возвращать новый объект, а не менять базовый.*/
	public static Vectordescription[] refund (int n) {
		Vectordescription[] vectors = new Vectordescription[n];
		for (int i = 0; i < n; i++) {
			vectors[i] = new Vectordescription(Math.random(),Math.random(),Math.random());
		}
		return vectors;
	}
	public String toString() {
        return "Vector{ " +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                " }";
    }
	public static void main(String[] args) {
		Vectordescription[] vectors = Vectordescription.refund(10);
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println("Длина: " + vectors[0].length());
        System.out.println("Скалярное произведение: " + vectors[0].scalarMult (vectors[1]));
        System.out.println("Векторное произведение: " + vectors[0].vectMult(vectors[1]));
        System.out.println("Угол между векторами: " + vectors[0].cosNook(vectors[1]));
        System.out.println("Сумма: " + vectors[0].sum(vectors[1]));
        System.out.println("Разность: " + vectors[0].diff(vectors[1]));
    }
}
