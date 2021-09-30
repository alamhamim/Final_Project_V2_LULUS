package com.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class GetLogger {

    public static final Logger logger(Class name) {
        DOMConfigurator.configure("Test-Data/logger.xml");
        Logger log = Logger.getLogger(name);
        return log;
    }


}
