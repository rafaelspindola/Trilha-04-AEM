package com.adobe.aem.guides.wknd.core.service.impl;

import com.adobe.aem.guides.wknd.core.service.RamdomNumberService;
import org.apache.sling.api.resource.Resource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = {RandomNumberServiceImpl.class}, immediate = true)
public class RandomNumberServiceImpl implements RamdomNumberService {

    @Reference
    private Resource resource;

    public int generateRandomNumber() {
        return (int) (Math.random () * 100);
    }

}
