package com.lwb;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class SearchIndex {
    private IndexReader indexReader;
    private IndexSearcher indexSearcher;

    public SearchIndex() throws IOException {
        indexReader = DirectoryReader.open(FSDirectory.open(new File("C:\\temp\\index").toPath()));
        indexSearcher = new IndexSearcher(indexReader);
    }

    @Test
    public void testRangeQuery() throws Exception {
        //创建一个Query对象
        Query query = LongPoint.newRangeQuery("size", 0l, 100l);
        printResult(query);
    }


    private void printResult(Query query) throws Exception {
        //执行查询
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("总记录数：" + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc doc:scoreDocs){
            //取文档id
            int docId = doc.doc;
            //根据id取文档对象
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
            //System.out.println(document.get("content"));
            System.out.println("-----------------寂寞的分割线");
        }
        indexReader.close();
    }


    @Test
    /**
     * 对查询的内容先分词，在对分的词进行查询
     */
    public void testQueryParser() throws Exception {
        //创建一个QueryPaser对象，两个参数
        QueryParser queryParser = new QueryParser("name", new IKAnalyzer());
        //参数1：默认搜索域，参数2：分析器对象
        //使用QueryPaser对象创建一个Query对象
        Query query = queryParser.parse("lucene是一个Java开发的全文检索工具包");
        //执行查询
        printResult(query);
    }

}
