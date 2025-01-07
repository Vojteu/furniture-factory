package pl.vojteu;

public class Resource implements AutoCloseable{
        private String name;

        public Resource(String name) {
            this.name = name;
            System.out.println("Resource " + name + " has been opened.");
        }

        public void doWork() {
            System.out.println("Resource " + name + " is being used.");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Resource " + name + " has been closed.");
        }
}
