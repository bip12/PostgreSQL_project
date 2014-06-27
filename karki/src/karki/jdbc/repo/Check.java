package karki.jdbc.repo;
import karki.data.Station;
import karki.data.Weather;
import karki.jdbc.repo.Repository;
import karki.jdbc.repo.RepositoryDatabase;
import java.util.Properties;


public class Check {
	static private Repository rep;
	int N = 1, M = 1;
	
	public void setUpConn() throws Exception {
		Properties cfg = new Properties();
		cfg.setProperty(RepositoryDatabase.sDriver, "org.postgresql.Driver");
		cfg.setProperty(RepositoryDatabase.sUrl, "jdbc:postgresql://127.0.0.1:5432/postgres");
		rep = new RepositoryDatabase(cfg);
	}
	
	 
	public void testAddStation(String r){	
		Station s = new Station();
		long st = System.currentTimeMillis();
		String str = r;
		String row[]= str.split(",");
	
		s.setPrimary_id(row[0]);
		s.setSecondary_id(row[1]);
		s.setStation_name(row[2]);
		s.setState(row[3]);
		s.setCountry(row[4]);
		s.setLatitude(Math.round(Double.parseDouble(row[5])*100.0)/100.0);
		s.setLongitude(Math.round(Double.parseDouble(row[6])*100.0)/100.0);
		s.setElevation(Math.round(Double.parseDouble(row[7])*100.0)/100.0);
		s.setMesowest_network_id(row[8]);
		s.setNetwork_name(row[9]);
		s.setStatus(row[10]);
		
		if(row[11].length() != 0){
			s.setPrimary_provider_id(Integer.parseInt(row[11]));
		}
		
		s.setPrimary_provider(row[12]);
		
		if(row[13].length() != 0){
		s.setSecondary_provider_id(Integer.parseInt(row[13]));
		}
		
		s.setSecondary_provider(row[14]);
		
		if(row[15].length() !=  0){
		s.setTertiary_provider_id(Integer.parseInt(row[15]));
		}
		
		s.setTertiary_provider(row[16]);
		s.setWims_id(row[17]);
		
		rep.addStation(s);
		N=N+1;
		long et = System.currentTimeMillis();
		System.out.println("total station created: " + N + "\t insert per row: "+(et - st)+" msec");
	}
	

	public void testAddWeather(String r){	
		long st = System.currentTimeMillis();
		String s = r;
		String row[]= s.split(",");	
		Double mnet =(Math.round(Double.parseDouble(row[2])*100.0)/100.0);
		Double slat = (Math.round(Double.parseDouble(row[3])*100.0)/100.0);
		Double slong = (Math.round(Double.parseDouble(row[4])*100.0)/100.0);
		Double elev = (Math.round(Double.parseDouble(row[5])*100.0)/100.0);
		Double temp = (Math.round(Double.parseDouble(row[6])*100.0)/100.0);
		Double sknt = (Math.round(Double.parseDouble(row[7])*100.0)/100.0);
		Double drct = (Math.round(Double.parseDouble(row[8])*100.0)/100.0);
		Double gust = (Math.round(Double.parseDouble(row[9])*100.0)/100.0);
		Double pmsl = (Math.round(Double.parseDouble(row[10])*100.0)/100.0);
		Double alti = (Math.round(Double.parseDouble(row[11])*100.0)/100.0);
		Double dew = (Math.round(Double.parseDouble(row[12])*100.0)/100.0);
		Double relhum = (Math.round(Double.parseDouble(row[13])*100.0)/100.0);
		Double wcode = (Math.round(Double.parseDouble(row[14])*100.0)/100.0);
		Double perci = (Math.round(Double.parseDouble(row[15])*100.0)/100.0);
		
		Weather w = new Weather();
		
		w.setStationCode(row[0]);
		w.setForcastTime(row[1]);
		w.getMNET(mnet);
		w.setSLAT(slat);
		w.setSLON(slong);
		w.setSELV(elev);
		w.setTMPF(temp);
		w.setSKNT(sknt);
		w.setDRCT(drct);
		w.setGUST(gust);
		w.setPMSL(pmsl);
		w.setALTI(alti);
		w.setDWPF(dew);
		w.setRELH(relhum);
		w.setWTHR(wcode);
		w.setPERCI(perci);
		
		rep.addWeather(w);
		M=M+1;
		long et = System.currentTimeMillis();
		System.out.println("total weather created: " + M + "\t insert per row: "+(et - st)+ " msec ");
	}	
}
