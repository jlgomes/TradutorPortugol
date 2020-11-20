package Telas;

%%
%class Lexer
%integer
%%



^([\t]*)((ate)|(caso)|(caractere)|(contrario)|(de)|(div)|(e)|(enquanto)|(entao)|(escreva)|(escolha)|(faca)|(fim)|(fimalgoritmo)|(fimenquanto)|(fimescolha)|(fimmodulo)|(fimpara)|(fimregistro)|(fimse)|(inicio)|(inteiro)|(leia)|(logico)|(mod)|(modulo)|(nao)|(ou)|(para)|(passo)|(programa)|(real)|(registro)|(repita)|(se)|(senao)|(tipo)|(var)|(vetor)|(retorne))([\t]*)$ { System.out.printf(" - Token Encontrado |%s|\n", yytext()); arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 2; }
^([\t]*)((verdadeiro)|(falso))([\t]*)$ { System.out.printf(" - Token Encontrado |%s|\n", yytext()); arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 6; }
^([\t]*)([a-zA-Z][a-zA-Z0-9]*)([\t]*)$ { System.out.printf(" - Token Encontrado |%s|\n", yytext()); arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); pos = hash.funcaohashing(num); num =  hash.inserir(pos, num, yytext()); return 1; }
^([\t]*)([\-\+]?[0-9]+[\.][0-9]+)([\t]*)$ { System.out.printf(" - Token Encontrado |%s|\n", yytext()); arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 4; }
^([\t]*)([\-\+)]?[0-9]+)([\t]*)$ { System.out.printf(" - Token Encontrado |%s|\n", yytext()); arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 5; }
^([\t]*)((\:)|(\;)|(\/)|(\*)|(\+)|(>)|(<)|(>=)|(<=)|(=)|(<>)|(\()|(\))|(\“)|(\\)|(\[)|(\])|(\.\.)|(\,)|(\-)|(<\-))([\t]*)$ { System.out.printf(" - Token Encontrado |%s|\n", yytext()); arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 3; }
^([\t]*)((\")(([a-zA-Z0-9\-_\,\* \\\’\”\/\*\%\?\7\a\b\n\r\t\v\+\(\)\$#@&=!\;:><|ºª§ç¹²³£¢¬áéíóúàèìòùÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛâêîôûãÃõÕ\{\}\]\[¨\.]*)*)([\"]?))([\t]*)$ { System.out.printf(" - Token Encontrado |%s|\n", yytext()); arq.arquivoTokens(" - Token Encontrado"+"  |"+yytext().trim()+"|\n"); return 7; }
^([\t]*)(([/{](([a-zA-Z0-9\-_\,\* \\\’\”\/\%\?\7\a\b\n\r\t\v\+\(\)\$#@&=!\;:><|ºª§ç¹²³£¢¬áéíóúàèìòùÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛâêîôûãÃõÕ\]\[¨\.]*))[/}?]))([\t]*)$  { /* comentário */ }

[ \t]+ { /* espaço e tabulação */ }
[\n\r\f]+ { /* nova linha, retrocesso e \f */ }

.+ { System.err.printf(" - Token Inválido |%s|\n", yytext()); arq.arquivoErros(" - Token Inválido"+"  |"+yytext().trim()+"|\n"); return 0; }

/*
	public int op, pos;
    public int num;
	public Tabela hash = new Tabela();
	public Arquivo arq = new Arquivo();
	
	public void setNum (int num){
		this.num = num;		
	}
	
	public int getNum (){
		return this.num;		
	}
	*/