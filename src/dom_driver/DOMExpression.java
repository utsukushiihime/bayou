package dom_driver;

import dsl.DSubTree;
import org.eclipse.jdt.core.dom.*;

public class DOMExpression implements Handler {

    final Expression expression;

    public DOMExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public DSubTree handle() {
        if (expression instanceof MethodInvocation)
            return new DOMMethodInvocation((MethodInvocation) expression).handle();
        if (expression instanceof ClassInstanceCreation)
            return new DOMClassInstanceCreation((ClassInstanceCreation) expression).handle();
        if (expression instanceof InfixExpression)
            return new DOMInfixExpression((InfixExpression) expression).handle();
        if (expression instanceof ConditionalExpression)
            return new DOMConditionalExpression((ConditionalExpression) expression).handle();
        if (expression instanceof VariableDeclarationExpression)
            return new DOMVariableDeclarationExpression((VariableDeclarationExpression) expression).handle();
        if (expression instanceof Assignment)
            return new DOMAssignment((Assignment) expression).handle();
        if (expression instanceof ParenthesizedExpression)
            return new DOMParenthesizedExpression((ParenthesizedExpression) expression).handle();

        return new DSubTree();
    }
}
