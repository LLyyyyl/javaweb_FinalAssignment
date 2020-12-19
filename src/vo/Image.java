package vo;

public class Image {
    private String pid;
    private String path;

    public Image() {
        super();
    }

    public Image(String pid, String path) {
        this.pid = pid;
        this.path = path;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Image{" +
                "pid='" + pid + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
