package Models.Utils;

public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "Male";
        }
    },
    FEMALE {
        @Override
        public String toString() {
            return "Female";
        }
    },
    OTHER {
        @Override
        public String toString() {
            return "Other";
        }
    };
}
