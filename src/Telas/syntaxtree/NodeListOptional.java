/* Generated by JTB 1.4.7 */
package Telas.syntaxtree;

import Telas.visitor.IRetArguVisitor;
import Telas.visitor.IRetVisitor;
import Telas.visitor.IVoidArguVisitor;
import Telas.visitor.IVoidVisitor;
import java.util.*;

public class NodeListOptional implements INodeList {

  public ArrayList<INode> nodes;

  private static final int allocTb[] = {0, 1, 2, 3, 4, 5, 10, 20, 50};

  private int allocNb = 0;

  private static final long serialVersionUID = 147L;

  public NodeListOptional() {
    nodes = new ArrayList<INode>(allocTb[allocNb]);
  }

  public NodeListOptional(final int sz) {
    nodes = new ArrayList<INode>(sz);
  }

  public NodeListOptional(final INode firstNode) {
    nodes = new ArrayList<INode>(allocTb[allocNb]);
    addNode(firstNode);
  }

  public NodeListOptional(final int sz, final INode firstNode) {
    nodes = new ArrayList<INode>(sz);
    addNode(firstNode);
  }

  public void addNode(final INode n) {
    if (++allocNb < allocTb.length)
      nodes.ensureCapacity(allocTb[allocNb]);
    else
      nodes.ensureCapacity((allocNb - allocTb.length + 2) * allocTb[(allocTb.length - 1)]);
    nodes.add(n);
  }

  public INode elementAt(final int i) {
    return nodes.get(i); }

  public Iterator<INode> elements() {
    return nodes.iterator(); }

  public int size() {
    return nodes.size(); }

  public boolean present() {
    return (nodes.size() != 0); }

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
