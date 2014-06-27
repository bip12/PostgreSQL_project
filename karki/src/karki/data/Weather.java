package karki.data;

public class Weather {
    private String stationCode;
    private String forcastTime;
    private double MNET;
    private double SLAT;
    private double SLON;
    private double SELV;
    private double TMPF;
    private double SKNT;
    private double DRCT;
    private double GUST;
    private double PMSL;
    private double ALTI;
    private double DWPF;
    private double RELH;
    private double WTHR;
    private double PERCI;
   
    public String getStationCode() {
            return stationCode;
    }
    public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
    }
    public String getForcastTime() {
            return forcastTime;
    }
    public void setForcastTime(String t) {
            this.forcastTime = t;
    }
    public double getMNET(double d) {
            return MNET;
    }
    public void setMNET(double mNET) {
            MNET = mNET;
    }
    public double getSLAT() {
            return SLAT;
    }
    public void setSLAT(double sLAT) {
            SLAT = sLAT;
    }
    public double getSLON() {
            return SLON;
    }
    public void setSLON(double sLON) {
            SLON = sLON;
    }
    public double getSELV() {
            return SELV;
    }
    public void setSELV(double sELV) {
            SELV = sELV;
    }
    public double getTMPF() {
            return TMPF;
    }
    public void setTMPF(double tMPF) {
            TMPF = tMPF;
    }
    public double getSKNT() {
            return SKNT;
    }
    public void setSKNT(double sKNT) {
            SKNT = sKNT;
    }
    public double getDRCT() {
            return DRCT;
    }
    public void setDRCT(double dRCT) {
            DRCT = dRCT;
    }
    public double getGUST() {
            return GUST;
    }
    public void setGUST(double gUST) {
            GUST = gUST;
    }
    public double getPMSL() {
            return PMSL;
    }
    public void setPMSL(double pMSL) {
            PMSL = pMSL;
    }
    public double getALTI() {
            return ALTI;
    }
    public void setALTI(double aLTI) {
            ALTI = aLTI;
    }
    public double getDWPF() {
            return DWPF;
    }
    public void setDWPF(double dWPF) {
            DWPF = dWPF;
    }
    public double getRELH() {
            return RELH;
    }
    public void setRELH(double rELH) {
            RELH = rELH;
    }
    public double getWTHR() {
            return WTHR;
    }
    public void setWTHR(double wTHR) {
            WTHR = wTHR;
    }
    public double getPERCI() {
            return PERCI;
    }
    public void setPERCI(double p) {
            PERCI= p;
    }

}
