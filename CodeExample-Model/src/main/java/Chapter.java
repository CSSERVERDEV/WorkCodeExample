import java.io.Serializable;

/**
 * 小说章节实体类
 * @author lilonghua
 * @date: 2017年6月22日
 */
public class Chapter implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;//小说章节
    private String url;//章节链接
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "Chapter [title=" + title + ", url=" + url + "]";
    }
}
