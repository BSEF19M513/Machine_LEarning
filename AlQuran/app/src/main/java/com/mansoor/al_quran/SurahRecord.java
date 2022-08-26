package com.noman.al_quran;

public class SurahRecord {
    int SurahID;
    String SurahIntro;
    String SurahNameE;
    String SurahNameU;
    String Nazool;

    public SurahRecord(int surahID, String surahIntro, String surahNameE, String surahNameU, String nazool) {
        SurahID = surahID;
        SurahIntro = surahIntro;
        SurahNameE = surahNameE;
        SurahNameU = surahNameU;
        Nazool = nazool;
    }

    public SurahRecord() {
        SurahID = -1;
        SurahIntro = "";
        SurahNameE = "";
        SurahNameU = "";
        Nazool = "";
    }

    public int getSurahID() {
        return SurahID;
    }

    public void setSurahID(int surahID) {
        SurahID = surahID;
    }

    public String getSurahIntro() {
        return SurahIntro;
    }

    public void setSurahIntro(String surahIntro) {
        SurahIntro = surahIntro;
    }

    public String getSurahNameE() {
        return SurahNameE;
    }

    public void setSurahNameE(String surahNameE) {
        SurahNameE = surahNameE;
    }

    public String getSurahNameU() {
        return SurahNameU;
    }

    public void setSurahNameU(String surahNameU) {
        SurahNameU = surahNameU;
    }

    public String getNazool() {
        return Nazool;
    }

    public void setNazool(String nazool) {
        Nazool = nazool;
    }
}
