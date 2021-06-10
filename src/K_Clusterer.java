
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


public class K_Clusterer extends ReadDataset {

	public K_Clusterer() {
		// TODO Auto-generated constructor stub
	}
//main method
	
	
	public static void main(String args[]) throws IOException {
		
		
		
		ReadDataset r1 = new ReadDataset();
		r1.features.clear();
		Scanner sc = new Scanner(System.in);
//		String file=sc.next();
		String file = "wifi_localization.csv";
		r1.read(file); //load data
		System.out.println(r1.features.size());
		int ex=1;
	
		int k =4;
		
		int max_iterations = 500,current_ite=0;
		int distance = 1;
		
		//Hashmap to store centroids with index
		
		Map<Integer, double[]> centroids = new HashMap<>();	

			
//		double[] t1 = {-57,-55,-45,-59,-50,-85,-85};
//		
//		double[] t2 = {-59,-52,-61,-57,-69,-83,-78};
//		double[] t3 = {-34,-60,-52,-37,-71,-66,-75};
//		double[] t4 = {-60,-57,-58,-66,-65,-77,-80};
//		double[] t5 = {-55,-50,-46,-57,-48,-76,-87};
//			ArrayList<double[]> listCentroids = new  ArrayList<double[]>();
//		listCentroids.add(t1);
//		listCentroids.add(t2);
//		listCentroids.add(t3);
//		listCentroids.add(t4);
//		listCentroids.add(t5);



		// calculating initial centroids
		double[] x1 = new double[numberOfFeatures];
		
		int r =0;
		System.out.println("Khoi tao tam bat ki");
		for (int i = 0; i < k; i++) {
			
//			x1 = listCentroids.get(r++);	
//			centroids.put(i, x1);
			//Initial starting points (random):
			x1=r1.features.get(r++);
			centroids.put(i, x1);
//			
			System.out.print(" Tam "+ i+":  ");
			for (double d : x1) {
				System.out.print(+d+",");
			}
			System.out.println("\n");
		
		}
		
		Map<Integer, double[]> centroidsTemp = new HashMap<>();
		centroidsTemp.putAll(centroids);
		
		
		
		
		//Hashmap for finding cluster indexes
		Map<double[], Integer> clusters = new HashMap<>();
		
		
		
		// sap xep cac diem vao tam tuong ung
		
		clusters = kmeans(r1.features, distance, centroids, k);
		
		
		
		// initial cluster centroid 
//		for (double[] key : clusters.keySet()) {

//				
//			double []x = new  double[numberOfFeatures];
//			for (int i = 0; i < key.length; i++) {
//			//	System.out.print(key[i] + ", ");
//				x[i] = key[i];
//			}
//		//	System.out.print(clusters.get(key) + "\n");

//		}
		
	
		double db[] = new double[numberOfFeatures];
		//reassigning to new clusters
		for (int i = 0; i < max_iterations; i++) {
		//	System.out.println("lan "+i);
			for (int j = 0; j < k; j++) {
				List<double[]> list = new ArrayList<>();
				for (double[] key : clusters.keySet()) {
					// so sanh chi so tam cum 
					if (clusters.get(key)==j) {
						list.add(key);
//					for(int x=0;x<key.length;x++){
//						System.out.print(key[x]+", ");
//						}
//					System.out.println();
					}
			}
				//update centroid
				db = centroidCalculator(list);
				centroids.put(j, db);
			
			}
				
		//	  new centroids
//			System.out.println("tam ");
//			for (Integer key : centroidsTemp.keySet()) {			
//		System.out.print(key+" " );
//			for (double d : centroidsTemp.get(key)) {
//					System.out.print(d + ", ");
//			}		
//			
//			System.out.println("\n");		
//		}
			
		//check condition	
		boolean flag =true;
		for (Integer key : centroids.keySet()) {
			
				if (equal(centroids.get(key), centroidsTemp.get(key)) == false ) {
					flag = false;
				
				}			
		}
		if (flag) {	
		
			current_ite = i;
			
			System.out.println(" Tam sau khi phan cum ");
			for (Integer key : centroids.keySet()) {			
		System.out.print(" tam "+ key +" : " );
			for (double d : centroids.get(key)) {
					System.out.print( d+ ", ");
			}		
			
			System.out.println("\n");		
		}
			
			break;
		}
		current_ite = i;
			centroidsTemp.putAll(centroids);
			
			
			clusters.clear();
			clusters = kmeans(r1.features,distance, centroids, k);
			
		
			
		}
		
		//final cluster print
/*		System.out.println("\nKet qua Phan Cum ");

		for (String i : r1.headers) {
			System.out.print(i+" ");
		}
		System.out.println("Thuoc cum\n");
	//	System.out.println("Feature1\tFeature2\tFeature3\tFeature4\tFeature5\tFeature6\tFeature7\tFeature8\tCluster");
		for (double[] key : clusters.keySet()) {
//			if (clusters.get(key) == 0) {
			
		
			for (int i = 0; i < key.length; i++) {
				System.out.print(key[i] + "\t\t");
			}
			System.out.print(clusters.get(key) + "\n");
		//	}
		}
*/		
		//Calculate WCSS
		double wcss=0;
		
		for(int i=0;i<k;i++){
			double sse=0;
			// tung mang 4 ptu 
			for (double[] key : clusters.keySet()) {
				if (clusters.get(key)==i) {
					sse+=Math.pow(Distance.eucledianDistance(key, centroids.get(i)),2);
			//		System.out.println("sse "+ " --"+sse );
				}
				}
			wcss+=sse;
		//	System.out.println("wcss =" + i+ "------------------------"+wcss);
		}
		String dis="";
		if(distance ==1)
			 dis="Euclidean";
		else
			dis="Manhattan";
		System.out.println("\n*************************\n*********Results************\nDistance Metric: "+dis);
		System.out.println("Iterations: "+current_ite);
		System.out.println("Number of Clusters: "+k);
		DecimalFormat df = new DecimalFormat("#.####");


		System.out.println("WCSS : "+df.format(wcss));
		
		for (int i = 0; i < k; i++) {
			
		int sumOfCluster =0;
		for (double[] key : clusters.keySet()) {
			
				if (clusters.get(key)== i) {
					sumOfCluster++;
				}
			
			
		}
		System.out.println("Clustered Instances "+ i +" : "+ sumOfCluster);
	}
		
		
	} //end main
	
