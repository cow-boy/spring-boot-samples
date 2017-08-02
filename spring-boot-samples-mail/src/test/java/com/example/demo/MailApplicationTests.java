package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MailService MailService;

	@Test
	public void testSimpleMail() throws Exception {
		MailService.sendSimpleMail("cow-boy@foxmail.com","test simple mail"," hello this is simple mail");
	}

	@Test
	public void testHtmlMail() throws Exception {
		String content="<html>\n" +
				"<body>\n" +
				"    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
				"</body>\n" +
				"</html>";
		MailService.sendHtmlMail("cow-boy@foxmail.com","test simple mail",content);
	}

	@Test
	public void sendAttachmentsMail() {
		String filePath="E:\\MainFrame.java";
		MailService.sendAttachmentsMail("cow-boy@foxmail.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}

	@Test
	public void sendInlineResourceMail() {
		String rscId = "11";
		String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "C:\\Users\\huxu\\Desktop\\11.png";
		MailService.sendInlineResourceMail("cow-boy@foxmail.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}

	@Test
	public void sendTemplateMail() {
		Context context = new Context();
		context.setVariable("type", "register");
		context.setVariable("name", "my friend");
		String template = "emailTemplate";
		MailService.sendTemplateMail("cow-boy@foxmail.com","主题：这是模板邮件", context, template);
	}

}
