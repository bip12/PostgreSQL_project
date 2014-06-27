package karki.jdbc.repo;

import karki.data.Station;
import karki.data.Weather;

public interface Repository {

	void addStation(Station s);

	void addWeather(Weather w);

}