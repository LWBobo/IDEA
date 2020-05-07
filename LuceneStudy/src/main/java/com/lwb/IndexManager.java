package com.lwb;


import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * 索引库的维护
 */
public class IndexManager {
    public static IndexWriter indexWriter;

    public IndexWriter getIndexWriter() {
        return indexWriter;
    }

    public IndexManager(){
        //创建一个IndexWriter对象，需要使用IKanalyzar作为分析器
        try {
            if (indexWriter == null){    //indexWriter对同一个索引目录的对象，只能存在一个
                indexWriter = new IndexWriter(FSDirectory.open(new File("c:\\temp\\index").toPath()),
                        new IndexWriterConfig(new IKAnalyzer()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDocument() throws IOException {

        //创建一个Document对象
        Document document = new Document();
        //向document对象中添加域
        document.add(new TextField("name", "新添加的文件", Field.Store.YES));
        document.add(new TextField("content", "新添加的文件内容", Field.Store.NO));
        document.add(new StoredField("path", "c:/temp/helo"));
        // 把文档写入索引库
        indexWriter.addDocument(document);
        //关闭索引库
        indexWriter.close();
    }


    public void deletAll() throws IOException {
        indexWriter.deleteAll();
        indexWriter.close();
    }

    /**
     * 删除指定名称的索引文件
     * @throws IOException
     */
    public void deletByQuery() throws IOException {
        indexWriter.deleteDocuments(new Term("name","apache"));
        indexWriter.close();
    }


    /**
     * 更新文档
     * @throws Exception
     */
    public void updateDocument() throws Exception {
        //创建一个新的文档对象
        Document document = new Document();
        //向文档对象中添加域
        document.add(new TextField("name", "更新之后的文档", Field.Store.YES));
        document.add(new TextField("name1", "更新之后的文档2", Field.Store.YES));
        document.add(new TextField("name2", "更新之后的文档3", Field.Store.YES));
        //更新操作
        indexWriter.updateDocument(new Term("name", "spring"), document);
        //关闭索引库
        indexWriter.close();
    }


}
