package karki.data;

public class Station {

	private String primary_id;
    private String secondary_id;
    private String station_name;
    private String state;
    private String country;
    private double latitude;
    private double longitude;
    private double elevation;
    private String mesowest_network_id;
    private String network_name;
    private String status;
    private int primary_provider_id;
    private String primary_provider;
    private int secondary_provider_id;
    private String secondary_provider;
    private int tertiary_provider_id;
    private String tertiary_provider;
    private String wims_id;
    
    public Station(){
    	
    }
   

    public String getPrimary_id() {
        return primary_id;
    }
    public void setPrimary_id(String primaryId) {
        this.primary_id = primaryId;
    }
    
    public String getSecondary_id() {
            return secondary_id;
    }
    public void setSecondary_id(String secondaryId) {
            this.secondary_id = secondaryId;
    }
    public String getStation_name() {
            return station_name;
    }
    public void setStation_name(String stationName) {
            this.station_name = stationName;
    }
    public String getState() {
            return state;
    }
    public void setState(String state) {
            this.state = state;
    }
    public String getCountry() {
            return country;
    }
    public void setCountry(String country) {
            this.country = country;
    }
    public double getLatitude() {
            return latitude;
    }
    public void setLatitude(double latitude) {
            this.latitude = latitude;
    }
    public double getLongitude() {
            return longitude;
    }
    public void setLongitude(double longitude) {
            this.longitude = longitude;
    }
    public double getElevation() {
            return elevation;
    }
    public void setElevation(double elevation) {
            this.elevation = elevation;
    }
    public String getMesowest_network_id() {
            return mesowest_network_id;
    }
    public void setMesowest_network_id(String networkId) {
            this.mesowest_network_id = networkId;
    }
    public String getNetwork_name() {
            return network_name;
    }
    public void setNetwork_name(String networkName) {
            this.network_name = networkName;
    }
    public String getStatus() {
            return status;
    }
    public void setStatus(String status) {
            this.status = status;
    }
    public int getPrimary_provider_id() {
            return primary_provider_id;
    }
    public void setPrimary_provider_id(int primaryProviderId) {
            this.primary_provider_id = primaryProviderId;
    }
    public String getPrimary_provider() {
            return primary_provider;
    }
    public void setPrimary_provider(String primaryProvider) {
            this.primary_provider = primaryProvider;
    }
    public int getSecondary_provider_id() {
            return secondary_provider_id;
    }
    public void setSecondary_provider_id(int secondaryProviderId) {
            this.secondary_provider_id = secondaryProviderId;
    }
    public String getSecondary_provider() {
            return secondary_provider;
    }
    public void setSecondary_provider(String secondaryProvider) {
            this.secondary_provider = secondaryProvider;
    }
    public int getTertiary_provider_id() {
            return tertiary_provider_id;
    }
    public void setTertiary_provider_id(int tertiaryProviderId) {
            this.tertiary_provider_id = tertiaryProviderId;
    }
    public String getTertiary_provider() {
            return tertiary_provider;
    }
    public void setTertiary_provider(String tertiaryProvider) {
            this.tertiary_provider = tertiaryProvider;
    }
    public String getWims_id(){
    	return wims_id;
    }
    public void setWims_id(String wims_id){
    	this.wims_id = wims_id;
    }


}