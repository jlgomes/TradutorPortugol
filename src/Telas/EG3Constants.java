/* Generated By:JavaCC: Do not edit this line. EG3Constants.java */
package Telas;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface EG3Constants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int TIPO = 20;
  /** RegularExpression Id. */
  int inteiro = 21;
  /** RegularExpression Id. */
  int real = 22;
  /** RegularExpression Id. */
  int caractere = 23;
  /** RegularExpression Id. */
  int logico = 24;
  /** RegularExpression Id. */
  int INICIO_LITERAL = 25;
  /** RegularExpression Id. */
  int E = 26;
  /** RegularExpression Id. */
  int OU = 27;
  /** RegularExpression Id. */
  int NAO = 28;
  /** RegularExpression Id. */
  int FIM_LITERAL = 29;
  /** RegularExpression Id. */
  int STRING = 30;
  /** RegularExpression Id. */
  int Tipo = 31;
  /** RegularExpression Id. */
  int Registro = 32;
  /** RegularExpression Id. */
  int FimRegistro = 33;
  /** RegularExpression Id. */
  int Escolha = 34;
  /** RegularExpression Id. */
  int Caso = 35;
  /** RegularExpression Id. */
  int FimEscolha = 36;
  /** RegularExpression Id. */
  int Contrario = 37;
  /** RegularExpression Id. */
  int DIGITO = 38;
  /** RegularExpression Id. */
  int PONTO_FLUTUANTE = 39;
  /** RegularExpression Id. */
  int SE = 40;
  /** RegularExpression Id. */
  int DE = 41;
  /** RegularExpression Id. */
  int MODULO = 42;
  /** RegularExpression Id. */
  int MOD = 43;
  /** RegularExpression Id. */
  int ATE = 44;
  /** RegularExpression Id. */
  int DIV = 45;
  /** RegularExpression Id. */
  int FACA = 46;
  /** RegularExpression Id. */
  int PARA = 47;
  /** RegularExpression Id. */
  int LEIA = 48;
  /** RegularExpression Id. */
  int FIMSE = 49;
  /** RegularExpression Id. */
  int ENTAO = 50;
  /** RegularExpression Id. */
  int SENAO = 51;
  /** RegularExpression Id. */
  int PASSO = 52;
  /** RegularExpression Id. */
  int FALSO = 53;
  /** RegularExpression Id. */
  int REPITA = 54;
  /** RegularExpression Id. */
  int FIMPARA = 55;
  /** RegularExpression Id. */
  int ESCREVA = 56;
  /** RegularExpression Id. */
  int RETORNE = 57;
  /** RegularExpression Id. */
  int ENQUANTO = 58;
  /** RegularExpression Id. */
  int FIMMODULO = 59;
  /** RegularExpression Id. */
  int VERDADEIRO = 60;
  /** RegularExpression Id. */
  int FIMENQUANTO = 61;
  /** RegularExpression Id. */
  int FIMALGORITMO = 62;
  /** RegularExpression Id. */
  int VETOR = 63;
  /** RegularExpression Id. */
  int MATRIZ = 64;
  /** RegularExpression Id. */
  int IDENTIFIER = 65;
  /** RegularExpression Id. */
  int LETTER = 66;
  /** RegularExpression Id. */
  int DIGIT = 67;
  /** RegularExpression Id. */
  int VAR = 68;
  /** RegularExpression Id. */
  int APARENTESE = 69;
  /** RegularExpression Id. */
  int FPARENTESE = 70;
  /** RegularExpression Id. */
  int PONTOEVIRGULA = 71;
  /** RegularExpression Id. */
  int IGUAL = 72;
  /** RegularExpression Id. */
  int DOISPONTOS = 73;
  /** RegularExpression Id. */
  int VIRGULA = 74;
  /** RegularExpression Id. */
  int ACOLCHETE = 75;
  /** RegularExpression Id. */
  int FCOLCHETE = 76;
  /** RegularExpression Id. */
  int RECEBE = 77;
  /** RegularExpression Id. */
  int PONTOS = 78;
  /** RegularExpression Id. */
  int PONTO = 79;
  /** RegularExpression Id. */
  int MAIOR = 80;
  /** RegularExpression Id. */
  int MENOR = 81;
  /** RegularExpression Id. */
  int MAIORIGUAL = 82;
  /** RegularExpression Id. */
  int MENORIGUAL = 83;
  /** RegularExpression Id. */
  int DIFERENTE = 84;
  /** RegularExpression Id. */
  int MAIS = 85;
  /** RegularExpression Id. */
  int MENOS = 86;
  /** RegularExpression Id. */
  int MULTIPLICAR = 87;
  /** RegularExpression Id. */
  int DIVIDIR = 88;
  /** RegularExpression Id. */
  int Especiais = 89;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"!\"",
    "\"@\"",
    "\"$\"",
    "\"%\"",
    "\"\\u00e7\"",
    "\"&\"",
    "\"\\u00aa\"",
    "\"\\u00ba\"",
    "\"\\u00a7\"",
    "\"\\u00b4\"",
    "\"`\"",
    "\"^\"",
    "\"~\"",
    "\"#\"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<token of kind 19>",
    "<TIPO>",
    "\"inteiro\"",
    "\"real\"",
    "\"caractere\"",
    "\"logico\"",
    "\"inicio\"",
    "\"e\"",
    "\"ou\"",
    "\"nao\"",
    "\"fim\"",
    "<STRING>",
    "\"tipo\"",
    "\"registro\"",
    "\"fimregistro\"",
    "\"escolha\"",
    "\"caso\"",
    "\"fimescolha\"",
    "\"contrario\"",
    "<DIGITO>",
    "<PONTO_FLUTUANTE>",
    "\"se\"",
    "\"de\"",
    "\"modulo\"",
    "\"mod\"",
    "\"ate\"",
    "\"div\"",
    "\"faca\"",
    "\"para\"",
    "\"leia\"",
    "\"fimse\"",
    "\"entao\"",
    "\"senao\"",
    "\"passo\"",
    "\"falso\"",
    "\"repita\"",
    "\"fimpara\"",
    "\"escreva\"",
    "\"retorne\"",
    "\"enquanto\"",
    "\"fimmodulo\"",
    "\"verdadeiro\"",
    "\"fimenquanto\"",
    "\"fimalgoritmo\"",
    "\"vetor\"",
    "\"matriz\"",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
    "\"var:\"",
    "\"(\"",
    "\")\"",
    "\";\"",
    "\"=\"",
    "\":\"",
    "\",\"",
    "\"[\"",
    "\"]\"",
    "\"<-\"",
    "\"..\"",
    "\".\"",
    "\">\"",
    "\"<\"",
    "\">=\"",
    "\"<=\"",
    "\"<>\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "<Especiais>",
  };

}
