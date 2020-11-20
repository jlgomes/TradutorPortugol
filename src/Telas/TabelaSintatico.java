
package Telas;


import java.util.ArrayList;
import java.util.Scanner;

public class TabelaSintatico {
	
	public static class Variavel{
        Token token;
        Token tipo;
        int escopo;
        int vetor;
        public Variavel(){
        	this.token = null;
			this.tipo = null;
			this.escopo = 0;
			this.vetor = 0;
        }
		public Variavel(Token token, Token tipo, int escopo,
				int vetor) {
			this.token = token;
			this.tipo = tipo;
			this.escopo = escopo;
			this.vetor = vetor;
		}
	}
	
	public static class Registro{
        Token token;
        ArrayList<Variavel> variaveis = new ArrayList<Variavel>();
		public Registro(Token token, ArrayList<Variavel> variaveis) {
			this.token = token;
			this.variaveis.addAll(variaveis);
		}
		public Registro(){
			this.token = null;
			this.variaveis = null;
		}
	}
	
	public static class Funcao{
		Token token;
		String tipo;
		ArrayList<Variavel> parametros = new ArrayList<Variavel>();
		ArrayList<Variavel> variaveis  = new ArrayList<Variavel>();
		public Funcao(Token token, ArrayList<Variavel> parametros,
				ArrayList<Variavel> variaveis, String tipo) {
			this.token = token;
			this.parametros.addAll(parametros);
			this.variaveis.addAll(variaveis);
			this.tipo = tipo;
		}
		public Funcao(){
			this.token = null;
			this.parametros = null;
			this.variaveis = null;
			this.tipo = null;
		}
	}
	
    public static class hash {
 
        int chave;
        Funcao funcao;
        Registro registro;
        Variavel variavel;
        hash prox;
        public hash(int chave, Funcao funcao, Registro registro,
				Variavel variavel) {
			this.chave = chave;
			this.funcao = funcao;
			this.registro = registro;
			this.variavel = variavel;
		}
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    static int tam = 10;
    static hash tabela[] = new hash[10];
    static Scanner entrada = new Scanner(System.in);
    static Arquivo arq2 = new Arquivo();

    public static int inserir(int pos, int n, Token token, Token tipo, int escopo, int vetor) {
    	hash aux;
    	int existe = 0;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            while (aux != null) {
                if(aux.variavel != null && aux.variavel.token.toString().equals(token.toString()) && aux.variavel.escopo == escopo){
                	AnaliseSemantica.EscreverArquivo("Erro a variável \""+token.toString() + "\" já  tinha sido declarada, Linha: "+token.beginLine+" Coluna: "+token.beginColumn);
                	//System.out.println("Erro a variável \""+token.toString() + "\" já  tinha sido declarada, Linha: "+token.beginLine+" Coluna: "+token.beginColumn);
                	existe = 1;
                	break;
                }
            	aux = aux.prox;
            }
            if(existe == 1)
        		break;
        }
        if(existe == 0){
        	hash novo;
        	novo = new hash(n,null,null,new Variavel(token, tipo, escopo, vetor));
        	novo.chave = n;
        	novo.prox = tabela[pos];
        	tabela[pos] = novo;
        	return (n+1);
        }
        return n;
    }
    
    public static int inserir(int pos, int n, Token token, ArrayList<Variavel> parametros, ArrayList<Variavel> variaveis,String tipo) {
    	hash aux;
    	int existe = 0;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            while (aux != null) {
                if(aux.funcao != null && aux.funcao.token.toString().equals(token.toString())){
                	AnaliseSemantica.EscreverArquivo("Erro a função \""+token.toString() + "\" já  tinha sido declarada, Linha: "+token.beginLine+" Coluna: "+token.beginColumn);
                	//System.out.println("Erro a função \""+token.toString() + "\" já  tinha sido declarada, Linha: "+token.beginLine+" Coluna: "+token.beginColumn);
                	existe = 1;
                	break;
                }
            	aux = aux.prox;
            }
            if(existe == 1)
        		break;
        }
        if(existe == 0){
        	hash novo;
        	novo = new hash(n,new Funcao(token, parametros, variaveis,tipo), null,null);
        	novo.chave = n;
        	novo.prox = tabela[pos];
        	tabela[pos] = novo;
        	return (n+1);
        }
        return n;
    }
    
    public static int inserir(int pos, int n, Token token, ArrayList<Variavel> variaveis) {
    	hash aux;
    	int existe = 0;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            while (aux != null) {
                if(aux.registro != null && aux.registro.token.toString().equals(token.toString())){
                	AnaliseSemantica.EscreverArquivo("Erro o registro \""+token.toString() + "\" já  tinha sido declarado, Linha: "+token.beginLine+" Coluna: "+token.beginColumn);
                	//System.out.println("Erro o registro \""+token.toString() + "\" já  tinha sido declarado, Linha: "+token.beginLine+" Coluna: "+token.beginColumn);
                	existe = 1;
                	break;
                }
            	aux = aux.prox;
            }
            if(existe == 1)
        		break;
        }
        if(existe == 0){
        	hash novo;
        	novo = new hash(n,null, new Registro(token, variaveis),null);
        	novo.chave = n;
        	novo.prox = tabela[pos];
        	tabela[pos] = novo;
        	return (n+1);
        }
        return n;
    }
    
    static int funcaohashing(int num) {
        return num % tam;
    }
 
    static void mostrarhash() {
        hash aux;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            while (aux != null) {
            	if(aux.variavel != null)
            		System.out.println("Tipo: " + aux.variavel.tipo + " Token: "+ aux.variavel.token );
            	else
            		if(aux.registro != null){
            			System.out.println("Tipo: Registro" + " Token: " + aux.registro.token);
            			aux.registro.variaveis.toArray();
            			for(int indice = 0; indice < aux.registro.variaveis.size(); indice++)
            				System.out.println("	Tipo: " + aux.registro.variaveis.get(indice).tipo + " Variavel: "+aux.registro.variaveis.get(indice).token);
            		}else
            			if(aux.funcao != null){
            				System.out.println("Tipo da função: " + aux.funcao.tipo +" Token: " + aux.funcao.token);
                			
            				aux.funcao.parametros.toArray();
                			System.out.println("  Parâmetros: ");
                			for(int indice = 0; indice < aux.funcao.parametros.size(); indice++)
                				System.out.println("	Tipo: " + aux.funcao.parametros.get(indice).tipo + " Variavel: "+aux.funcao.parametros.get(indice).token);            	
                			
                			aux.funcao.variaveis.toArray();
                			System.out.println("  Variaveis: ");
                			for(int indice = 0; indice < aux.funcao.variaveis.size(); indice++)
                				System.out.println("	Tipo: " + aux.funcao.variaveis.get(indice).tipo + " Variavel: "+aux.funcao.variaveis.get(indice).token);
            			}
            		//arq2.arquivoTabela("id: " + aux.chave + " Token: "+ aux.variavel.token +"\n");
            	aux = aux.prox;
            }
        }
    }
    
    static void excluirtabelahash() {
        for (int i = 0; i < tam; i++) {
            tabela[i] = null;
        }
    }
}
 