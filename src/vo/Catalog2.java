package vo;

public class Catalog2 {
    private String catalog1Id;
    private String catalog2Id;
    private String catalog2Name;

    public Catalog2() {
        super();
    }

    public Catalog2(String catalog1Id, String catalog2Id, String catalog2Name) {
        this.catalog1Id = catalog1Id;
        this.catalog2Id = catalog2Id;
        this.catalog2Name = catalog2Name;
    }

    public String getCatalog1Id() {
        return catalog1Id;
    }

    public void setCatalog1Id(String catalog1Id) {
        this.catalog1Id = catalog1Id;
    }

    public String getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(String catalog2Id) {
        this.catalog2Id = catalog2Id;
    }

    public String getCatalog2Name() {
        return catalog2Name;
    }

    public void setCatalog2Name(String catalog2Name) {
        this.catalog2Name = catalog2Name;
    }

    @Override
    public String toString() {
        return "Catalog2{" +
                "catalog1Id='" + catalog1Id + '\'' +
                ", catalog2Id='" + catalog2Id + '\'' +
                ", catalog2Name='" + catalog2Name + '\'' +
                '}';
    }
}
