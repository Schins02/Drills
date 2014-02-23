public class sqrt_double{

	public static void main(String[] args){
		//System.out.println("\n" + sqrt(9));
		System.out.println("\n" + sqrt(.5));

	}

	public static double sqrt(double num){
		final double PRECISION = .001;
		double left = 0.0;
		double right = Math.max(1, num);
		double mid;

		while(left + PRECISION < right){
			mid = (left + right)/2.0;
			if(mid * mid > num)
				right = mid;
			else
				left = mid;
			System.out.println(left);
			System.out.println(mid);
			System.out.println(right);
		}
		return left;
	}





}