package michael.dsalgo.Chapter07.BinaryTree.EulerTour;

public class Expressions {
    public class ExpressionTerm {
        public Integer getValue() {
            return 0;
        }

        public String toString() {
            return new String("");
        }
    }

    public class ExpressionVariable extends ExpressionTerm {
        protected Integer var;

        public ExpressionVariable(Integer var) {
            this.var = var;
        }

        public Integer getVar() {
            return var;
        }

        public void setVar(Integer var) {
            this.var = var;
        }

        @Override
        public String toString() {
            return var.toString();
        }
    }

    public class ExpressionOperator extends ExpressionTerm {
        protected Integer firstOperand, secondOperand;

        public void setOperands(Integer x, Integer y) {
            firstOperand = x;
            secondOperand = y;
        }
    }

    public class AdditionOperator extends ExpressionOperator {
        @Override
        public Integer getValue() {
            return (firstOperand + secondOperand);
        }

        @Override
        public String toString() {
            return new String("+");
        }
    }
}