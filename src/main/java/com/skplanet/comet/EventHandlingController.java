package com.skplanet.comet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventHandlingController {

	@ResponseBody
	@RequestMapping(value = "/polling", method = RequestMethod.GET)
	public String polling() {
		String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
		return formattedDate;
	}
	
	@ResponseBody
	@RequestMapping(value = "/piggyback", method = RequestMethod.GET)
	public String piggyback() {
		String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
		String results = "{" + 
				"\"formValid\":" + "true," + 
				"\"events\":" + "\"update\"," + 
				"\"content\":" + "\"" + formattedDate + "\"" + "}";
		return results;
	}
	
	@RequestMapping(value = "/iframe", method = RequestMethod.GET)
	public void iframe(HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.write("<script>parent.callback('iframe msg');</script>");
		writer.flush();
	}
	
	@RequestMapping(value = "/longpolling", method = RequestMethod.GET)
	public void longpolling(HttpServletResponse response, String callback) throws IOException, InterruptedException {
		PrintWriter writer = response.getWriter();
		Thread.sleep(5000);
		writer.write(callback + "('longpolling message');");
		writer.flush();
	}
	
	@RequestMapping(value = "/xhrstreaming", method = RequestMethod.GET)
	public void xhrstreaming(HttpServletResponse response) throws IOException, InterruptedException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/octet-stream");
		response.setHeader("Cache-Control", "no-cache");
				
		for (int i = 10 ; i < 100; i += 10) {
			writer.write(i + "% done!<br>");
			writer.flush();
			Thread.sleep(500);
		}
	}
	
}
