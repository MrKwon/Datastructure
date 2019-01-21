package michael.dsalgo.Chapter07.BinaryTree.EulerTour;

import michael.dsalgo.Chapter07.BinaryTree.BinaryTree;
import michael.dsalgo.Chapter07.BinaryTree.EulerTour.Expressions.*;
import michael.dsalgo.Chapter07.BinaryTree.Position;

public class EvaluateExpressionTour extends EulerTour<ExpressionTerm, Integer> {
    public Integer execute(BinaryTree<ExpressionTerm> T) {
        init(T);
        return eulerTour(tree.root());
    }

    @Override
    protected void visitRight(Position<ExpressionTerm> v, TourResult<Integer> r) {
        ExpressionTerm term = v.element();
        if (tree.isInternal(v)) {
            ExpressionOperator op = (ExpressionOperator) term;
            op.setOperands(r.left, r.right);
        }
        r.out = term.getValue();
    }
}
