/* Generated by JTB 1.4.7 */
package Telas.syntaxtree;

import Telas.visitor.*;

public class SomaExpressao implements INode {

  public Termo f0;

  public NodeListOptional f1;

  private static final long serialVersionUID = 147L;

  public SomaExpressao(final Termo n0, final NodeListOptional n1) {
    f0 = n0;
    f1 = n1;
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
