package pl.vojteu.furniturefactory.others;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Resource implements AutoCloseable{

        private String name;
        private final static Logger LOGGER = LogManager.getLogger(Resource.class);

        public Resource(String name) {
            this.name = name;
            LOGGER.info("Resource " + name + " has been opened.");
        }

        public void doWork() {
            LOGGER.info("Resource " + name + " is being used.");
        }

        @Override
        public void close() throws Exception {
            LOGGER.info("Resource " + name + " has been closed.");
        }
}
