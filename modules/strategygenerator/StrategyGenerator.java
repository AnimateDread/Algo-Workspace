package modules.strategygenerator;

public class StrategyGenerator {
    public static ModuleInfos getModuleInfos() {
        return new ModuleInfos("Strategy Generator", "1.0", "Generates strategic plans", "John Doe");
    }

    public static class ModuleInfos {
        private String name;
        private String version;
        private String description;
        private String developer;

        public ModuleInfos(String name, String version, String description, String developer) {
            this.name = name;
            this.version = version;
            this.description = description;
            this.developer = developer;
        }

        public String getName() {
            return name;
        }

        public String getVersion() {
            return version;
        }

        public String getDescription() {
            return description;
        }

        public String getDeveloper() {
            return developer;
        }
    }
}
