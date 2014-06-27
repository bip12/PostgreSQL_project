package karki.jdbc.repo;

import karki.data.Station;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationMapper {
	
	public static List<Station> decode(ResultSet rs) {
		List<Station> rtn = new ArrayList<Station>();

		try {
			while (rs.next()) {
				Station s = new Station();
				s.setPrimary_id(rs.getString("primary_id"));
				s.setSecondary_id(rs.getString("secondary_id"));
				s.setStation_name(rs.getString("station_name"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));				
				s.setLatitude(rs.getDouble("latitude"));
				s.setLongitude(rs.getDouble("longitude"));
				s.setElevation(rs.getDouble("elevation"));
				s.setMesowest_network_id(rs.getString("mesowest_network_id"));
				s.setNetwork_name(rs.getString ("network_name"));
				s.setStatus(rs.getString("status"));
				s.setPrimary_provider_id(rs.getInt("primary_provider_id"));
				s.setPrimary_provider(rs.getString("primary_provider"));
				s.setSecondary_provider_id(rs.getInt("secondary_provider_id"));
				s.setSecondary_provider(rs.getString("secondary_provider"));
				s.setTertiary_provider_id(rs.getInt("tertiary_provider_id"));
				s.setTertiary_provider(rs.getString("tertiary_provider"));
				s.setWims_id(rs.getString("wims_id"));

				rtn.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rtn;
	}

	
	public static PreparedStatement encodePrepareNew(Connection con, Station s) throws Exception {
		if (s == null || con == null)
			return null;

		PreparedStatement ps = con.prepareStatement("insert into station (primary_id,secondary_id,station_name,state,country,"
				+ "latitude,longitude,elevation,mesowest_network_id,network_name,status,primary_provider_id,primary_provider,"
				+ "secondary_provider_id,secondary_provider,tertiary_provider_id,tertiary_provider,wims_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setString(1, s.getPrimary_id());
		ps.setString(2, s.getSecondary_id());
		ps.setString(3, s.getStation_name());
		ps.setString(4, s.getState());
		ps.setString(5, s.getCountry());
		ps.setDouble(6, s.getLatitude());
		ps.setDouble(7, s.getLongitude());
		ps.setDouble(8, s.getElevation());
		ps.setString(9, s.getMesowest_network_id());
		ps.setString(10, s.getNetwork_name());	
		ps.setString(11, s.getStatus());
		ps.setInt(12, s.getPrimary_provider_id());
		ps.setString(13, s.getPrimary_provider());
		ps.setInt(14, s.getSecondary_provider_id());
		ps.setString(15,  s.getSecondary_provider());
		ps.setInt(16,  s.getTertiary_provider_id());
		ps.setString(17,  s.getTertiary_provider());
		ps.setString(18, s.getWims_id());
			
		return ps;
	}

	public static PreparedStatement encodePrepareFind(Connection con, Station criteria) throws Exception {
		PreparedStatement ps = null;

		if (criteria == null)
			ps = con.prepareStatement("select * from station");

		return ps;
	}

	public static PreparedStatement encodePrepareRemove(Connection con, String pid) throws Exception {
		if (con == null)
			return null;

		PreparedStatement ps = con.prepareStatement("delete from station where primary_id = ?");
		ps.setString(1, pid);

		return ps;
	}
}
