
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDataset {
	
	protected List<double[]> features=new ArrayList<>();
	
	protected List<String> headers=new ArrayList<>();
	protected static int numberOfFeatures;
	
	public List<double[]> getFeatures()
	{
		return features;
	}
	
	
	
	void read(String s) throws NumberFormatException, IOException {
		
		File file=new File(s);
		
	try {
		BufferedReader readFile=new BufferedReader(new FileReader(file));
		String headerLine = readFile.readLine(); 
		String header[]  = headerLine.split(","); // array atrr name
		for (String i : header) {
			headers.add(i);
		}
		
		String line;
		while((line=readFile.readLine()) != null)
			{
			
			 String[] split = line.split(",");
			
            	//	 double[] feature = new double[split.length ];
            			 double[] feature = new double[split.length-1 ];
            		// System.out.println(split[0]+ " "+ split[1]+" "+ split[2]+" "+split[7] + " "+split[8]);
            			numberOfFeatures = split.length-1;
                        
                		for (int i = 0; i < split.length -1; i++)
            		 
             	//	numberOfFeatures = split.length;
            
            	//	for (int i = 0; i < split.length ; i++)
               			 feature[i] = Double.parseDouble(split[i]);
            		features.add(feature);

			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	System.out.println("data");
//	for (double[] ds : features) {
//		for (double d : ds) {
//			System.out.println(d+" ");
//		}
//	}
	
	}



}
