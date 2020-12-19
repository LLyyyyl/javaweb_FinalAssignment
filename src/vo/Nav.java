package vo;

public class Nav {//一级导航栏
    private String tid;
    private String tname;
    private String tlink;//链接
    private String trole;//权限

    public Nav() {
        super();
    }

    public Nav(String tid, String tname, String tlink, String trole) {
        this.tid = tid;
        this.tname = tname;
        this.tlink = tlink;
        this.trole = trole;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTlink() {
        return tlink;
    }

    public void setTlink(String tlink) {
        this.tlink = tlink;
    }

    public String getTrole() {
        return trole;
    }

    public void setTrole(String trole) {
        this.trole = trole;
    }

    @Override
    public String toString() {
        return "Nav{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tlink='" + tlink + '\'' +
                ", trole='" + trole + '\'' +
                '}';
    }
}
