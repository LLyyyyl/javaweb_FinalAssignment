package vo;

public class Goods {
    private String ChineseName;
    private String huohao;
    private String barCode;
    private String place;
    private String unit;
    private String catalog1;
    private String catalog2;

    public Goods() {
        super();
    }

    public Goods(String chineseName, String huohao, String barCode, String place, String unit, String catalog1, String catalog2) {
        ChineseName = chineseName;
        this.huohao = huohao;
        this.barCode = barCode;
        this.place = place;
        this.unit = unit;
        this.catalog1 = catalog1;
        this.catalog2 = catalog2;
    }

    public String getChineseName() {
        return ChineseName;
    }

    public void setChineseName(String chineseName) {
        ChineseName = chineseName;
    }

    public String getHuohao() {
        return huohao;
    }

    public void setHuohao(String huohao) {
        this.huohao = huohao;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCatalog1() {
        return catalog1;
    }

    public void setCatalog1(String catalog1) {
        this.catalog1 = catalog1;
    }

    public String getCatalog2() {
        return catalog2;
    }

    public void setCatalog2(String catalog2) {
        this.catalog2 = catalog2;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "ChineseName='" + ChineseName + '\'' +
                ", huohao='" + huohao + '\'' +
                ", barCode='" + barCode + '\'' +
                ", place='" + place + '\'' +
                ", unit='" + unit + '\'' +
                ", catalog1='" + catalog1 + '\'' +
                ", catalog2='" + catalog2 + '\'' +
                '}';
    }
}
