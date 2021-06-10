import java.text.DecimalFormat;

public class Distance {

	public Distance() {
		// TODO Auto-generated constructor stub
	}
	
	public static double eucledianDistance(double[] point1, double[] point2) {
        double sum = 0.0;
        for(int i = 0; i < point1.length; i++) {
        	//System.out.println(point1[i]+" "+point2[i]);
            sum += ((point1[i] - point2[i]) * (point1[i] - point2[i]));
        }
        DecimalFormat df = new DecimalFormat("#.####");
//        Double.parseDouble(df.format( Math.sqrt(sum)));
        return  Double.parseDouble(df.format( Math.sqrt(sum)));
    }
    
    public static double manhattanDistance(double point1[], double point2[]){
    	double sum = 0.0;
        for(int i = 0; i < point1.length; i++) {
            sum += (Math.abs(point1[i] - point2[i]));
        }
        return sum;
    }
    

}
