package builder;


public class PolicyService {
    private int driverAge;
    private int numberOfAccidence;
    private int driverExperience;
    private int x;

    private PolicyService(Builder builder) {
        this.driverAge = builder.driverAge;
        this.numberOfAccidence = builder.numberOfAccidence;
        this.driverExperience = builder.driverExperience;
        this.x = builder.x;

    }

    @Override
    public String toString() {
        return "PolicyService{" +
                "driverAge=" + driverAge +
                ", numberOfAccidence=" + numberOfAccidence +
                ", driverExperience=" + driverExperience +
                ", x=" + x +
                '}';
    }

    public static class Builder {
        private int driverAge;
        private int numberOfAccidence;
        private int driverExperience;
        private int x;


        public Builder(int driverAge) {
            this.driverAge = driverAge;
        }

        public Builder numberOfAccidence(int numberOfAccidence) {
            this.numberOfAccidence = numberOfAccidence;
            return this;
        }

        public Builder driverExperience(int driverExperience) {
            this.driverExperience = driverExperience;
            return this;
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public PolicyService build() {
            //TODO validation, should be given ...
            if (driverAge <= 0 || driverAge > 100 ||
                    numberOfAccidence < 0 || driverExperience < 0
                    || x <= 0) {
                throw new IllegalArgumentException("Validation Error");
            }
            return new PolicyService(this);
        }
    }

    public static void main(String[] args) {
        //Test 1 - normal case
        PolicyService ps1;
        ps1 = new Builder(30).driverExperience(4).numberOfAccidence(3).x(9).build();
        System.out.println(ps1);

        //Test 2 - missing a parameter, can be zero
        PolicyService ps2 = new Builder(30).numberOfAccidence(3).x(9).build();
        System.out.println(ps2);

        //Test 3 - wrong age parameter
        PolicyService ps3 = new Builder(0).numberOfAccidence(3).x(9).build();
        System.out.println(ps3);


        //can make same like this class using lombok.
        //it is better to make the locals Integers instead of int, then can check nullity if missing arguments
    }
}
