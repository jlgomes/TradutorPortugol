/* Generated by JTB 1.4.7 */
package Telas.visitor;

import Telas.syntaxtree.*;

public interface IVoidVisitor {

  public void visit(final NodeChoice n);

  public void visit(final NodeList n);

  public void visit(final NodeListOptional n);

  public void visit(final NodeOptional n);

  public void visit(final NodeSequence n);

  public void visit(final NodeTCF n);

  public void visit(final NodeToken n);

  public void visit(final Start n);

  public void visit(final Programa n);

  public void visit(final Declaracao n);

  public void visit(final GlobalDeclaracao n);

  public void visit(final GDecl n);

  public void visit(final DefTipo n);

  public void visit(final TipoEspecificador n);

  public void visit(final VarDeclaracao n);

  public void visit(final VarDeclaracaoI n);

  public void visit(final VarListaNum n);

  public void visit(final VNum n);

  public void visit(final VarItemNum n);

  public void visit(final VarItemVetor n);

  public void visit(final VarComplemento n);

  public void visit(final FunDeclaracao n);

  public void visit(final Params n);

  public void visit(final ParamLista n);

  public void visit(final PParam n);

  public void visit(final Param n);

  public void visit(final ParamI n);

  public void visit(final ParamIVetor n);

  public void visit(final CompostoDecl n);

  public void visit(final LocalDeclaracoes n);

  public void visit(final CorpoDeclLista n);

  public void visit(final CLista n);

  public void visit(final Corpo n);

  public void visit(final ExpressaoDecl n);

  public void visit(final SelecaoDecl n);

  public void visit(final SelecaoDeclI n);

  public void visit(final SelecaoDeclII n);

  public void visit(final SelecaoDeclIII n);

  public void visit(final IteracaoDecl n);

  public void visit(final IteracaoDeclI n);

  public void visit(final RetornoDecl n);

  public void visit(final RetornoDeclI n);

  public void visit(final EntradaSaidaDecl n);

  public void visit(final Lendo n);

  public void visit(final VarLerNum n);

  public void visit(final VLerNum n);

  public void visit(final VarItemLerNum n);

  public void visit(final VarLerVetor n);

  public void visit(final Escrevendo n);

  public void visit(final EscrevendoRec n);

  public void visit(final EscreveItem n);

  public void visit(final EscolhaDecl n);

  public void visit(final EscolhaCaso n);

  public void visit(final EscolhaRec n);

  public void visit(final EscCaso n);

  public void visit(final EscolhaExcessao n);

  public void visit(final Expressao n);

  public void visit(final CondicaoDecl n);

  public void visit(final Valor n);

  public void visit(final ExpressaoRelacional n);

  public void visit(final SimplesEpressao n);

  public void visit(final Relacional n);

  public void visit(final Logico n);

  public void visit(final SomaExpressao n);

  public void visit(final SomaExpressaoI n);

  public void visit(final Soma n);

  public void visit(final Termo n);

  public void visit(final TermoI n);

  public void visit(final Mult n);

  public void visit(final Fator n);

  public void visit(final VarAtivacao n);

  public void visit(final Var n);

  public void visit(final Ativacao n);

  public void visit(final Args n);

  public void visit(final ArgLista n);

  public void visit(final ArgListaRec n);

}
