/* Generated by JTB 1.4.7 */
package Telas.syntaxtree;

import Telas.visitor.*;

public class ParamI implements INode {

  public NodeToken f0;

  public NodeOptional f1;

  public NodeListOptional f2;

  public NodeToken f3;

  private static final long serialVersionUID = 147L;

  public ParamI(final NodeToken n0, final NodeOptional n1, final NodeListOptional n2, final NodeToken n3) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}
