package Telas;

import java.util.ArrayList;

import Telas.TabelaSintatico.hash;
import Telas.TabelaSintatico.Variavel;
import Telas.TabelaSintatico.Funcao;
import Telas.TabelaSintatico.Registro;


public class AnaliseSemantica {
	
	public static void ativacao(Token funcao, ArrayList<Token> argumentos){
		Funcao func = new Funcao();
		func = FuncaoExiste(funcao);
		if(func!=null){
			if(func.parametros.size()==argumentos.size()){
				for(int indice = 0; indice < argumentos.size(); indice++){
					Variavel variavel = new Variavel();
					variavel = VariavelExiste(argumentos.get(indice));
					if(argumentos.get(indice).kind == 46 && variavel!=null){
						if(variavel.tipo.toString().equals(func.parametros.get(indice).tipo.toString())){
							if(variavel.vetor != func.parametros.get(indice).vetor){
								if(variavel.vetor==1){
									System.out.println("Erro o argumento \""+argumentos.get(indice).image + "\" foi declarado como vetor, Linha: "+argumentos.get(indice).beginLine+" Coluna: "+argumentos.get(indice).beginColumn);
								}else{
									System.out.println("Erro o argumento \""+argumentos.get(indice).image + "\" não foi declarado como vetor, Linha: "+argumentos.get(indice).beginLine+" Coluna: "+argumentos.get(indice).beginColumn);
								}
							}
						}else{
							System.out.println("Erro o argumento \""+argumentos.get(indice).image + "\" não é do tipo: "+func.parametros.get(indice).tipo.toString()+", Linha: "+argumentos.get(indice).beginLine+" Coluna: "+argumentos.get(indice).beginColumn);
						}
					}else{
						if(argumentos.get(indice).kind == 46 && variavel==null){
							System.out.println("Erro o argumento \""+argumentos.get(indice).image + "\" não foi declarado, Linha: "+argumentos.get(indice).beginLine+" Coluna: "+argumentos.get(indice).beginColumn);
						}else{
							if( (argumentos.get(indice).kind==38 && func.parametros.get(indice).tipo.toString().equals("inteiro")) || (argumentos.get(indice).kind==39 && func.parametros.get(indice).tipo.toString().equals("real")) || (argumentos.get(indice).kind==30 && func.parametros.get(indice).tipo.toString().equals("caractere")) || ( (argumentos.get(indice).kind==60 || argumentos.get(indice).kind==53) && func.parametros.get(indice).tipo.toString().equals("logico")) ){
								if(func.parametros.get(indice).vetor==1){
									System.out.println("Erro o argumento \""+argumentos.get(indice).image + "\" não é um vetor, Linha: "+argumentos.get(indice).beginLine+" Coluna: "+argumentos.get(indice).beginColumn);
								}
							}else{
								System.out.println("Erro o argumento \""+argumentos.get(indice).image + "\" não é do tipo: "+func.parametros.get(indice).tipo.toString()+", Linha: "+argumentos.get(indice).beginLine+" Coluna: "+argumentos.get(indice).beginColumn);
							}
						}
					}
				}
			}else{
				System.out.println("Erro a quantidade de argumentos da função \""+funcao.image + "\" está errada, Linha: "+funcao.beginLine+" Coluna: "+funcao.beginColumn+".");
			}
		}else{
			System.out.println("Erro a função \""+funcao.image + "\" não foi declarada, Linha: "+funcao.beginLine+" Coluna: "+funcao.beginColumn+".");
		}
	}
	
	private static Funcao FuncaoExiste(Token funcao) {
		hash aux=null;
        for (int i = 0; i < 10; i++) {
           aux = Telas.TabelaSintatico.tabela[i];
           while (aux != null) {
	  		  if(aux.funcao != null && aux.funcao.token.toString().equals(funcao.image))
	    		return aux.funcao;
	  		  aux = aux.prox;
	       }
	    }
	    return null;
    }
	
	private static Variavel VariavelExiste(Token variavel) {
		hash aux=null;
        for (int i = 0; i < 10; i++) {
           aux = Telas.TabelaSintatico.tabela[i];
           while (aux != null) {
	  		  if(aux.variavel != null && aux.variavel.token.toString().equals(variavel.image))
	    		return aux.variavel;
	  		  aux = aux.prox;
	       }
	    }
	    return null;
    }
	
