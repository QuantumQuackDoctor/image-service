package com.database.ormlibrary;

import javax.persistence.Embeddable;

@Embeddable
public class HoursEmbeddable {
    private String MON; // start,end
    private String TUE;
    private String WED;
    private String THU;
    private String FRI;
    private String SAT;
    private String SUN;

    public String getMON() {
        return MON;
    }

    public void setMON(String MON) {
        this.MON = MON;
    }

    public String getTUE() {
        return TUE;
    }

    public void setTUE(String TUE) {
        this.TUE = TUE;
    }

    public String getWED() {
        return WED;
    }

    public void setWED(String WED) {
        this.WED = WED;
    }

    public String getTHU() {
        return THU;
    }

    public void setTHU(String THU) {
        this.THU = THU;
    }

    public String getFRI() {
        return FRI;
    }

    public void setFRI(String FRI) {
        this.FRI = FRI;
    }

    public String getSAT() {
        return SAT;
    }

    public void setSAT(String SAT) {
        this.SAT = SAT;
    }

    public String getSUN() {
        return SUN;
    }

    public void setSUN(String SUN) {
        this.SUN = SUN;
    }
}
