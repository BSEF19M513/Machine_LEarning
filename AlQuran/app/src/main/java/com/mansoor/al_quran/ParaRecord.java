package com.noman.al_quran;

public class ParaRecord {
    int ParaID;
    int AyaID;
    String ArabicText;
    String UrduTranslation1;
    String UrduTranslation2;
    String EnglishTranslation1;
    String EnglishTranslation2;

    public ParaRecord(int paraID, int ayaID, String arabicText, String urduTranslation1, String urduTranslation2, String englishTranslation1, String englishTranslation2) {
        ParaID = paraID;
        AyaID = ayaID;
        ArabicText = arabicText;
        UrduTranslation1 = urduTranslation1;
        UrduTranslation2 = urduTranslation2;
        EnglishTranslation1 = englishTranslation1;
        EnglishTranslation2 = englishTranslation2;
    }

    public int getParaID() {
        return ParaID;
    }

    public void setParaID(int paraID) {
        ParaID = paraID;
    }

    public int getAyaID() {
        return AyaID;
    }

    public void setAyaID(int ayaID) {
        AyaID = ayaID;
    }

    public String getArabicText() {
        return ArabicText;
    }

    public void setArabicText(String arabicText) {
        ArabicText = arabicText;
    }

    public String getUrduTranslation1() {
        return UrduTranslation1;
    }

    public void setUrduTranslation1(String urduTranslation1) {
        UrduTranslation1 = urduTranslation1;
    }

    public String getUrduTranslation2() {
        return UrduTranslation2;
    }

    public void setUrduTranslation2(String urduTranslation2) {
        UrduTranslation2 = urduTranslation2;
    }

    public String getEnglishTranslation1() {
        return EnglishTranslation1;
    }

    public void setEnglishTranslation1(String englishTranslation1) {
        EnglishTranslation1 = englishTranslation1;
    }

    public String getEnglishTranslation2() {
        return EnglishTranslation2;
    }

    public void setEnglishTranslation2(String englishTranslation2) {
        EnglishTranslation2 = englishTranslation2;
    }
}