	public static void atribuicaoSimples(Token tipo, Token valor){
		Variavel variavel = new Variavel();
		variavel = VariavelExiste(valor);
		if(valor.kind == 46 && variavel!=null){
			if( !(variavel.tipo.toString().equals(tipo.image.toString())) ){
				System.out.println("Erro a variavel \""+variavel.token.image + "\" não é do tipo: "+tipo.image+", Linha: "+variavel.token.beginLine+" Coluna: "+variavel.token.beginColumn);
			}
		}else{
			if(valor.kind == 46 && variavel==null){
				System.out.println("Erro a variavel \""+valor.image + "\" não foi declarada, Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
			}else{
				if( !( (valor.kind==38 && tipo.image.toString().equals("inteiro")) || (valor.kind==39 && tipo.image.toString().equals("real")) || (valor.kind==30 && tipo.image.toString().equals("caractere")) || ( (valor.kind==60 || valor.kind==53) && tipo.image.toString().equals("logico")) ) ){
					System.out.println("Erro o valor \""+valor.image + "\" não é do tipo: "+tipo.image.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
				}
			}
		}
	}
	
	public static void atribuicaoSimplesVariavel(Token var, Token valor){
		Variavel variavel = new Variavel();
		variavel = VariavelExiste(var);
		if(variavel!=null){
			if( !( (valor.kind==30 && variavel.tipo.toString().equals("caractere")) || ( (valor.kind==60 || valor.kind==53) && variavel.tipo.toString().equals("logico")) ) ){
				System.out.println("Erro o valor \""+valor.image + "\" não é do tipo: "+variavel.tipo.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
			}
		}else{
			System.out.println("Erro a variavel \""+var.image + "\" não foi declarada, Linha: "+var.beginLine+" Coluna: "+var.beginColumn);
		}
	}
	
	public static void atribuicaoSimplesRegistro(Token reg, Token varInterior, Token valor){
		Variavel variavel = new Variavel();
		variavel = VariavelExiste(reg);
		if(variavel!=null){
			Registro registro = new Registro();
			registro = registroExiste(variavel.tipo.image);
			if(registro!=null){
				int existe=0,i=0;
				for (i = 0; i < registro.variaveis.size(); i++)
		            if (registro.variaveis.get(i).token.image.equals(varInterior.image)) {
		            	existe=1;
		            	break;
		            }
				if(existe==0)
					System.out.println("Erro a variavel \""+varInterior.image + "\" não existe na estrutura do registro \""+registro.token.image+"\", Linha: "+varInterior.beginLine+" Coluna: "+varInterior.beginColumn);
				else{
					if( !( (valor.kind==30 && registro.variaveis.get(i).tipo.toString().equals("caractere")) || ( (valor.kind==60 || valor.kind==53) && registro.variaveis.get(i).tipo.toString().equals("logico")) ) ){
						System.out.println("Erro o valor \""+valor.image + "\" não é do tipo: "+registro.variaveis.get(i).tipo.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
					}
				}
			}
		}else{
			System.out.println("Erro a variavel \""+reg.image + "\" não foi declarada, Linha: "+reg.beginLine+" Coluna: "+reg.beginColumn);
		}
	}
	
	private static Registro registroExiste(String reg) {
		hash aux=null;
        for (int i = 0; i < 10; i++) {
           aux = Telas.TabelaSintatico.tabela[i];
           while (aux != null) {
	  		  if(aux.registro != null && aux.registro.token.toString().equals(reg))
	    		return aux.registro;
	  		  aux = aux.prox;
	       }
	    }
	    return null;
    }
		
	public static String atribuicaoComposta(ArrayList<Token> variaveis) {
		/*for (int i = 0; i < variaveis.size(); i++)
			System.out.println(variaveis.get(i).image+" ");*/
		String real=null;
		if(variaveis.size()<=0){
			return null;
		}else{
			Variavel var = new Variavel();
			var = VariavelExiste(variaveis.get(0));
			Funcao func = new Funcao();
			func = FuncaoExiste(variaveis.get(0));
			if(var!=null && variaveis.size()==1)
				return var.tipo.image;
			else{
				if(func!=null && variaveis.size()==1) 
					return func.tipo;
				switch (variaveis.get(0).kind){
					case 30: return "caractere";
					case 38: return "inteiro";
					case 39: return "real";
					case 53: return "logico";
					case 60: return "logico";
				}
			}
		}
		if(!variaveis.get(1).toString().equals("<-")){
			for (int i = 0; i < variaveis.size(); i+=2){
				Variavel variavel = new Variavel();
				variavel = VariavelExiste(variaveis.get(i));
				if(variavel!=null){
					if( variavel.tipo.toString().equals("caractere") || variavel.tipo.toString().equals("logico") ){
						System.out.println("Erro a variavel \""+variavel.token.image + "\" não é do tipo: \"real\" ou \"inteiro\", Linha: "+variavel.token.beginLine+" Coluna: "+variavel.token.beginColumn);
					}
				}else{
					if( (variaveis.get(i).kind==30) ||  variaveis.get(i).kind==60 || variaveis.get(i).kind==53 ){
						System.out.println("Erro o valor \""+variaveis.get(i).image + "\" não é do tipo: \"real\" ou \"inteiro\", Linha: "+variaveis.get(i).beginLine+" Coluna: "+variaveis.get(i).beginColumn);
					}else{
						if(variavel==null && !((variaveis.get(i).kind==39) ||  variaveis.get(i).kind==38)){
							Funcao func = new Funcao();
							func = FuncaoExiste(variaveis.get(i));
							if(func==null){
								System.out.println("Erro a variavel \""+variaveis.get(i).image + "\" não foi declarada, Linha: "+variaveis.get(i).beginLine+" Coluna: "+variaveis.get(i).beginColumn);
							}
						}
					}
				}
				if( (variaveis.get(i).kind==39) || (variavel!=null && variavel.tipo.toString().equals("real")))
					real = "real";
			}
		}else{
			Variavel var = VariavelExiste(variaveis.get(0));
			if(var!=null)
				for (int i = 0; i < variaveis.size(); i+=2){
					Variavel variavel = new Variavel();
					variavel = VariavelExiste(variaveis.get(i));
					
					if(variavel!=null){
						if( ( !variavel.tipo.toString().equals(var.tipo.image) ) && !(var.tipo.image.equals("real") && variavel.tipo.toString().equals("inteiro")) ){
								System.out.println("Erro o tipo da variavel \""+variavel.token.image + "\" não é compativel com o tipo: \""+var.tipo.image+"\", Linha: "+variavel.token.beginLine+" Coluna: "+variavel.token.beginColumn);
						}
					}else{
						if( ( !(variaveis.get(i).kind==39 && var.tipo.image.equals("real")) && !(variaveis.get(i).kind==38 && (var.tipo.image.equals("real") || var.tipo.image.equals("inteiro"))) )){
							System.out.println("Erro o valor \""+variaveis.get(i).image + "\" não é compativel com o tipo: \""+var.tipo.image+"\", Linha: "+variaveis.get(i).beginLine+" Coluna: "+variaveis.get(i).beginColumn);
						}
					}
				}
			else
				System.out.println("Erro a variavel \""+variaveis.get(0).image + "\" não foi declarada, Linha: "+variaveis.get(0).beginLine+" Coluna: "+variaveis.get(0).beginColumn);
			return var.tipo.image;
		}
		return (real!=null) ? "real" : "inteiro";//fim funcao
	}
	
	public static void  comparacaoRelacional(ArrayList<Token> variaveis){
		for (int i = 0; i < variaveis.size(); i++)
			System.out.println(variaveis.get(i).image+" ");
		String tipo1,tipo2;
		for (int i = 0; i < variaveis.size(); i+=2){
			int erro=0;
			tipo1 = verificaTipo(variaveis.get(i));
			tipo2 = verificaTipo(variaveis.get(i+1));
			if(tipo1==null){
				erro=1;
				System.out.println("Erro a variavel \""+variaveis.get(i).image + "\" não foi declarada, Linha: "+variaveis.get(i).beginLine+" Coluna: "+variaveis.get(i).beginColumn);
			}
			if(tipo2==null){
				erro=1;
				System.out.println("Erro a variavel \""+variaveis.get(i+1).image + "\" não foi declarada, Linha: "+variaveis.get(i+1).beginLine+" Coluna: "+variaveis.get(i+1).beginColumn);
			}
			if(erro==0 && !tipo1.equals(tipo2)){
				System.out.println("Erro o tipo do/da valor/variavel \""+variaveis.get(i).image + "\" é diferente do/da valor/variavel\""+variaveis.get(i+1).image + "\", Linha: "+variaveis.get(i).beginLine+" Coluna: "+variaveis.get(i).beginColumn);
			}
		}
		
		
	}
	
	private static String verificaTipo(Token var){
			Variavel variavel = new Variavel();
			variavel = VariavelExiste(var);
			if(variavel!=null){
				return variavel.tipo.image;
			}else{
				switch (var.kind){
					case 30: return "caractere";
					case 38: return "inteiro";
					case 39: return "real";
					case 53: return "logico";
					case 60: return "logico";
				}
			}
			return null;
	}
}
