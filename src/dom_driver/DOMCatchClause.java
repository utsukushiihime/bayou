package dom_driver;

import dsl.DSubTree;
import org.eclipse.jdt.core.dom.CatchClause;

public class DOMCatchClause implements Handler {

    final CatchClause clause;

    public DOMCatchClause(CatchClause clause) {
        this.clause = clause;
    }

    @Override
    public DSubTree handle() {
        return new DOMBlock(clause.getBody()).handle();
    }
}
