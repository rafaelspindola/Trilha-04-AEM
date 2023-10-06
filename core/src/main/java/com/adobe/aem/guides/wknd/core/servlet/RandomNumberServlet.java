package com.adobe.aem.guides.wknd.core.servlet;

import com.adobe.aem.guides.wknd.core.service.RamdomNumberService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = {Servlet.class}, property = {
        "sling.servlet.paths=/bin/random-number",
        "sling.methods=GET"
})
public class RandomNumberServlet extends SlingSafeMethodsServlet {

    @Reference
    private RamdomNumberService ramdomNumberService;

    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp)
            throws ServletException, IOException {

        int randomNumber = ramdomNumberService.generateRandomNumber ();

        String jsonResponse = "{\"randomNumber\":" + randomNumber + "}";

        resp.setContentType ("application/json");

        resp.getWriter ().write (jsonResponse);
    }
}
