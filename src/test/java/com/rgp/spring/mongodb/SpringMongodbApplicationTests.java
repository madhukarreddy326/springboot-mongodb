package com.rgp.spring.mongodb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgp.spring.mongodb.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class SpringMongodbApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	ObjectMapper obj = new ObjectMapper();
	@Before
	private void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void addBookTest() throws Exception {
		Book book = new Book();
		book.setId(1322);
		book.setBookName("testBook");
		book.setAuthorName("testAuthor");
		String jsonRequest = obj.writeValueAsString(book);
		MvcResult result = mockMvc.perform(post("/book").content(jsonRequest)
				.content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		//Response response = obj.readValue(resultContent,)

	}

}
