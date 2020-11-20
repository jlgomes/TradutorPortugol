package Telas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Telas.TabelaSintatico.Funcao;
import Telas.TabelaSintatico.Registro;
import Telas.TabelaSintatico.Variavel;
import Telas.TabelaSintatico.hash;

		/*TraducaoPortugolEmC.setVMatriz();
		for(int s=0; s < TraducaoPortugolEmC.vMatriz.size(); s++){
			if(TraducaoPortugolEmC.vMatriz.get(s).vetorMatriz.equals(argumentos.get(indice).varInterior.image)){
		    	existe=1;
			}
		}*/

public class AnaliseSemantica {
	
	public static class registro{
		Token reg;
		Token varInterior;
		Token valor;
		
		registro(Token reg, Token varInterior, Token valor){
			this.reg=reg;
			this.varInterior=varInterior;
			this.valor=valor;
		}
		
		registro(){
			reg=null;
			varInterior=null;
			valor=null;
		}
	}
	
	public static void EscreverArquivo(String texto){
    	//Gravando em arquivo os erros semânticos
    	try {
    		File arquivo = new File("C:\\Windows\\Temp\\erroSemantico.txt");
    		
    		FileWriter fw = new FileWriter(arquivo, true);
    		 
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto+".");
            bw.newLine();
            
            bw.close();
            fw.close();
    	} catch (IOException e) { 
    		e.printStackTrace();
    	}
	}
	
	public static void ativacao(Token funcao, ArrayList<registro> argumentos){
		/*for (int i = 0; i < argumentos.size(); i++){
			System.out.print(argumentos.get(i).reg.image+" ");
			if(argumentos.get(i).varInterior!=null)
				System.out.print(argumentos.get(i).varInterior.image+" ");
			System.out.println();
		}*/
		Funcao func = new Funcao();
		func = FuncaoExiste(funcao);
		if(func!=null){
			if(func.parametros.size()==argumentos.size()){
				for(int indice = 0; indice < argumentos.size(); indice++){
					Variavel variavel = new Variavel();
					variavel = VariavelExiste(argumentos.get(indice).reg);
					
					if(variavel!=null && !variavel.tipo.toString().equals(func.parametros.get(indice).tipo.toString())){
						Registro reg = null;
						reg = registroExiste(variavel.tipo.image);
						
						//em construcao
						Registro reg2=null;
						if(reg!=null)
							reg2 = registroExiste(reg.variaveis.get(0).tipo.image);
						if(reg2!=null && argumentos.get(indice).varInterior!=null && (!reg2.variaveis.get(0).token.image.equals("vetor")) && (!reg2.variaveis.get(0).token.image.equals("matriz")))
							reg = reg2;
						
						if(reg!=null){
							if(argumentos.get(indice).varInterior!=null){
								int existe=0,j=0;
								for (j = 0; j < reg.variaveis.size(); j++)
						            if (reg.variaveis.get(j).token.image.toString().equals(argumentos.get(indice).varInterior.image.toString())) {
						            	existe=1;
						            	break;
						            }
								if(existe==0){
									EscreverArquivo("Erro a variavel \""+argumentos.get(indice).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+argumentos.get(indice).varInterior.beginLine+" Coluna: "+argumentos.get(indice).varInterior.beginColumn);
									//System.out.println("Erro a variavel \""+argumentos.get(indice).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+argumentos.get(indice).varInterior.beginLine+" Coluna: "+argumentos.get(indice).varInterior.beginColumn);
									continue;
								}else{
									Registro reg4 = registroExiste(reg.variaveis.get(j).tipo.image);
									if(reg4!=null){
										variavel = reg4.variaveis.get(0);
									}else{
										variavel = reg.variaveis.get(j);
									}
								}
							}else{
								if(reg.variaveis.get(0).token.image.equals("vetor") || reg.variaveis.get(0).token.image.equals("matriz")){
									variavel.tipo = reg.variaveis.get(0).tipo;
								}
								//passagem de parâmetro de funcao não necessita selecionar um campo do registro
								/*else{
									EscreverArquivo("Erro a variavel \""+argumentos.get(indice).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
									//System.out.println("Erro a variavel \""+argumentos.get(indice).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
									continue;
								}*/
							}				
						}
					}
					
					if(argumentos.get(indice).reg.kind == 65 && variavel!=null){
						if(variavel.tipo.toString().equals(func.parametros.get(indice).tipo.toString()) || ( variavel.tipo.toString().equals("inteiro") && func.parametros.get(indice).tipo.toString().equals("real")) ){
							if(variavel.vetor != func.parametros.get(indice).vetor){
								if(variavel.vetor==1){
									EscreverArquivo("Erro o argumento \""+variavel.token.image + "\" foi declarado como vetor, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
									//System.out.println("Erro o argumento \""+variavel.token.image + "\" foi declarado como vetor, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
								}else{
									EscreverArquivo("Erro o argumento \""+variavel.token.image + "\" não foi declarado como vetor, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
									//System.out.println("Erro o argumento \""+variavel.token.image + "\" não foi declarado como vetor, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
								}
							}
						}else{
							EscreverArquivo("Erro o argumento \""+variavel.token.image + "\" não é do tipo: "+func.parametros.get(indice).tipo.toString()+", Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
							//System.out.println("Erro o argumento \""+variavel.token.image + "\" não é do tipo: "+func.parametros.get(indice).tipo.toString()+", Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
						}
					}else{
						if(argumentos.get(indice).reg.kind == 65 && variavel==null){
							EscreverArquivo("Erro o argumento \""+argumentos.get(indice).reg.image + "\" não foi declarado, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
							//System.out.println("Erro o argumento \""+argumentos.get(indice).reg.image + "\" não foi declarado, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
						}else{
							if( (argumentos.get(indice).reg.kind==38 && func.parametros.get(indice).tipo.toString().equals("inteiro")) || ( (argumentos.get(indice).reg.kind==38 || argumentos.get(indice).reg.kind==39) && func.parametros.get(indice).tipo.toString().equals("real")) || (argumentos.get(indice).reg.kind==30 && func.parametros.get(indice).tipo.toString().equals("caractere")) || ( (argumentos.get(indice).reg.kind==60 || argumentos.get(indice).reg.kind==53) && func.parametros.get(indice).tipo.toString().equals("logico")) ){
								if(func.parametros.get(indice).vetor==1){
									EscreverArquivo("Erro o argumento \""+argumentos.get(indice).reg.image + "\" não é um vetor, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
									//System.out.println("Erro o argumento \""+argumentos.get(indice).reg.image + "\" não é um vetor, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
								}
							}else{
								EscreverArquivo("Erro o argumento \""+argumentos.get(indice).reg.image + "\" não é do tipo: "+func.parametros.get(indice).tipo.toString()+", Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
								//System.out.println("Erro o argumento \""+argumentos.get(indice).reg.image + "\" não é do tipo: "+func.parametros.get(indice).tipo.toString()+", Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
							}
						}
					}
				}
			}else{
				EscreverArquivo("Erro a quantidade de argumentos da função \""+funcao.image + "\" está errada, Linha: "+funcao.beginLine+" Coluna: "+funcao.beginColumn);
				//System.out.println("Erro a quantidade de argumentos da função \""+funcao.image + "\" está errada, Linha: "+funcao.beginLine+" Coluna: "+funcao.beginColumn);
			}
		}else{
			EscreverArquivo("Erro a função \""+funcao.image + "\" não foi declarada, Linha: "+funcao.beginLine+" Coluna: "+funcao.beginColumn);
			//System.out.println("Erro a função \""+funcao.image + "\" não foi declarada, Linha: "+funcao.beginLine+" Coluna: "+funcao.beginColumn);
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
		
		if(variavel==null)//variavel vazia
			return null;
		
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
	
	public static void VerificarQuantIndice(int quantIndice){
		
	}
			
	public static void LerVariavelExiste(Token variavel, Token varInterior, ArrayList<Variavel> funVariaveis, ArrayList<Variavel> funParametros) {
		hash aux=null;
		
		if(variavel==null)//variavel vazia
			return ;
		if(funParametros!=null)
			for (int j = 0; j < funParametros.size(); j++){
				if(funParametros.get(j).token.image.equals(variavel.image)){
					return ;
				}
			}
		if(funVariaveis!=null)
			for (int j = 0; j < funVariaveis.size(); j++){
				if(funVariaveis.get(j).token.image.equals(variavel.image)){
					return ;
				}
			}
		
        for (int i = 0; i < 10; i++) {
           aux = Telas.TabelaSintatico.tabela[i];
           while (aux != null) {
	  		  if(aux.variavel != null && aux.variavel.token.toString().equals(variavel.image))
	    		return ;
	  		  aux = aux.prox;
	       }
	    }
        EscreverArquivo("Erro a variavel \""+variavel.image + "\" não foi declarada, Linha: "+variavel.beginLine+" Coluna: "+variavel.beginColumn);
		//System.out.println("Erro a variavel \""+variavel.image + "\" não foi declarada, Linha: "+variavel.beginLine+" Coluna: "+variavel.beginColumn);
    }
	
	public static void atribuicaoSimples(Token tipo, Token valor){
		Variavel variavel = new Variavel();
		variavel = VariavelExiste(valor);
		if(valor.kind == 65 && variavel!=null){
			if( !(variavel.tipo.toString().equals(tipo.image.toString())) && !(variavel.tipo.toString().equals("inteiro") && tipo.image.toString().equals("real")) ){
				EscreverArquivo("Erro a variavel \""+variavel.token.image + "\" não é do tipo: "+tipo.image+", Linha: "+variavel.token.beginLine+" Coluna: "+variavel.token.beginColumn);
				//System.out.println("Erro a variavel \""+variavel.token.image + "\" não é do tipo: "+tipo.image+", Linha: "+variavel.token.beginLine+" Coluna: "+variavel.token.beginColumn);
			}
		}else{
			if(valor.kind == 65 && variavel==null){
				EscreverArquivo("Erro a variavel \""+valor.image + "\" não foi declarada, Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
				//System.out.println("Erro a variavel \""+valor.image + "\" não foi declarada, Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
			}else{
				if( !( (valor.kind==38 && tipo.image.toString().equals("inteiro")) || ( (valor.kind==38 || valor.kind==39) && tipo.image.toString().equals("real")) || (valor.kind==30 && tipo.image.toString().equals("caractere")) || ( (valor.kind==60 || valor.kind==53) && tipo.image.toString().equals("logico")) ) ){
					EscreverArquivo("Erro o valor \""+valor.image + "\" não é do tipo: "+tipo.image.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
					//System.out.println("Erro o valor \""+valor.image + "\" não é do tipo: "+tipo.image.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
				}
			}
		}
	}
	
	public static void atribuicaoSimplesVariavel(Token var, Token valor, ArrayList<Variavel> funVariaveis, ArrayList<Variavel> funParametros){
		Variavel variavel = new Variavel();
		variavel = VariavelExiste(var);
		for (int j = 0; j < funParametros.size(); j++){
			if(funParametros.get(j).token.image.equals(var.image)){
				variavel = funParametros.get(j);
				break;
			}
		}
		for (int j = 0; j < funVariaveis.size(); j++){
			if(funVariaveis.get(j).token.image.equals(var.image)){
				variavel = funVariaveis.get(j);
				break;
			}
		}
		if(variavel!=null){
			if( !( (valor.kind==30 && variavel.tipo.toString().equals("caractere")) || ( (valor.kind==60 || valor.kind==53) && variavel.tipo.toString().equals("logico")) ) ){
				EscreverArquivo("Erro o valor \""+valor.image + "\" não é do tipo: "+variavel.tipo.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
				//System.out.println("Erro o valor \""+valor.image + "\" não é do tipo: "+variavel.tipo.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
			}
		}else{
			EscreverArquivo("Erro a variavel \""+var.image + "\" não foi declarada, Linha: "+var.beginLine+" Coluna: "+var.beginColumn);
			//System.out.println("Erro a variavel \""+var.image + "\" não foi declarada, Linha: "+var.beginLine+" Coluna: "+var.beginColumn);
		}
	}
	
	public static void atribuicaoSimplesRegistro(Token reg, Token varInterior, Token valor, ArrayList<Variavel> funVariaveis, ArrayList<Variavel> funParametros){
		Variavel variavel = new Variavel();
		variavel = VariavelExiste(reg);
		for (int j = 0; j < funParametros.size(); j++){
			if(funParametros.get(j).token.image.equals(reg.image)){
				variavel = funParametros.get(j);
				break;
			}
		}
		for (int j = 0; j < funVariaveis.size(); j++){
			if(funVariaveis.get(j).token.image.equals(reg.image)){
				variavel = funVariaveis.get(j);
				break;
			}
		}
		if(variavel!=null){
			Registro registro = new Registro();
			registro = registroExiste(variavel.tipo.image);
			
			Registro reg2=null;
			if(registro!=null)
				reg2 = registroExiste(registro.variaveis.get(0).tipo.image);
			if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
				registro = reg2;
			
			if(registro!=null){
				int existe=0,i=0;
				for (i = 0; i < registro.variaveis.size(); i++)
		            if (registro.variaveis.get(i).token.image.equals(varInterior.image)) {
		            	existe=1;
		            	break;
		            }
				if(existe==0){
					EscreverArquivo("Erro a variavel \""+varInterior.image + "\" não existe na estrutura do registro \""+registro.token.image+"\", Linha: "+varInterior.beginLine+" Coluna: "+varInterior.beginColumn);
					//System.out.println("Erro a variavel \""+varInterior.image + "\" não existe na estrutura do registro \""+registro.token.image+"\", Linha: "+varInterior.beginLine+" Coluna: "+varInterior.beginColumn);
				}else{
					Registro reg4 = registroExiste(registro.variaveis.get(i).tipo.image);
					if(reg4!=null){
						registro.variaveis.get(i).tipo = reg4.variaveis.get(0).tipo;
					}
					if( !( (valor.kind==30 && registro.variaveis.get(i).tipo.toString().equals("caractere")) || ( (valor.kind==60 || valor.kind==53) && registro.variaveis.get(i).tipo.toString().equals("logico")) ) ){
						EscreverArquivo("Erro o valor \""+valor.image + "\" não é do tipo: "+registro.variaveis.get(i).tipo.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
						//System.out.println("Erro o valor \""+valor.image + "\" não é do tipo: "+registro.variaveis.get(i).tipo.toString()+", Linha: "+valor.beginLine+" Coluna: "+valor.beginColumn);
					}
				}
			}
		}else{
			EscreverArquivo("Erro a variavel \""+reg.image + "\" não foi declarada, Linha: "+reg.beginLine+" Coluna: "+reg.beginColumn);
			//System.out.println("Erro a variavel \""+reg.image + "\" não foi declarada, Linha: "+reg.beginLine+" Coluna: "+reg.beginColumn);
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
	
	public static String atribuicaoComposta(ArrayList<registro> variaveis, ArrayList<Variavel> funVariaveis, ArrayList<Variavel> funParametros) {
		/*for (int i = 0; i < variaveis.size(); i++){
			System.out.print(variaveis.get(i).reg.image+" ");
			if(variaveis.get(i).varInterior!=null)
				System.out.print(variaveis.get(i).varInterior.image+" ");
			System.out.println();
		}*/
		String real=null;
		if(variaveis.size()<=0){
			return null;
		}else{
			Variavel var = new Variavel();
			var = VariavelExiste(variaveis.get(0).reg);
			for (int j = 0; j < funParametros.size(); j++){
				if(funParametros.get(j).token.image.equals(variaveis.get(0).reg.image)){
					var = funParametros.get(j);
					break;
				}
			}
			for (int j = 0; j < funVariaveis.size(); j++){
				if(funVariaveis.get(j).token.image.equals(variaveis.get(0).reg.image)){
					var = funVariaveis.get(j);
					break;
				}
			}
			
			if(var!=null){
				Registro reg = new Registro();
				reg = registroExiste(var.tipo.image);
				
				Registro reg2=null;
				if(reg!=null)
					reg2 = registroExiste(reg.variaveis.get(0).tipo.image);
				if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
					reg = reg2;
				
				if(reg!=null && variaveis.size()==1){
					if(variaveis.get(0).varInterior!=null){
						int existe=0,j=0;
						for (j = 0; j < reg.variaveis.size(); j++)
				            if (reg.variaveis.get(j).token.image.toString().equals(variaveis.get(0).varInterior.image.toString())) {
				            	existe=1;
				            	break;
				            }
						if(existe==0){
							EscreverArquivo("Erro a variavel \""+variaveis.get(0).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(0).varInterior.beginLine+" Coluna: "+variaveis.get(0).varInterior.beginColumn);
							//System.out.println("Erro a variavel \""+variaveis.get(0).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(0).varInterior.beginLine+" Coluna: "+variaveis.get(0).varInterior.beginColumn);
							return null;
						}else{
							Registro reg4 = registroExiste(reg.variaveis.get(j).tipo.image);
							if(reg4!=null){
								return reg4.variaveis.get(0).tipo.image;
							}else{
								return reg.variaveis.get(j).tipo.image;
							}
						}
					}else{
						if(reg.variaveis.get(0).token.image.equals("vetor") || reg.variaveis.get(0).token.image.equals("matriz")){
							//System.out.println(reg.variaveis.get(0).tipo.image+"\n");
							return reg.variaveis.get(0).tipo.image;
						}else{
							EscreverArquivo("Erro a variavel \""+variaveis.get(0).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(0).reg.beginLine+" Coluna: "+variaveis.get(0).reg.beginColumn);
							//System.out.println("Erro a variavel \""+argumentos.get(indice).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+argumentos.get(indice).reg.beginLine+" Coluna: "+argumentos.get(indice).reg.beginColumn);
						}
					}				
				}
			}
				
			
			if(var!=null && variaveis.size()==1)
				return var.tipo.image;
			
			Funcao func = new Funcao();
			func = FuncaoExiste(variaveis.get(0).reg);
			if(func!=null && variaveis.size()==1) 
					return func.tipo;
			if(variaveis.size()==1)
				switch (variaveis.get(0).reg.kind){
					case 30: return "caractere";
					case 38: return "inteiro";
					case 39: return "real";
					case 53: return "logico";
					case 60: return "logico";
				}
			if(var==null && variaveis.size()==1 && variaveis.get(0).reg.kind==65){
				EscreverArquivo("Erro a variavel \""+variaveis.get(0).reg.image + "\" não foi declarada, Linha: "+variaveis.get(0).reg.beginLine+" Coluna: "+variaveis.get(0).reg.beginColumn);
				//System.out.println("Erro a variavel \""+variaveis.get(0).reg.image + "\" não foi declarada, Linha: "+variaveis.get(0).reg.beginLine+" Coluna: "+variaveis.get(0).reg.beginColumn);
			}
			if(variaveis.size()==1)
				return null;
		}
		
		if( !variaveis.get(1).reg.toString().equals("<-") ){
			for (int i = 0; i < variaveis.size(); i++){
				Variavel variavel = new Variavel();
				variavel = VariavelExiste(variaveis.get(i).reg);
				
				
				for (int j = 0; j < funParametros.size(); j++){
					if(funParametros.get(j).token.image.equals(variaveis.get(i).reg.image)){
						variavel = funParametros.get(j);
						break;
					}
				}
				for (int j = 0; j < funVariaveis.size(); j++){
					if(funVariaveis.get(j).token.image.equals(variaveis.get(i).reg.image)){
						variavel = funVariaveis.get(j);
						break;
					}
				}
				
				
				if(variavel!=null){
					Registro reg = new Registro();
					reg = registroExiste(variavel.tipo.image);
					
					Registro reg2=null;
					if(reg!=null)
						reg2 = registroExiste(reg.variaveis.get(0).tipo.image);
					if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
						reg = reg2;
					
					if(reg!=null){
						if(variaveis.get(i).varInterior!=null){
							int existe=0,j=0;
							for (j = 0; j < reg.variaveis.size(); j++)
					            if (reg.variaveis.get(j).token.image.toString().equals(variaveis.get(i).varInterior.image.toString())) {
					            	existe=1;
					            	break;
					            }
							if(existe==0){
								EscreverArquivo("Erro a variavel \""+variaveis.get(i).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
								//System.out.println("Erro a variavel \""+variaveis.get(i).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
								continue;
							}else{
								Registro reg4 = registroExiste(reg.variaveis.get(j).tipo.image);
								if(reg4!=null){
									variavel = reg4.variaveis.get(0);
								}else{
									variavel = reg.variaveis.get(j);
								}
							}
						}else{
							if(reg.variaveis.get(0).token.image.equals("vetor") || reg.variaveis.get(0).token.image.equals("matriz")){
								variavel.tipo = reg.variaveis.get(0).tipo;
							}else{
								EscreverArquivo("Erro a variavel \""+variaveis.get(i).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
								//System.out.println("Erro a variavel \""+variaveis.get(i).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
								continue;
							}
						}				
					}
				}
				
				if(variavel!=null){
					if( variavel.tipo.toString().equals("caractere") || variavel.tipo.toString().equals("logico") ){
						EscreverArquivo("Erro a variavel \""+variavel.token.image + "\" não é do tipo: \"real\" ou \"inteiro\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
						//System.out.println("Erro a variavel \""+variavel.token.image + "\" não é do tipo: \"real\" ou \"inteiro\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
					}
				}else{
					if( (variaveis.get(i).reg.kind==30) ||  variaveis.get(i).reg.kind==60 || variaveis.get(i).reg.kind==53 ){
						EscreverArquivo("Erro o valor \""+variaveis.get(i).reg.image + "\" não é do tipo: \"real\" ou \"inteiro\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
						//System.out.println("Erro o valor \""+variaveis.get(i).reg.image + "\" não é do tipo: \"real\" ou \"inteiro\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
					}else{
						if(variavel==null && !((variaveis.get(i).reg.kind==39) ||  variaveis.get(i).reg.kind==38)){
							Funcao func = new Funcao();
							func = FuncaoExiste(variaveis.get(i).reg);
							if(func==null){
								EscreverArquivo("Erro a variavel \""+variaveis.get(i).reg.image + "\" não foi declarada, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
								//System.out.println("Erro a variavel \""+variaveis.get(i).reg.image + "\" não foi declarada, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
							}
						}
					}
				}
				if( (variaveis.get(i).reg.kind==39) || (variavel!=null && variavel.tipo.toString().equals("real")))
					real = "real";
			}
		}else{
			Variavel var = VariavelExiste(variaveis.get(0).reg);
			for (int j = 0; j < funParametros.size(); j++){
				if(funParametros.get(j).token.image.equals(variaveis.get(0).reg.image)){
					var = funParametros.get(j);
					break;
				}
			}
			for (int j = 0; j < funVariaveis.size(); j++){
				if(funVariaveis.get(j).token.image.equals(variaveis.get(0).reg.image)){
					var = funVariaveis.get(j);
					break;
				}
			}
			
			if(var!=null){
				Registro reg = new Registro();
				reg = registroExiste(var.tipo.image);
				
				Registro reg2=null;
				if(reg!=null)
					reg2 = registroExiste(reg.variaveis.get(0).tipo.image);
				if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
					reg = reg2;
				
				if(reg!=null){
					if(variaveis.get(0).varInterior!=null){
						int existe=0,j=0;
						for (j = 0; j < reg.variaveis.size(); j++)
				            if (reg.variaveis.get(j).token.image.toString().equals(variaveis.get(0).varInterior.image.toString())) {
				            	existe=1;
				            	break;
				            }
						if(existe==0){
							EscreverArquivo("Erro a variavel \""+variaveis.get(0).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(0).varInterior.beginLine+" Coluna: "+variaveis.get(0).varInterior.beginColumn);
							//System.out.println("Erro a variavel \""+variaveis.get(0).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(0).varInterior.beginLine+" Coluna: "+variaveis.get(0).varInterior.beginColumn);
						}else{
							Registro reg4 = registroExiste(reg.variaveis.get(j).tipo.image);
							if(reg4!=null){
								var = reg4.variaveis.get(0);
							}else{
								var = reg.variaveis.get(j);
							}
						}
					}else{
						if(reg.variaveis.get(0).token.image.equals("vetor")  || reg.variaveis.get(0).token.image.equals("matriz")){
							var.tipo = reg.variaveis.get(0).tipo;
						}else{
							EscreverArquivo("Erro a variavel \""+variaveis.get(0).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(0).reg.beginLine+" Coluna: "+variaveis.get(0).reg.beginColumn);
							//System.out.println("Erro a variavel \""+variaveis.get(0).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(0).reg.beginLine+" Coluna: "+variaveis.get(0).reg.beginColumn);
						}
						
					}				
				}
			}
			
			if(var!=null)
				for (int i = 2; i < variaveis.size(); i++){
					Variavel variavel = new Variavel();
					variavel = VariavelExiste(variaveis.get(i).reg);
					
					for (int j = 0; j < funParametros.size(); j++){
						if(funParametros.get(j).token.image.equals(variaveis.get(i).reg.image)){
							variavel = funParametros.get(j);
							break;
						}
					}
					for (int j = 0; j < funVariaveis.size(); j++){
						if(funVariaveis.get(j).token.image.equals(variaveis.get(i).reg.image)){
							variavel = funVariaveis.get(j);
							break;
						}
					}
					
					if(variavel!=null){
						Registro reg = new Registro();
						reg = registroExiste(variavel.tipo.image);
						
						Registro reg2=null;
						if(reg!=null)
							reg2 = registroExiste(reg.variaveis.get(0).tipo.image);
						if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
							reg = reg2;
						
						if(reg!=null){
							if(variaveis.get(i).varInterior!=null){
								int existe=0,j=0;
								for (j = 0; j < reg.variaveis.size(); j++)
						            if (reg.variaveis.get(j).token.image.toString().equals(variaveis.get(i).varInterior.image.toString())) {
						            	existe=1;
						            	break;
						            }
								if(existe==0){
									EscreverArquivo("Erro a variavel \""+variaveis.get(i).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
									//System.out.println("Erro a variavel \""+variaveis.get(i).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
									continue;
								}else{
									Registro reg4 = registroExiste(reg.variaveis.get(j).tipo.image);
									if(reg4!=null){
										variavel = reg4.variaveis.get(0);
									}else{
										variavel = reg.variaveis.get(j);
									}
								}
							}else{
								if(reg.variaveis.get(0).token.image.equals("vetor") || reg.variaveis.get(0).token.image.equals("matriz")){
									variavel.tipo = reg.variaveis.get(0).tipo;
								}else{
									EscreverArquivo("Erro a variavel \""+variaveis.get(i).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
									//System.out.println("Erro a variavel \""+variaveis.get(i).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
									continue;
								}
							}				
						}
					}
					
					if(variavel!=null){
						if( ( !variavel.tipo.toString().equals(var.tipo.image) ) && !(var.tipo.image.equals("real") && variavel.tipo.toString().equals("inteiro")) ){
							EscreverArquivo("Erro o tipo da variavel \""+variavel.token.image + "\" não é compativel com o tipo: \""+var.tipo.image+"\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
							//System.out.println("Erro o tipo da variavel \""+variavel.token.image + "\" não é compativel com o tipo: \""+var.tipo.image+"\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
						}
					}else{
						if( ( !(variaveis.get(i).reg.kind==39 && var.tipo.image.equals("real")) && !(variaveis.get(i).reg.kind==38 && (var.tipo.image.equals("real") || var.tipo.image.equals("inteiro"))) )){
							Funcao func = new Funcao();
							func = FuncaoExiste(variaveis.get(i).reg);
							if(func==null){
								EscreverArquivo("Erro o valor \""+variaveis.get(i).reg.image + "\" não é compativel com o tipo: \""+var.tipo.image+"\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
								//System.out.println("Erro o valor \""+variaveis.get(i).reg.image + "\" não é compativel com o tipo: \""+var.tipo.image+"\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
							}							
						}
					}
				}
			else{
				EscreverArquivo("Erro a variavel \""+variaveis.get(0).reg.image + "\" não foi declarada, Linha: "+variaveis.get(0).reg.beginLine+" Coluna: "+variaveis.get(0).reg.beginColumn);
				//System.out.println("Erro a variavel \""+variaveis.get(0).reg.image + "\" não foi declarada, Linha: "+variaveis.get(0).reg.beginLine+" Coluna: "+variaveis.get(0).reg.beginColumn);
			}
			return (var!=null) ?  var.tipo.image : null;
		}
		return (real!=null) ? "real" : "inteiro";//fim funcao
	}
	
	public static void  comparacaoRelacional(ArrayList<registro> variaveis, ArrayList<Variavel> funVariaveis, ArrayList<Variavel> funParametros){
		/*for (int i = 0; i < variaveis.size(); i++){
			if(variaveis.get(i).varInterior!=null)
				System.out.println(variaveis.get(i).reg.image+" "+variaveis.get(i).varInterior.toString());
		}*/
		String tipo1,tipo2;
		for (int i = 0; i < variaveis.size(); i+=2){
			int erro=0,reg1=0,reg2=0;
			tipo1 = verificaTipo(variaveis.get(i).reg, funVariaveis, funParametros);
			tipo2 = verificaTipo(variaveis.get(i+1).reg, funVariaveis, funParametros);
			//erro==1 variavel não existe
			//erro==2 variavel não existe no registro ou tipo errado no registro
			if(tipo1==null){
				erro=1;
				EscreverArquivo("Erro a variavel \""+variaveis.get(i).reg.image + "\" não foi declarada, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
				//System.out.println("Erro a variavel \""+variaveis.get(i).reg.image + "\" não foi declarada, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
			}
			if(tipo2==null){
				erro=1;
				EscreverArquivo("Erro a variavel \""+variaveis.get(i+1).reg.image + "\" não foi declarada, Linha: "+variaveis.get(i+1).reg.beginLine+" Coluna: "+variaveis.get(i+1).reg.beginColumn);
				//System.out.println("Erro a variavel \""+variaveis.get(i+1).reg.image + "\" não foi declarada, Linha: "+variaveis.get(i+1).reg.beginLine+" Coluna: "+variaveis.get(i+1).reg.beginColumn);
			}
			
			if( erro==0 && (!tipo1.equals("inteiro") && !tipo1.equals("real") && !tipo1.equals("logico") && !tipo1.equals("caractere")) ){
				Registro reg = new Registro();
				reg = registroExiste(tipo1);
				
				Registro reg3=null;
				if(reg!=null)
					reg3 = registroExiste(reg.variaveis.get(0).tipo.image);
				if(reg3!=null && !reg3.variaveis.get(0).token.image.equals("vetor") && !reg3.variaveis.get(0).token.image.equals("matriz"))
					reg = reg3;
				
				if(reg!=null){
					if(variaveis.get(i).varInterior!=null){
						int existe=0,j=0;
						for (j = 0; j < reg.variaveis.size(); j++)
				            if (reg.variaveis.get(j).token.image.toString().equals(variaveis.get(i).varInterior.image.toString())) {
				            	existe=1;
				            	break;
				            }
						if(existe==0){
							erro=2;
							EscreverArquivo("Erro a variavel \""+variaveis.get(i).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
							//System.out.println("Erro a variavel \""+variaveis.get(i).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
						}else{
							reg1=1;
							Registro reg4 = registroExiste(reg.variaveis.get(j).tipo.image);
							if(reg4!=null){
								tipo1 = reg4.variaveis.get(0).tipo.image;
							}else{
								tipo1 = reg.variaveis.get(j).tipo.image;
							}
						}
					}else{
						if(reg.variaveis.get(0).token.image.equals("vetor")  || reg.variaveis.get(0).token.image.equals("matriz")){
							tipo1 = reg.variaveis.get(0).tipo.image;
						}else{
							erro=2;
							EscreverArquivo("Erro a variavel \""+variaveis.get(i).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
							//System.out.println("Erro a variavel \""+variaveis.get(i).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
						}
					}					
				}
			}
			
			if( (erro==0 || erro==2) && (!tipo2.equals("inteiro") && !tipo2.equals("real") && !tipo2.equals("logico") && !tipo2.equals("caractere")) ){
				Registro reg = new Registro();
				reg = registroExiste(tipo2);
				
				Registro reg3=null;
				if(reg!=null)
					reg3 = registroExiste(reg.variaveis.get(0).tipo.image);
				if(reg3!=null && !reg3.variaveis.get(0).token.image.equals("vetor") && !reg3.variaveis.get(0).token.image.equals("matriz"))
					reg = reg3;
				
				if(reg!=null){
					if(variaveis.get(i+1).varInterior!=null){
						int existe=0,j=0;
						for (j = 0; j < reg.variaveis.size(); j++)
								 if (reg.variaveis.get(j).token.image.equals(variaveis.get(i+1).varInterior.image)) {
					            	existe=1;
					            	break;
					             }
						if(existe==0){
								erro=2;
								EscreverArquivo("Erro a variavel \""+variaveis.get(i+1).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i+1).varInterior.beginLine+" Coluna: "+variaveis.get(i+1).varInterior.beginColumn);
								//System.out.println("Erro a variavel \""+variaveis.get(i+1).varInterior.image + "\" não existe na estrutura do registro \""+reg.token.image+"\", Linha: "+variaveis.get(i+1).varInterior.beginLine+" Coluna: "+variaveis.get(i+1).varInterior.beginColumn);
						}else{
							reg2=1;
							Registro reg4 = registroExiste(reg.variaveis.get(j).tipo.image);
							if(reg4!=null){
								tipo2 = reg4.variaveis.get(0).tipo.image;
							}else{
								tipo2 = reg.variaveis.get(j).tipo.image;
							}
						}
					}else{
						if(reg.variaveis.get(0).token.image.equals("vetor")  || reg.variaveis.get(0).token.image.equals("matriz")){
							tipo2 = reg.variaveis.get(0).tipo.image;
						}else{
							erro=2;
							EscreverArquivo("Erro a variavel \""+variaveis.get(i+1).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i+1).reg.beginLine+" Coluna: "+variaveis.get(i+1).reg.beginColumn);
							//System.out.println("Erro a variavel \""+variaveis.get(i+1).reg.image + "\" é do tipo \""+reg.token.image+"\" selecione um campo do registro, Linha: "+variaveis.get(i+1).reg.beginLine+" Coluna: "+variaveis.get(i+1).reg.beginColumn);
						}
					}
				}
			}
			
			if(tipo1.equals("real") && (tipo2.equals("inteiro") || tipo2.equals("real")) ){
				continue;
			}
			
			if(tipo2.equals("real") && (tipo1.equals("inteiro") || tipo1.equals("real")) ){
				continue;
			}
			
			if(erro==0 && !tipo1.equals(tipo2)){
				if( reg1==1 && reg2==1 ){
					EscreverArquivo("Erro o tipo de \""+variaveis.get(i).reg.image+"."+variaveis.get(i).varInterior.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image+"."+variaveis.get(i+1).varInterior.image + "\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
					//System.out.println("Erro o tipo de \""+variaveis.get(i).reg.image+"."+variaveis.get(i).varInterior.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image+"."+variaveis.get(i+1).varInterior.image + "\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
				}else{
					if( reg1==1 ){
						EscreverArquivo("Erro o tipo de \""+variaveis.get(i).reg.image+"."+variaveis.get(i).varInterior.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image + "\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
						//System.out.println("Erro o tipo de \""+variaveis.get(i).reg.image+"."+variaveis.get(i).varInterior.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image + "\", Linha: "+variaveis.get(i).varInterior.beginLine+" Coluna: "+variaveis.get(i).varInterior.beginColumn);
					}else{
						if( reg2==1 ){
							EscreverArquivo("Erro o tipo de \""+variaveis.get(i).reg.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image+"."+variaveis.get(i+1).varInterior.image + "\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i+1).reg.beginColumn);
							//System.out.println("Erro o tipo de \""+variaveis.get(i).reg.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image+"."+variaveis.get(i+1).varInterior.image + "\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i+1).reg.beginColumn);
						}else{
							EscreverArquivo("Erro o tipo de \""+variaveis.get(i).reg.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image + "\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
							//System.out.println("Erro o tipo de \""+variaveis.get(i).reg.image + "\" é diferente do tipo de \""+variaveis.get(i+1).reg.image + "\", Linha: "+variaveis.get(i).reg.beginLine+" Coluna: "+variaveis.get(i).reg.beginColumn);
						}
					}
				}
			}
		}
		
		
	}
	
	private static String verificaTipo(Token var, ArrayList<Variavel> funVariaveis, ArrayList<Variavel> funParametros){
			Variavel variavel = new Variavel();
			variavel = VariavelExiste(var);
			for (int j = 0; j < funParametros.size(); j++){
				if(funParametros.get(j).token.image.equals(var.image)){
					variavel = funParametros.get(j);
					break;
				}
			}
			for (int j = 0; j < funVariaveis.size(); j++){
				if(funVariaveis.get(j).token.image.equals(var.image)){
					variavel = funVariaveis.get(j);
					break;
				}
			}

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
			
			if(var.image.equals("verdadeiro") || var.image.equals("falso")){
				return "logico";
			}
			return null;
	}
	
	public static int quantIndices(String tipo){
		TraducaoPortugolEmC.setVMatriz();
		int cont=0;//guarda a quantidade de indices
		for(int i =0; i < TraducaoPortugolEmC.vMatriz.size(); i++){
			if(TraducaoPortugolEmC.vMatriz.get(i).vetorMatriz.equals(tipo)){
				for(int j = 0; j < TraducaoPortugolEmC.vMatriz.get(i).valor.size(); j++){
					cont++;
				}
				break;
			}
		}
		return cont;
	}
}
