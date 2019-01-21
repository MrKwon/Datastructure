package michael.dsalgo.Chapter07.BinaryTree.EulerTour;

import michael.dsalgo.Chapter07.BinaryTree.BinaryTree;
import michael.dsalgo.Chapter07.BinaryTree.EulerTour.Expressions.*;
import michael.dsalgo.Chapter07.BinaryTree.Position;

public class PrintExpressionTour extends EulerTour<ExpressionTerm, String> {
    public String execute(BinaryTree<ExpressionTerm> T) {
        init(T);
        System.out.print("Expression : ");
        eulerTour(T.root());
        System.out.println();
        return null;
    }

    @Override
    protected void visitLeft(Position<ExpressionTerm> v, TourResult<String> r) {
        if (tree.isInternal(v)) System.out.println("(");
    }

    @Override
    protected void visitBelow(Position<ExpressionTerm> v, TourResult<String> r) {
        System.out.print(v.element());
    }

    @Override
    protected void visitRight(Position<ExpressionTerm> v, TourResult<String> r) {
        if (tree.isInternal(v)) System.out.println(")");
    }
}
