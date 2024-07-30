public class BuilderPatternDemo {
    static class PC {
        private String processor;
        private String memory;
        private String disk;

        private PC(PCBuilder builder) {
            this.processor = builder.processor;
            this.memory = builder.memory;
            this.disk = builder.disk;
        }

        public static class PCBuilder {
            private String processor;
            private String memory;
            private String disk;

            public PCBuilder setProcessor(String processor) {
                this.processor = processor;
                return this;
            }

            public PCBuilder setMemory(String memory) {
                this.memory = memory;
                return this;
            }

            public PCBuilder setDisk(String disk) {
                this.disk = disk;
                return this;
            }

            public PC build() {
                return new PC(this);
            }
        }
    }

    public static void main(String[] args) {
        PC workstation = new PC.PCBuilder()
                .setProcessor("AMD Ryzen 9")
                .setMemory("64GB")
                .setDisk("2TB SSD")
                .build();

        System.out.println("Processor: " + workstation.processor);
        System.out.println("Memory: " + workstation.memory);
        System.out.println("Disk: " + workstation.disk);
    }
}
