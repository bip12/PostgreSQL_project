package karki.jdbc.repo;

import karki.data.Weather;
import karki.data.Station;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class RepositoryDatabase implements Repository {
	protected static Logger logger = LoggerFactory.getLogger("database");

	public static final String sDriver = "jdbc.driver";
	public static final String sUrl = "jdbc.url";
	public static final String sUser = "jdbc.user";
	public static final String sPass = "jdbc.password";

	protected Properties cfg;
	protected BoneCP cpool;

	protected RepositoryDatabase() {
	}

	public RepositoryDatabase(Properties cfg) {
		init(cfg);
	}

	protected void init(Properties cfg) {
		this.cfg = cfg;

		try {
			Class.forName(cfg.getProperty(sDriver));
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(cfg.getProperty(sUrl));
			config.setUsername(cfg.getProperty(sUser, "postgres"));
			config.setPassword(cfg.getProperty(sPass, "cmpe226"));
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(1);

			cpool = new BoneCP(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addStation(Station s) {
		if (s == null)
			return;
		
		Connection conn = null;
		try {
			conn = cpool.getConnection();			
			conn.setAutoCommit(false);
			//conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			PreparedStatement ps = StationMapper.encodePrepareNew(conn, s);
			ps.executeUpdate();		
			conn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("failed/exception on insert Station", ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void addWeather(Weather w) {
		if (w == null)
			return;

		Connection conn = null;
		try {
			conn = cpool.getConnection();
			//conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			PreparedStatement ps = WeatherMapper.encodePrepareNew(conn, w);
			ps.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("failed/exception on insert Station", ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
