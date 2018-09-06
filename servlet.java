package com.aem.mavencommunity.core.servlets;
import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
		"sling.servlet.resourceTypes=" + "sling/servlet/default", "sling.servlet.selectors=" + "demoselector",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,"sling.servlet.extensions=" + "json"
		 })
public class SimpleServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet 
{
	protected final Logger log = LoggerFactory.getLogger(SimpleServlet.class);
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServerException, IOException
	{
		response.setContentType("application/json");
		JSONObject jsonData = new JSONObject();
		try {
			jsonData.put("name", "abc");	
			jsonData.put("addr", "xyz");	
			jsonData.put("id", 123);	
			} 
		catch (JSONException e)
			{
			e.printStackTrace();
			}
		response.getWriter().write(jsonData.toString());
	}
}