package com.adobe.aem.guides.wknd.core.service;

import org.osgi.service.component.annotations.Component;

@Component(service = {RandomNumberService.class}, immediate = true)
public class RandomNumberService {

    public int generateRandomNumber() {
        return (int) (Math.random () * 100);
    }

}
