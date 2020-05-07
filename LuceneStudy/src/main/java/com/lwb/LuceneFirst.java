package com.lwb;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class LuceneFirst {

    private IndexWriter indexWriter;

    /**
     * 创建索引
     * @throws IOException
     */
    public void createIndex() throws IOException {

            //指定索引库存放的路径
            //D:\temp\index
//            Directory directory = FSDirectory.open(new File("c:\\temp\\index").toPath());
            // 基于directory对象创建indexwriter对象
//            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new IKAnalyzer());
            indexWriter = new IndexManager().getIndexWriter();
        //读取磁盘上的文件，对应每个文件创建一个文档对象
        File dir = new File("D:\\学习资料\\10 Lucene\\87.lucene\\lucene\\02.参考资料\\searchsource");
        File[] files = dir.listFiles();
        for(File f : files){
            //取文件名
            String filename = f.getName();
            //获取文件路径
            String filePath = f.getPath();
            //文件内容
            String fileContent = null;
            fileContent = FileUtils.readFileToString(f, "utf-8");

            //文件的大小
            long fileSize = FileUtils.sizeOf(f);
            //创建field
            //参数1：域的名称，参数2：域的内容，参数3：是否存储
            Field fieldName = new TextField("name",filename,Field.Store.YES);
            //Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            Field fieldPath = new StoredField("path",filePath);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
            //Field fieldSize = new TextField("size", fileSize + "", Field.Store.YES);
            Field fieldSizeValue = new LongPoint("size",  fileSize);
            Field fieldSizeStore = new StoredField("size", fileSize);
            //创建文档对象
            Document document = new Document();
            //向文档对象中添加域
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            //document.add(fieldSize);
            document.add(fieldSizeValue);
            document.add(fieldSizeStore);
            //5、把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        //6、关闭indexwriter对象
        indexWriter.close();
    }


    /**
     * 查询索引
     */
    public void searchIndex() throws IOException {
        //1、创建一个Director对象，指定索引库的位置
        Directory directory = FSDirectory.open(new File("c:\\temp\\index").toPath());
        //2、创建一个IndexReader对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //3、创建一个IndexSearcher对象，构造方法中的参数indexReader对象。
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //4、创建一个Query对象，TermQuery
        Query query = new TermQuery(new Term("name", "spring"));
        //5、执行查询，得到一个TopDocs对象
        //参数1：查询对象 参数2：查询结果返回的最大记录数
        TopDocs topDocs = indexSearcher.search(query, 10);
        //6、取查询结果的总记录数
        System.out.println("查询总记录数：" + topDocs.totalHits);
        //7、取文档列表
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        //8、打印文档中的内容
        for (ScoreDoc doc :
                scoreDocs) {
            //取文档id
            int docId = doc.doc;
            //根据id取文档对象
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
//            System.out.println(document.get("content"));
            System.out.println("-----------------寂寞的分割线");
        }
        //9、关闭IndexReader对象
        indexReader.close();


    }

    public void getTokenStream() throws Exception {
        //1）创建一个Analyzer对象，StandardAnalyzer对象
//        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer();
//        2）使用分析器对象的tokenStream方法获得一个TokenStream对象
        TokenStream tokenStream = analyzer.tokenStream("", "2017年12月14日 - 传智播客Lucene概述公安局Lucene是一款高性能的、可扩展的信息检索(IR)工具库。信息检索是指文档搜索、文档内信息搜索或者文档相关的元数据搜索等操作。");
//        TokenStream tokenStream = analyzer.tokenStream("", "Learn how to create a web page with Spring MVC.");
//        3）向TokenStream对象中设置一个引用，相当于数一个指针
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        //4）调用TokenStream对象的rest方法。如果不调用抛异常
        tokenStream.reset();
        //5）使用while循环遍历TokenStream对象
        while(tokenStream.incrementToken()) {
            System.out.println(charTermAttribute.toString());
        }
        //6）关闭TokenStream对象
        tokenStream.close();
    }


}
