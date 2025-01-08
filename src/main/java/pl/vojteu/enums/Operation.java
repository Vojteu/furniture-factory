package pl.vojteu.enums;

public enum Operation {

    ADDITION {
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACTION {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICATION {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVISION {
        @Override
        public double apply(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        }
    };

    public abstract double apply(double a, double b);
}