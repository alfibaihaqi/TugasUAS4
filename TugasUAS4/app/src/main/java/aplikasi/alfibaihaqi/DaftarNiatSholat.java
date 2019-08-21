package aplikasi.alfibaihaqi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaftarNiatSholat {

    @Expose
    @SerializedName("tittle")
    private String tittle;

    @Expose
    @SerializedName("instruction")
    private String instruction;

    @Expose
    @SerializedName("arabDesc")
    private String arabDesc;

    @Expose
    @SerializedName("latinDesc")
    private String latinDesc;

    public DaftarNiatSholat(String tittle, String instruction, String arabDesc, String latinDesc) {
        this.tittle = tittle;
        this.instruction = instruction;
        this.arabDesc = arabDesc;
        this.latinDesc = latinDesc;
    }
    public String getTittle(){return tittle;}
    public void setTittle(String tittle) {this.tittle = tittle;}
    public String getInstruction() {return instruction;}
    public void setInstruction(String instruction) {this.instruction = instruction;}
    public String getArabDesc() {return arabDesc;}
    public void setArabDesc(String arabDesc) {this.arabDesc = arabDesc;}
    public String getLatinDesc() {return latinDesc;}
    public void setLatinDesc(String latinDesc) {this.latinDesc = latinDesc;}


}
