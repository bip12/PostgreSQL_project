package karki.jdbc.repo;

import karki.data.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeatherMapper {
	
	public static List<Weather> decode(ResultSet rs) {
		List<Weather> rtn = new ArrayList<Weather>();

		try {
			while (rs.next()) {
				Weather w = new Weather();
				w.setStationCode(rs.getString("station_name"));
				w.setForcastTime(rs.getString("forcast_time"));
				w.setMNET(rs.getDouble("mnet"));
				w.setSLAT(rs.getDouble("latitude"));
				w.setSLON(rs.getDouble("longitude"));
				w.setSELV(rs.getDouble("elevation"));
				w.setTMPF(rs.getDouble("temperature"));
				w.setSKNT(rs.getDouble("sknt"));
				w.setDRCT(rs.getDouble("drct"));
				w.setGUST(rs.getDouble("gust"));
				w.setPMSL(rs.getDouble("pmsl"));
				w.setALTI(rs.getDouble("altitude"));
				w.setDWPF(rs.getDouble("dew_point"));
				w.setRELH(rs.getDouble("relative_humidity"));
				w.setWTHR(rs.getDouble("weather_code"));
				w.setPERCI(rs.getDouble("percitipation"));
				
				
				rtn.add(w);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rtn;
	}

	public static PreparedStatement encodePrepareNew(Connection con, Weather w) throws Exception {
		if (w == null || con == null || w.getStationCode() == null)
			return null;

		PreparedStatement ps = con.prepareStatement("insert into weather (station_name,forcast_time,"
				+ "mnet,latitude,longitude,elevation,temperature,sknt,drct,gust,pmsl,"
				+ "altitude,dew_point,relative_humidity,weather_code,percitipation) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setString(1, w.getStationCode());
		ps.setString(2,w.getForcastTime());
		ps.setDouble(3, w.getMNET(0));
		ps.setDouble(4, w.getSLAT());
		ps.setDouble(5, w.getSLON());
		ps.setDouble(6, w.getSELV());
		ps.setDouble(7, w.getTMPF());
		ps.setDouble(8, w.getSKNT());
		ps.setDouble(9, w.getDRCT());
		ps.setDouble(10, w.getGUST());
		ps.setDouble(11, w.getPMSL());
		ps.setDouble(12, w.getALTI());
		ps.setDouble(13, w.getDWPF());
		ps.setDouble(14, w.getRELH());
		ps.setDouble(15, w.getWTHR());
		ps.setDouble(16, w.getPERCI());
			
		return ps;
	}
	
	public static PreparedStatement encodePrepareFind(Connection con, String sname) throws Exception {
		PreparedStatement ps = con.prepareStatement("select * from weather where stationname = ?");
		ps.setString(1, sname);
		return ps;
	}	
}
