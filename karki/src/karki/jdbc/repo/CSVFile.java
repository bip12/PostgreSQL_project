package karki.jdbc.repo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CSVFile{
	
	public void listFiles(String directoryName){
	
		//String files;
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
        
        for (int i = 0; i < fList.length; i++) 
        {
        	 readCSV(fList[i]);  //pass all the files 
        }	       
	}
	
	public void readCSV(File fList){
		String csvRow;
		Check chk = new Check();
		File file = fList; //file="mesowest.out.sample.csv";
		try{
		BufferedReader CSVFile = new BufferedReader(new FileReader(file));
		String dataRow = CSVFile.readLine(); 
		String[] temp = dataRow.split(",");
		//System.out.println(temp.length);
			while (dataRow != null){
				csvRow = dataRow;//.split(",");
				if (temp.length == 18){
					chk.testAddStation(csvRow);
					System.out.println(file.getName());
				}else{
					chk.testAddWeather(csvRow);
					System.out.println(file.getName());
				}					
				dataRow = CSVFile.readLine(); // Read next line of data.
			}
			// Close the file once all data has been read.
			CSVFile.close();

		} catch (IOException ex){
			System.out.println("file error");
		}
	}//readCSV()
	public void listStationCSV(){
		 
		CSVFile listAllFiles = new CSVFile(); 
        //Windows directory 
        final String directoryWindows ="C://mesowestTxData/TxStationData/"; // change folder name to TxStationData2 when running version2 
        listAllFiles.listFiles(directoryWindows);
    }
	
	public void listWeatherCSV(){
		 
		CSVFile listAllFiles = new CSVFile(); 
        //Windows directory 
		final String directoryWindows ="C://mesowestTxData/TxWeatherData/";
        listAllFiles.listFiles(directoryWindows);
    }	
public static void main (String[] args){
		
	long st = System.currentTimeMillis();
	
		CSVFile testCSV = new CSVFile();
		Check c = new Check();
		try {
			c.setUpConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//testCSV.listStationCSV();   // To just run station list: turn this on and turn off testCSV.listWeatherCSV() 
		testCSV.listWeatherCSV();  // To just run weather list: turn this on and turn off testCSV.listStationCSV()
		long et = System.currentTimeMillis();
		System.out.println("time to insert stations: " + (et - st) + " msec " );
		
		
	}	
}