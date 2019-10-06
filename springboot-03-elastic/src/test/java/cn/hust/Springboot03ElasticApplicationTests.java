package cn.hust;

import cn.hust.elastic.bean.Article;
import cn.hust.elastic.bean.Book;
import cn.hust.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {


	@Autowired
	JestClient jestClient;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void test(){
		/*Book book = new Book();
		book.setId(1);
		book.setBookName("lalal");
		book.setAuthor("gaa");
		bookRepository.index(book);*/
		for (Book book : bookRepository.findByBookNameLike("l")) {
			System.out.println(book);
			
		}

	}

	@Test
	public void contextLoads() {
		Article article = new Article();
		article.setId(1);
		article.setTitle("title");
		article.setAuthor("xiaoya");
		article.setContent("content");
		Index index = new Index.Builder(article).index("hust").type("news").build();
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void search(){
		//查询表达式
		String json = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"content\" : \"Hello\"\n" +
				"        }\n" +
				"    }\n" +
				"}";
		//构建搜索操作
		Search search = new Search.Builder(json).addIndex("hust").addType("news").build();

		//执行
		try {
			SearchResult result = jestClient.execute(search);
			System.out.println(result.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
