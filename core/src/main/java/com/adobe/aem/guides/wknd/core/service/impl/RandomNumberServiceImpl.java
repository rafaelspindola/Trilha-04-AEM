package com.adobe.aem.guides.wknd.core.service.impl;

import com.adobe.aem.guides.wknd.core.service.RamdomNumberService;
import org.osgi.service.component.annotations.Component;

@Component(service = {RandomNumberServiceImpl.class}, immediate = true)
public class RandomNumberServiceImpl implements RamdomNumberService {

    public int generateRandomNumber() {
        return (int) (Math.random () * 100);
    }

}
