package com.adobe.aem.guides.wknd.core.servlet;

import com.adobe.aem.guides.wknd.core.service.RamdomNumberService;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/random-number",
                "sling.servlet.selectors=" + "json"})
public class RandomNumberServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger (RandomNumberServlet.class);

    @Reference
    private RamdomNumberService ramdomNumberService;

    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {
        JSONObject responseObject = new JSONObject();

        try {
            int randomNumber = ramdomNumberService.generateRandomNumber ();
            responseObject.put("randomNumber", randomNumber);

            resp.setContentType("application/json");
            resp.getWriter().write(responseObject.toString());
        } catch (Exception e) {
            log.error("Error generating random number: {}", e.getMessage());
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating random number");
        }
    }

}

