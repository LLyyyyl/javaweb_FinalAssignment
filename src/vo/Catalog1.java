package vo;

public class Catalog1 {
    private String catalog1Id;
    private String catalog1Name;

    public Catalog1() {
        super();
    }

    public Catalog1(String catalog1Id, String catalog1Name) {
        this.catalog1Id = catalog1Id;
        this.catalog1Name = catalog1Name;
    }

    public String getCatalog1Id() {
        return catalog1Id;
    }

    public void setCatalog1Id(String catalog1Id) {
        this.catalog1Id = catalog1Id;
    }

    public String getCatalog1Name() {
        return catalog1Name;
    }

    public void setCatalog1Name(String catalog1Name) {
        this.catalog1Name = catalog1Name;
    }

    @Override
    public String toString() {
        return "Catalog1{" +
                "catalog1Id='" + catalog1Id + '\'' +
                ", catalog1Name='" + catalog1Name + '\'' +
                '}';
    }
}
