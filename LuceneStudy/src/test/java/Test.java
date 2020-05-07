import com.lwb.IndexManager;
import com.lwb.LuceneFirst;

import java.io.IOException;

public class Test {

    LuceneFirst luceneFirst = new LuceneFirst();
    IndexManager indexManager = new IndexManager();


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


    @org.junit.Test
    public void testAddDoc() throws IOException {
        indexManager.addDocument();
        luceneFirst.searchIndex();
    }

    @org.junit.Test
    public void testDelAll() throws IOException {
        indexManager.deletAll();
    }

    @org.junit.Test
    public void testDelByQuerey() throws IOException {
        indexManager.deletByQuery();
    }
   @org.junit.Test
    public void testupdateDocument() throws Exception {
        indexManager.updateDocument();
    }


}