	private static boolean equal(double[] d1, double[] d2) {
		boolean flag = true;
		if (d1 != null && d2 !=null) {
			for (int i=0;i<d1.length;i++) {
				if (d1[i] != d2[i]) {
					return false;
				}
			}
			return flag;
		}
		else return false;
	}


	//method to calculate centroids
	public static double[] centroidCalculator(List<double[]> a) {
		
		int count = 0;
		//double x[] = new double[ReadDataset.numberOfFeatures];
		double sum=0.0;
		double[] centroids = new double[ReadDataset.numberOfFeatures];
		for (int i = 0; i < ReadDataset.numberOfFeatures; i++) {
			sum=0.0;
			count = 0;
			for(double[] x:a){
				count++;
				sum = sum + x[i];
			//	System.out.println("ta co "+ x[0] + " "+ x[1] );
			}
			DecimalFormat df = new DecimalFormat("#.####");
			double tmp = (double)sum / (double)count;
			
			centroids[i] = Double.parseDouble(df.format(tmp));
		}
		return centroids;

	}


	
	//method for putting features to clusters and reassignment of clusters.
	public static Map<double[], Integer> kmeans(List<double[]> features,int distance, Map<Integer, double[]> centroids, int k) {
		Map<double[], Integer> clusters = new HashMap<>();
		int k1 = 0;
		double dist=0.0;
		for(double[] x:features) {
			
			double minimum = 999999.0;
			for (int j = 0; j < k; j++) {
				if(distance==1){
				 dist = Distance.eucledianDistance(centroids.get(j), x);
			//	 System.out.println(" k/c giua " + x[0]+" "+x[1]+" "+x[2]+" "+x[3] + "- "+ centroids.get(j)[0] + " "+centroids.get(j)[1]+ " "+ dist);
				}
				else if(distance==2){
					dist = Distance.manhattanDistance(centroids.get(j), x);
				}
				if (dist < minimum) {
					minimum = dist;
					k1 = j;
				}
			
			}
			clusters.put(x, k1);
		}
		
		return clusters;

	}

}
