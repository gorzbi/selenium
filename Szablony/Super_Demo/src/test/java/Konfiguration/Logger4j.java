package Konfiguration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logger4j {

    private Logger logger = LogManager.getLogger(this.getClass().getName());
    protected Logger log() {
        return logger;
    }

}
