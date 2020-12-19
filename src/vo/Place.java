package vo;

public class Place {
    private String placeId;
    private String palceName;

    public Place() {
        super();
    }

    public Place(String placeId, String palceName) {
        this.placeId = placeId;
        this.palceName = palceName;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPalceName() {
        return palceName;
    }

    public void setPalceName(String palceName) {
        this.palceName = palceName;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId='" + placeId + '\'' +
                ", palceName='" + palceName + '\'' +
                '}';
    }
}
