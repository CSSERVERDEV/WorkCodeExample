import org.junit.Test;

import java.util.List;


/**
 * 测试链接
 * @author lilonghua
 * @date: 2017年6月22日
 */
public class TestOne {

    @Test
    public void test1(){
        IChapterInterImpl  ChapterInterImpl = new IChapterInterImpl();
        List<Chapter> chapterList = ChapterInterImpl.getChapter("http://www.biquge.tw/0_5/");
        for (Chapter chapter : chapterList) {
            System.out.println(chapter);
        }
    }
}

