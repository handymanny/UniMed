package Models.Utils;

public enum Race {
    WHITE {
        @Override
        public String toString() {
            return "White";
        }
    },
    AFRICAN_AMERICAN {
        @Override
        public String toString() {
            return "African American";
        }
    },
    OTHER {
        @Override
        public String toString() {
            return "Other";
        }
    }
}
