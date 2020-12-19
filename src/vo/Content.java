package vo;

public class Content {
    private String tid;
    private String sid;
    private String sname;
    private String slink;

    public Content() {
        super();
    }

    public Content(String tid, String sid, String sname, String slink) {
        this.tid = tid;
        this.sid = sid;
        this.sname = sname;
        this.slink = slink;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSlink() {
        return slink;
    }

    public void setSlink(String slink) {
        this.slink = slink;
    }

    @Override
    public String toString() {
        return "Content{" +
                "tid='" + tid + '\'' +
                ", sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", slink='" + slink + '\'' +
                '}';
    }
}
