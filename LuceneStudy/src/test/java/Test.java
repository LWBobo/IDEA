import com.lwb.LuceneFirst;

import java.io.IOException;

public class Test {

    LuceneFirst luceneFirst = new LuceneFirst();


    @org.junit.Test
    public  void testCreateIndex() throws IOException {
        luceneFirst.createIndex();
    }

    @org.junit.Test
    public void testReadIndex() throws IOException {
        luceneFirst.searchIndex();
    }


    @org.junit.Test
    public void testTokenStream() throws Exception {
        luceneFirst.getTokenStream();
    }
}
