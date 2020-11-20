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

public class TraducaoPortugolEmC {
	
	public static ArrayList<String> programaAll = new ArrayList<String>();
	public static ArrayList<vetorMatriz> vMatriz= new ArrayList<vetorMatriz>();

	public static class vetorMatriz{
		String vetorMatriz;
		ArrayList<Integer> valor = null;
		public vetorMatriz(String vetorMatriz, ArrayList<Integer> valor) {
			this.vetorMatriz = vetorMatriz;
			this.valor = valor;
		}
	}
	
	/*public static void execute(){
		for(int i = 0; i < programaAll.size(); i++){
				EscreverArquivoTraduzido(programaAll.get(i),false);
		}
	}*/
	
	public static void setVMatriz(){
		vMatriz.clear();
		for(int i = 0; i < programaAll.size(); i++){
			if(programaAll.get(i).equals("tipo")){
				int op=0;
				for(int v=i+1; v < programaAll.size(); v++){
					if(programaAll.get(v).equals("vetor")){
						op=1;
						break;
					}else if(programaAll.get(v).equals("matriz")){
						op=2;
						break;
					}else if(programaAll.get(v).equals("registro")){
						op=3;
						break;
					}
				}
				if(op==1){
					//continuar depois de tipo
					for(int v=i+1; v < programaAll.size(); v++){
						if(programaAll.get(v).equals(" ") || programaAll.get(v).equals("\n") || programaAll.get(v).equals("\r") || programaAll.get(v).equals("\t")){
							//EscreverArquivoTraduzido(programaAll.get(v),false);
							//System.out.print(programaAll.get(j));
							continue;
						}
						
						for(int l = i+1; l < programaAll.size(); l++){
							if(programaAll.get(l).equals("..")){
								for(int t = l+1; t < programaAll.size(); t++){
									if(programaAll.get(t).equals(" ") || programaAll.get(t).equals("\n") || programaAll.get(t).equals("\r") || programaAll.get(t).equals("\t")){
										continue;
										//System.out.print(programaAll.get(j));
									}
									ArrayList<Integer> aI = new ArrayList<Integer>();
									aI.add(Integer.parseInt(programaAll.get(t)));
									
									vMatriz.add(new vetorMatriz(programaAll.get(v) , aI));
									//System.out.println(programaAll.get(v)+"\n"+programaAll.get(t));
									for(int r = t+1; r < programaAll.size(); r++){
										if(programaAll.get(r).equals(";")){
											i=r+1;
											break;
										}
									}
									//i=t+1;
									break;
								}
								break;
							}
						}
						if(i>v){
							break;
						}
					}					
				}
				if(op==2){
					//continuar depois de tipo
					ArrayList<Integer> aI = new ArrayList<Integer>();
					for(int v=i+1; v < programaAll.size(); v++){
						if(programaAll.get(v).equals(" ") || programaAll.get(v).equals("\n") || programaAll.get(v).equals("\r") || programaAll.get(v).equals("\t")){
							continue;
						}
						int l=0;
						for(l = i+1; l < programaAll.size(); l++){
							if(programaAll.get(l).equals("..")){
								for(int t = l+1; t < programaAll.size(); t++){
									if(programaAll.get(t).equals(" ") || programaAll.get(t).equals("\n") || programaAll.get(t).equals("\r") || programaAll.get(t).equals("\t")){
										continue;
									}
									
									aI.add(Integer.parseInt(programaAll.get(t)));
									
									break;
								}
							}
							if(programaAll.get(l).equals(";")){
								//System.out.println(programaAll.get(v)+"\n"+aI.toString());
								vMatriz.add(new vetorMatriz(programaAll.get(v) , aI));
								i=l+1;
								break;
							}
						}
						if(i>l){
							break;
						}
					}
				}
				if(op==3){
					
				}
				continue;
			}
		}
	}
	public static void execute(){
		vMatriz.clear();
		int escolha=0;
		String tempIdentacao="";
		int include = 0, main=0;
		int f=0;
		for(int i = 0; i < programaAll.size(); i++){
			if(programaAll.get(i).equals("var:")){
				EscreverArquivoTraduzido("#include <stdio.h>",false);
				//System.out.println("#include <stdio.h>");
				include=1;
				f=i+1;
				break;
			}
		}
		
		if(programaAll.get(0).equals("inicio")){
			EscreverArquivoTraduzido("#include <stdio.h>",true);
			//System.out.println("#include <stdio.h>");
			EscreverArquivoTraduzido("void main(){",false);
			//System.out.println("void main(){");
			main=1;
			include=1;
			f=1;
		}
		String nomerRegistro=null;
		for(int i = f; i < programaAll.size(); ){
			
			//falta terminar a manipulaçção de strings
			/*Variavel var1 = VariavelExiste(programaAll.get(i));
			if( var1 != null && var1.tipo.equals("caractere")){
				EscreverArquivoTraduzido(programaAll.get(i)+"[50]",false);
				System.out.print(programaAll.get(i)+"[50]");
				i++;
				continue;
			}*/
			
			if(programaAll.get(i).equals("leia")){
				String tipo="", var="";
				EscreverArquivoTraduzido("scanf",false);
				//System.out.print("scanf");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals("(")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
						for(int k = j+1; k < programaAll.size(); k++){
							if(programaAll.get(k).equals(")")){
								EscreverArquivoTraduzido("\""+tipo+"\""+","+var+programaAll.get(k),false);
								//System.out.print("\""+tipo+"\""+","+var+programaAll.get(k));
								i=k+1;
								break;
							}
							if(programaAll.get(k).equals("[")){
								var += programaAll.get(k);
								for(int x=k+1; x < programaAll.size();x++){
									if(programaAll.get(x).equals("]")){
										var += programaAll.get(x);
										k=x;
										break;
									}
									if(programaAll.get(x).equals(",")){
										var +="][";
										continue;
									}
									var += programaAll.get(x);
								}
								continue;
							}
							Variavel var1 = VariavelExiste(programaAll.get(k));
							if( var1 != null ){
								Registro reg = registroExiste(var1.tipo.image);
								
								Registro reg2=null;
								if(reg!=null)
									reg2 = registroExiste(reg.variaveis.get(0).tipo.image);
								if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
									reg = reg2;
								
								if(reg==null || (reg.variaveis.get(0).token.image.equals("vetor") || reg.variaveis.get(0).token.image.equals("matriz"))){
									String formato = traduzFormato(var1.tipo.image);
									if(var1.vetor==1 && "%c".equals(formato) )
										tipo += "%s";
									else
										tipo += formato;
									var += "&"+programaAll.get(k);
								}else{
									var += "&"+programaAll.get(k);
									for(int y = k+1; y < programaAll.size(); y++){
										if(programaAll.get(y).equals(".")){
											var += programaAll.get(y);
											Registro registro = registroExiste(var1.tipo.image);
											
											reg2=null;
											if(registro!=null)
												reg2 = registroExiste(registro.variaveis.get(0).tipo.image);
											if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
												registro = reg2;
											
											if(registro!=null){
												for(int t = y+1; t < programaAll.size(); t++){
													if( k == t){
														k--;
														break;
													}
													for (int p = 0; p < registro.variaveis.size(); p++)
											            if (registro.variaveis.get(p).token.image.equals(programaAll.get(t))) {
											            	String formato = traduzFormato(registro.variaveis.get(p).tipo.image);
															if(registro.variaveis.get(p).vetor==1 && "%c".equals(formato) )
																tipo += "%s";
															else
																tipo += formato;
											            	var += programaAll.get(t);
											            	k=t+1;
											            	break;
											            }
												}
											}else
												k=y+1;
											break;
										}
										if(programaAll.get(y).equals("[")){
											var += programaAll.get(y);
											for(int x=y+1; x < programaAll.size();x++){
												if(programaAll.get(x).equals("]")){
													var += programaAll.get(x);
													y=x;
													break;
												}
												if(programaAll.get(x).equals(",")){
													var +="][";
													continue;
												}
												var += programaAll.get(x);
											}
											continue;
									    }
										var += programaAll.get(y);
									}
								}
							}else{
									var += programaAll.get(k);
							}
						}
						
						break;
					}
					EscreverArquivoTraduzido(programaAll.get(j),false);
					//System.out.print(programaAll.get(j));
				}
				continue;
			}
			
			//falta terminar o escreva
			if(programaAll.get(i).equals("escreva")){
				String str="", var="";
				EscreverArquivoTraduzido("printf",false);
				//System.out.print("printf");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals("(")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
						for(int k = j+1; k < programaAll.size(); k++){
							if(programaAll.get(k).equals(")")){
								EscreverArquivoTraduzido("\""+str+"\""+var+programaAll.get(k),false);
								//System.out.print("\""+str+"\", "+var+programaAll.get(k));
								i=k+1;
								break;
							}
							if(programaAll.get(k).equals("[")){
								var += programaAll.get(k);
								for(int x=k+1; x < programaAll.size();x++){
									if(programaAll.get(x).equals("]")){
										var += programaAll.get(x);
										k=x;
										break;
									}
									if(programaAll.get(x).equals(",")){
										var +="][";
										continue;
									}
									var += programaAll.get(x);
								}
								continue;
							}
							if(programaAll.get(k).equals(",")){
								continue;
							}
							if(programaAll.get(k).equals(" ") || programaAll.get(k).equals("\n") || programaAll.get(k).equals("\r") || programaAll.get(k).equals("\t")){
								var += programaAll.get(k);
								continue;
							}
							Variavel var1 = VariavelExiste(programaAll.get(k));
							if( var1 != null ){
								var += ", ";
								Registro reg = registroExiste(var1.tipo.image);

								Registro reg2=null;
								if(reg!=null)
									reg2 = registroExiste(reg.variaveis.get(0).tipo.image);
								if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
									reg = reg2;
								
								if(reg==null || (reg.variaveis.get(0).token.image.equals("vetor") || reg.variaveis.get(0).token.image.equals("matriz"))){
									String formato = traduzFormato(var1.tipo.image);
									if(var1.vetor==1 && "%c".equals(formato) )
										str += "%s";
									else
										str += formato;
									var += programaAll.get(k);
								}else{
									var += programaAll.get(k);
									for(int y = k+1; y < programaAll.size(); y++){
										if(programaAll.get(y).equals(".")){
											var += programaAll.get(y);
											Registro registro = registroExiste(var1.tipo.image);

											reg2=null;
											if(registro!=null)
												reg2 = registroExiste(registro.variaveis.get(0).tipo.image);
											if(reg2!=null && !reg2.variaveis.get(0).token.image.equals("vetor") && !reg2.variaveis.get(0).token.image.equals("matriz"))
												registro = reg2;
											
											if(registro!=null){
												for(int t = y+1; t < programaAll.size(); t++){
													if( k == t){
														k--;
														break;
													}
													for (int p = 0; p < registro.variaveis.size(); p++)
											            if (registro.variaveis.get(p).token.image.equals(programaAll.get(t))) {
											            	String formato = traduzFormato(registro.variaveis.get(p).tipo.image);
															if(registro.variaveis.get(p).vetor==1 && "%c".equals(formato) )
																str += "%s";
															else
																str += formato;
											            	var += programaAll.get(t);
											            	
											            	/*if(registro.variaveis.get(p).vetor==1){
																for(int x=t+1; x < programaAll.size(); x++){
																	if(programaAll.get(x).equals("]")){
																		var += programaAll.get(x);
																		t=x;
																		break;
																	}
																	if(programaAll.get(x).equals(",")){
																		var +="][";
																		continue;
																	}
																	var += programaAll.get(x);
																}
															}*/
															k=t+1;
											            	break;
											            }
													//var += programaAll.get(t);
												}
											}else
												k=y+1;
											break;
										}
										if(programaAll.get(y).equals("[")){
											var += programaAll.get(y);
											for(int x=y+1; x < programaAll.size();x++){
												if(programaAll.get(x).equals("]")){
													var += programaAll.get(x);
													y=x;
													break;
												}
												if(programaAll.get(x).equals(",")){
													var +="][";
													continue;
												}
												var += programaAll.get(x);
											}
											continue;
									    }
										var += programaAll.get(y);
									}
								}
							}else{
								boolean c = programaAll.get(k).contains("\"");
								if(c){
									str += programaAll.get(k).replace("\"", "");
									/*int y=0;
									for(y = k+1; y < programaAll.size(); y++){
										if(programaAll.get(y).equals(",")){
											k=y;
											break;
										}
										if(programaAll.get(y).equals(")")){
											EscreverArquivoTraduzido("\""+str+"\""+var+programaAll.get(y),false);
											//System.out.print("\""+str+"\""+var+programaAll.get(y));
											i=y+1;
											break;
										}
										var += programaAll.get(y);
									}
									if(i==y+1){
										break;
									}*/
									continue;
								}
								
								try{
									Double num = Double.parseDouble(programaAll.get(k));
									boolean n = programaAll.get(k).contains(".");
									if(n){
										str += "%f";
									}else{
										str += "%i";
									}
									var += ", "+programaAll.get(k);
					            	continue;
								}catch(NumberFormatException e){
									if(programaAll.get(k).equals("verdadeiro")){
										str += "%i";
						            	var += ", "+"1";
						            	continue;
									}else if (programaAll.get(k).equals("falso")){
										str += "%i";
						            	var += ", "+"0";
						            	continue;
									}
								}
								var += programaAll.get(k);
							}

						}
						break;
					}
					EscreverArquivoTraduzido(programaAll.get(j),false);
					//System.out.print(programaAll.get(j));
				}
				continue;
			}
			
			if(programaAll.get(i).equals("para")){
				String var = new String();
				EscreverArquivoTraduzido("for(",false);
				//System.out.print("for(");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}else{
						if(programaAll.get(j).equals("de")){
							EscreverArquivoTraduzido("=",false);
							//System.out.print("=");
							for(int k = j+1; k < programaAll.size(); k++){
								if(programaAll.get(k).equals(" ") || programaAll.get(k).equals("\n") || programaAll.get(k).equals("\r") || programaAll.get(k).equals("\t")){
									EscreverArquivoTraduzido(programaAll.get(k),false);
									//System.out.print(programaAll.get(k));
								}else{
									if(programaAll.get(k).equals("ate")){
										EscreverArquivoTraduzido(var+" <=",false);
										//System.out.print(var+" <=");
										int passo=0;
										for(int t = k+1; t < programaAll.size(); t++){
											if(programaAll.get(t).equals(" ") || programaAll.get(t).equals("\n") || programaAll.get(t).equals("\r") || programaAll.get(t).equals("\t")){
												EscreverArquivoTraduzido(programaAll.get(t),false);
												//System.out.print(programaAll.get(t));
											}else{
												if(programaAll.get(t).equals("passo")){
													EscreverArquivoTraduzido(var+"="+var+"+",false);
													//System.out.print(var+"="+var+"+");
													for(int y = t+1; y < programaAll.size(); y++){
														if(programaAll.get(y).equals(" ") || programaAll.get(y).equals("\n") || programaAll.get(y).equals("\r") || programaAll.get(y).equals("\t")){
															EscreverArquivoTraduzido(programaAll.get(y),false);
															//System.out.print(programaAll.get(y));
														}else{
															EscreverArquivoTraduzido(programaAll.get(y)+")",false);
															//System.out.print(programaAll.get(y)+")");
															i=y+1;
															break;
														}
													}
													break;
												}else{
													if(passo==1){
														EscreverArquivoTraduzido(var+"++) {",false);
														//System.out.print(") {");
														i=t+1;
														break;
													}
													EscreverArquivoTraduzido(programaAll.get(t)+";",false);
													//System.out.print(programaAll.get(t)+";");
													passo=1;
												}
											}
										}
										break;
									}
									EscreverArquivoTraduzido(programaAll.get(k)+";",false);
									//System.out.print(programaAll.get(k)+";");
								}
							}
							break;
						}
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
						var = programaAll.get(j);
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("fimpara")){
				EscreverArquivoTraduzido("}",false);
				//System.out.print("}");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(";")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("mod")){
				String mod = "";
				//System.out.print("%");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals("(")){
						for(int k = j+1; k < programaAll.size(); k++){
							if(programaAll.get(k).equals(" ") || programaAll.get(k).equals("\n") || programaAll.get(k).equals("\r") || programaAll.get(k).equals("\t")){
								continue;
								//System.out.print(programaAll.get(j));
							}
							mod += programaAll.get(k);
							for(int t = k+1; t < programaAll.size(); t++){
								if(programaAll.get(t).equals(",") || programaAll.get(t).equals(" ") || programaAll.get(t).equals("\n") || programaAll.get(t).equals("\r") || programaAll.get(t).equals("\t")){
									continue;
									//System.out.print(programaAll.get(j));
								}
								mod += "%"+programaAll.get(t);
								EscreverArquivoTraduzido(mod,false);
								for(int u = t+1; u < programaAll.size(); u++){
									if(programaAll.get(u).equals(")")){
										i = u+1;
										break;
										//System.out.print(programaAll.get(j));
									}
								}
								break;
							}
							break;
						}
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("div")){
				String div = "";
				//System.out.print("%");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals("(")){
						for(int k = j+1; k < programaAll.size(); k++){
							if(programaAll.get(k).equals(" ") || programaAll.get(k).equals("\n") || programaAll.get(k).equals("\r") || programaAll.get(k).equals("\t")){
								continue;
								//System.out.print(programaAll.get(j));
							}
							div += programaAll.get(k);
							for(int t = k+1; t < programaAll.size(); t++){
								if(programaAll.get(t).equals(",") || programaAll.get(t).equals(" ") || programaAll.get(t).equals("\n") || programaAll.get(t).equals("\r") || programaAll.get(t).equals("\t")){
									continue;
									//System.out.print(programaAll.get(j));
								}
								div += "/"+programaAll.get(t);
								EscreverArquivoTraduzido(div,false);
								for(int u = t+1; u < programaAll.size(); u++){
									if(programaAll.get(u).equals(")")){
										i = u+1;
										break;
										//System.out.print(programaAll.get(j));
									}
								}
								break;
							}
							break;
						}
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("<>")){
				EscreverArquivoTraduzido("!=",false);
				//System.out.print("!=");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("=")){
				EscreverArquivoTraduzido("==",false);
				//System.out.print("==");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("e")){
				EscreverArquivoTraduzido("&&",false);
				//System.out.print("&&");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("ou")){
				EscreverArquivoTraduzido("||",false);
				//System.out.print("||");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("nao")){
				EscreverArquivoTraduzido("!",false);
				//System.out.print("!");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("ate")){
				EscreverArquivoTraduzido("while",false);
				//System.out.print("while");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("repita")){
				EscreverArquivoTraduzido("do{",false);
				//System.out.print("do{");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("ate")){
				EscreverArquivoTraduzido("while",false);
				//System.out.print("while");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("enquanto")){
				EscreverArquivoTraduzido("while",false);
				//System.out.print("while");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("faca")){
				EscreverArquivoTraduzido("{",false);
				//System.out.print("{");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("fimenquanto")){
				EscreverArquivoTraduzido("}",false);
				//System.out.print("}");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(";")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("escolha")){
				EscreverArquivoTraduzido("switch",false);
				//System.out.print("switch");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}else{
						EscreverArquivoTraduzido(programaAll.get(j)+"{",false);
						//System.out.print(programaAll.get(j)+"{");
						i=j+1;
						break;
					}
				}
				escolha=2;
				continue;
			}
			
			if(programaAll.get(i).equals("caso")){
				String especial = "";
				if(escolha==1){
					EscreverArquivoTraduzido("break;\n"+tempIdentacao,false);
				}
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						especial += programaAll.get(j);
					}else{
						if(programaAll.get(j).equals("contrario")){
							EscreverArquivoTraduzido("default",false);
							//System.out.print("default");
						}else{
							EscreverArquivoTraduzido("case",false);
							//System.out.print("case");
							EscreverArquivoTraduzido(especial,false);
							//System.out.print(especial);
							EscreverArquivoTraduzido(programaAll.get(j),false);
							//System.out.println(programaAll.get(j));
						}						
						i=j+1;
						break;
					}
				}
				if(escolha==2){
					escolha=1;
				}
				continue;
			}
			
			if(programaAll.get(i).equals("fimescolha")){
				escolha=0;
				tempIdentacao="";
				EscreverArquivoTraduzido("}",false);
				//System.out.print("}");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(";")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("se")){
				EscreverArquivoTraduzido("if",false);
				//System.out.print("if");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("senao")){
				EscreverArquivoTraduzido("}else{",false);
				//System.out.print("}else{");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("entao")){
				EscreverArquivoTraduzido("{",false);
				//System.out.print("{");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("fimse")){
				EscreverArquivoTraduzido("}",false);
				//System.out.print("}");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(";")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("<-")){
				EscreverArquivoTraduzido("=",false);
				//System.out.print("=");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("tipo")){
				int op=0;
				for(int v=i+1; v < programaAll.size(); v++){
					if(programaAll.get(v).equals("vetor")){
						op=1;
						break;
					}else if(programaAll.get(v).equals("matriz")){
						op=2;
						break;
					}else if(programaAll.get(v).equals("registro")){
						op=3;
						break;
					}
				}
				if(op==1){
					//continuar depois de tipo
					for(int v=i+1; v < programaAll.size(); v++){
						if(programaAll.get(v).equals(" ") || programaAll.get(v).equals("\n") || programaAll.get(v).equals("\r") || programaAll.get(v).equals("\t")){
							//EscreverArquivoTraduzido(programaAll.get(v),false);
							//System.out.print(programaAll.get(j));
							continue;
						}
						
						for(int l = i+1; l < programaAll.size(); l++){
							if(programaAll.get(l).equals("..")){
								for(int t = l+1; t < programaAll.size(); t++){
									if(programaAll.get(t).equals(" ") || programaAll.get(t).equals("\n") || programaAll.get(t).equals("\r") || programaAll.get(t).equals("\t")){
										continue;
										//System.out.print(programaAll.get(j));
									}
									ArrayList<Integer> aI = new ArrayList<Integer>();
									aI.add(Integer.parseInt(programaAll.get(t)));
									
									vMatriz.add(new vetorMatriz(programaAll.get(v) , aI));
									//System.out.println(programaAll.get(v)+"\n"+programaAll.get(t));
									for(int r = t+1; r < programaAll.size(); r++){
										if(programaAll.get(r).equals(";")){
											i=r+1;
											break;
										}
									}
									//i=t+1;
									break;
								}
								break;
							}
						}
						if(i>v){
							break;
						}
					}					
				}
				if(op==2){
					//continuar depois de tipo
					ArrayList<Integer> aI = new ArrayList<Integer>();
					for(int v=i+1; v < programaAll.size(); v++){
						if(programaAll.get(v).equals(" ") || programaAll.get(v).equals("\n") || programaAll.get(v).equals("\r") || programaAll.get(v).equals("\t")){
							continue;
						}
						int l=0;
						for(l = i+1; l < programaAll.size(); l++){
							if(programaAll.get(l).equals("..")){
								for(int t = l+1; t < programaAll.size(); t++){
									if(programaAll.get(t).equals(" ") || programaAll.get(t).equals("\n") || programaAll.get(t).equals("\r") || programaAll.get(t).equals("\t")){
										continue;
									}
									
									aI.add(Integer.parseInt(programaAll.get(t)));
									
									break;
								}
							}
							if(programaAll.get(l).equals(";")){
								//System.out.println(programaAll.get(v)+"\n"+aI.toString());
								vMatriz.add(new vetorMatriz(programaAll.get(v) , aI));
								i=l+1;
								break;
							}
						}
						if(i>l){
							break;
						}
					}
				}
				if(op==3){
					EscreverArquivoTraduzido("typedef",false);
					//System.out.print("typedef");
					for(int j = i+1; j < programaAll.size(); j++){
						if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
							EscreverArquivoTraduzido(programaAll.get(j),false);
							//System.out.print(programaAll.get(j));
						}else{
							nomerRegistro = programaAll.get(j);
							for(int k = j+1; k < programaAll.size(); k++){
								if(programaAll.get(k).equals("=")){
									EscreverArquivoTraduzido("struct",false);
									//System.out.print("struct");
									for(int t = k+1; t < programaAll.size(); t++){
										if(programaAll.get(t).equals("registro")){
											EscreverArquivoTraduzido(nomerRegistro+"{",false);
											//System.out.print(nomerRegistro+"{");
											i=t+1;
											break;
										}
										EscreverArquivoTraduzido(programaAll.get(t),false);
										//System.out.print(programaAll.get(t));
									}
									break;
								}
								EscreverArquivoTraduzido(programaAll.get(k),false);
								//System.out.print(programaAll.get(k));
							}
							break;
						}
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("fimregistro")){
				EscreverArquivoTraduzido("}"+nomerRegistro,false);
				//System.out.print("}"+nomerRegistro);
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("[")){
				EscreverArquivoTraduzido(programaAll.get(i),false);
				//System.out.print(programaAll.get(i));
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						continue;
						//System.out.print(programaAll.get(j));
					}
					
					//lendo e vetor
					String temp = programaAll.get(j);
					for(int l = j+1; l < programaAll.size(); l++){
						if(programaAll.get(l).equals("..")){
							break;
						}
						if(programaAll.get(l).equals("]")){
							EscreverArquivoTraduzido(temp+programaAll.get(l),false);
							//System.out.print(programaAll.get(z));
							i=l+1;
							temp=null;
							break;
						}
						if(programaAll.get(l).equals(",")){
							temp +="][";
							continue;
						}
						temp += programaAll.get(l);
					}
					if(temp == null) 
						break;
					
					//declaração de vetor
					try{
						int k = Integer.parseInt(programaAll.get(j));
						for(int l = j+1; l < programaAll.size(); l++){
							if(programaAll.get(l).equals("..")){
								for(int t = l+1; t < programaAll.size(); t++){
									if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
										EscreverArquivoTraduzido(programaAll.get(j),false);
										continue;
										//System.out.print(programaAll.get(j));
									}
									/*try{
										int r = Integer.parseInt(programaAll.get(t));
										*/EscreverArquivoTraduzido(programaAll.get(t),false);
										//System.out.print(programaAll.get(t));
										for(int z = t+1; z < programaAll.size(); z++)
											if(programaAll.get(z).equals("]")){
												EscreverArquivoTraduzido(programaAll.get(z),false);
												//System.out.print(programaAll.get(z));
												i=z+1;
												break;
											}
										break;
									/*}catch (NumberFormatException e){
										;
									}*/
								}
								break;
							}
						}
						break;
					}catch(NumberFormatException e){
						;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals(" ") || programaAll.get(i).equals("\r") || programaAll.get(i).equals("\t")){
				if(escolha==2){
					tempIdentacao +=programaAll.get(i);
				}
				EscreverArquivoTraduzido(programaAll.get(i),false);
				i++;
				//System.out.print(programaAll.get(j));
				continue;
			}
			
			if(programaAll.get(i).equals("inteiro")){
				EscreverArquivoTraduzido("int ",false);
				//System.out.print("int ");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(":")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("real")){
				EscreverArquivoTraduzido("float ",false);
				//System.out.print("float ");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(":")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("caractere")){
				EscreverArquivoTraduzido("char ",false);
				//System.out.print("char ");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(":")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("logico")){
				EscreverArquivoTraduzido("int ",false);
				//System.out.print("int ");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
					}
					if(programaAll.get(j).equals(":")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			Registro reg = registroExiste(programaAll.get(i));
			if(reg!=null){
				String decl="";
				for(int k=0; k < vMatriz.size(); k++){
					if(vMatriz.get(k).vetorMatriz.equals(programaAll.get(i))){
						if(reg.variaveis.get(0).tipo.image.equals("inteiro")){
							decl+="int ";
						}else if(reg.variaveis.get(0).tipo.image.equals("real")){
							decl+="float ";
						}else if(reg.variaveis.get(0).tipo.image.equals("caractere")){
							decl+="char ";
						}else if(reg.variaveis.get(0).tipo.image.equals("logico")){
							decl+="int ";
						}else{
							decl+=reg.variaveis.get(0).tipo.image+" ";
						}
						
						for(int j = i+1; j < programaAll.size(); j++){
							if(programaAll.get(j).equals(":")){
								
								for(int y = j+1; y < programaAll.size(); y++){
									if(programaAll.get(y).equals(";")){
										i=y+1;
										EscreverArquivoTraduzido(decl+programaAll.get(y),false);
										break;
									}
									if(programaAll.get(y).equals(",") || programaAll.get(y).equals(" ") || programaAll.get(y).equals("\n") || programaAll.get(y).equals("\r") || programaAll.get(y).equals("\t")){
										decl+=programaAll.get(y);
										continue;
									}
									String indice = "";
									for(int id =0; id < vMatriz.get(k).valor.size(); id++){
										indice+="["+vMatriz.get(k).valor.get(id)+"]";
									}
									decl+=programaAll.get(y)+indice;																
								}
								break;
							}
						}
					}
				}
				if("".equals(decl)){
					EscreverArquivoTraduzido(programaAll.get(i),false);
					//System.out.print(programaAll.get(i));
					for(int j = i+1; j < programaAll.size(); j++){
						if(programaAll.get(j).equals(":")){
							EscreverArquivoTraduzido(" ",false);
							//System.out.print(" ");
							i=j+1;
							break;
						}
					}
				}
				continue;
			}	
			
			if(programaAll.get(i).equals("falso")){
				EscreverArquivoTraduzido("0",false);
				//System.out.print("0");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("verdadeiro")){
				EscreverArquivoTraduzido("1",false);
				//System.out.print("1");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("inicio") && include==0){
				EscreverArquivoTraduzido("#include <stdio.h>",true);
				//System.out.println("#include <stdio.h>");
				EscreverArquivoTraduzido("void main(){",true);
				//System.out.println("void main(){");
				main=1;
				include=1;
				i++;
				continue;
			}else{
				if(programaAll.get(i).equals("inicio") && main==0){
					EscreverArquivoTraduzido("void main(){",false);
					//System.out.println("void main(){");
					main=1;
					i++;
					continue;
				}
			}
			if(programaAll.get(i).equals("inicio")){
				/*for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(" ") || programaAll.get(j).equals("\n") || programaAll.get(j).equals("\r") || programaAll.get(j).equals("\t")){
						;
					}else{
						EscreverArquivoTraduzido(programaAll.get(j),false);
						//System.out.print(programaAll.get(j));
						i=j+1;
						break;
					}
				}*/
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("fim")){
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(";")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals(";")){
				EscreverArquivoTraduzido(programaAll.get(i),false);
				//System.out.print(programaAll.get(i));
				i++;
				continue;
			}
			if(programaAll.get(i).equals("fimalgoritmo")){
				EscreverArquivoTraduzido("//caso você esteja no linux comente a linha abaixo.",true);
				EscreverArquivoTraduzido("system(\"pause\"); //pausa a tela no windows",true);
				EscreverArquivoTraduzido("}",false);
				//System.out.print("}");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("retorne")){
				EscreverArquivoTraduzido("return",false);
				//System.out.print("return");
				i++;
				continue;
			}
			
			if(programaAll.get(i).equals("fimmodulo")){
				EscreverArquivoTraduzido("}",false);
				//System.out.print("}");
				for(int j = i+1; j < programaAll.size(); j++){
					if(programaAll.get(j).equals(";")){
						i=j+1;
						break;
					}
				}
				continue;
			}
			
			if(programaAll.get(i).equals("modulo")){
				for(int j = i+1; j < programaAll.size(); j++){
					Funcao funcao = new Funcao();
					if((funcao = FuncaoExiste(programaAll.get(j))) != null){
						EscreverArquivoTraduzido(traduzTipo(funcao.tipo)+" "+programaAll.get(j),false);
						//System.out.print(traduzTipo(funcao.tipo)+" "+programaAll.get(j));
						for(int k = j+1; k < programaAll.size(); k++){
							if(programaAll.get(k).equals(")")){
								EscreverArquivoTraduzido(programaAll.get(k)+"{",false);
								//System.out.print(programaAll.get(k)+"{");
								i=k+1;
								break;
							}else{
								Registro reg5 = registroExiste(programaAll.get(k));
								if(reg5!=null){
									String decl="";
									for(int h=0; h < vMatriz.size(); h++){
										if(vMatriz.get(h).vetorMatriz.equals(programaAll.get(k))){
											if(reg5.variaveis.get(0).tipo.image.equals("inteiro")){
												decl+="int ";
											}else if(reg5.variaveis.get(0).tipo.image.equals("real")){
												decl+="float ";
											}else if(reg5.variaveis.get(0).tipo.image.equals("caractere")){
												decl+="char ";
											}else if(reg5.variaveis.get(0).tipo.image.equals("logico")){
												decl+="int ";
											}else{
												decl+=reg5.variaveis.get(0).tipo.image+" ";
											}
											
											for(int b = k+1; b < programaAll.size(); b++){
												if(programaAll.get(b).equals(":")){
													
													for(int y = b+1; y < programaAll.size(); y++){
														if(programaAll.get(y).equals(" ") || programaAll.get(y).equals("\n") || programaAll.get(y).equals("\r") || programaAll.get(y).equals("\t")){
															decl+=programaAll.get(y);
															continue;
														}
														String indice = "";
														for(int id =0; id < vMatriz.get(h).valor.size(); id++){
															indice+="["+vMatriz.get(h).valor.get(id)+"]";
														}
														decl+=programaAll.get(y)+indice;	
														k=y;
														EscreverArquivoTraduzido(decl,false);
														break;
													}
													break;
												}
											}
											break;
										}
									}
									if("".equals(decl)){
										EscreverArquivoTraduzido(programaAll.get(k),false);
										//System.out.print(programaAll.get(i));
										for(int b = i+1; b < programaAll.size(); b++){
											if(programaAll.get(b).equals(":")){
												EscreverArquivoTraduzido(" ",false);
												//System.out.print(" ");
												k=b+1;
												break;
											}
										}
									}
								}else{
									String tipo = traduzTipo(programaAll.get(k));
									if(tipo!=null){
										EscreverArquivoTraduzido(tipo+" ",false);
										//System.out.print(tipo);
									}else{
										if(programaAll.get(k).equals(":")){
											continue;
										}
										if(programaAll.get(k).equals("[")){
											EscreverArquivoTraduzido("[",false);
											for(int b = k+1; b < programaAll.size(); b++){
												if(programaAll.get(b).equals("]")){
													k=b;
													EscreverArquivoTraduzido("]",false);
													break;
												}
												if(programaAll.get(b).equals(",")){
													EscreverArquivoTraduzido("][",false);
													continue;
												}
												EscreverArquivoTraduzido(programaAll.get(b),false);
											}
											continue;
										}
										
										EscreverArquivoTraduzido(programaAll.get(k),false);
										//System.out.print(programaAll.get(k));
									}
							  }
							}
						}
						
						break;
					}
				}
				continue;
			}
			
			EscreverArquivoTraduzido(programaAll.get(i),false);
			//System.out.print(programaAll.get(i));
			i++;
		}
	}

	public static void EscreverArquivoTraduzido(String texto,boolean newLine){
    	//Gravando em arquivo os erros semânticos
    	try {
    		File arquivo = new File("C:\\Windows\\Temp\\traducao.txt");
    		
    		FileWriter fw = new FileWriter(arquivo, true);
    		 
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            if(newLine)
            	bw.newLine();
            
            bw.close();
            fw.close();
    	} catch (IOException e) { 
    		e.printStackTrace();
    	}
	}

	private static String traduzTipo(String var){
		//System.out.println(""+var);
		if(var==null){
			return "void";
		}
		if(var.equals("inteiro")){
			return "int";
		}else if(var.equals("real")){
			return "float";
		}else if(var.equals("caractere")){
			return "char";
		}else if(var.equals("logico")){
			return "int";
		}
		return null;
	}
	
	private static String traduzFormato(String var){
		//System.out.println(""+var);
		if(var==null){
			return "";
		}
		
		Registro reg = registroExiste(var);
  	    if(reg!=null && (reg.variaveis.get(0).token.image.equals("vetor") || reg.variaveis.get(0).token.image.equals("matriz")))
	  	  for(int k=0; k < vMatriz.size(); k++){
				if(vMatriz.get(k).vetorMatriz.equals(var)){
					if(reg.variaveis.get(0).tipo.image.equals("inteiro")){
						return "%i";
					}else if(reg.variaveis.get(0).tipo.image.equals("real")){
						return "%f";
					}else if(reg.variaveis.get(0).tipo.image.equals("caractere")){
						return "%c";
					}else if(reg.variaveis.get(0).tipo.image.equals("logico")){
						return "%i";
					}else{
						return reg.variaveis.get(0).tipo.image;
					}
				}
	  	  }
		
		if(var.equals("inteiro")){
			return "%i";
		}else if(var.equals("real")){
			return "%f";
		}else if(var.equals("caractere")){
			return "%c";
		}else if(var.equals("logico")){
			return "%i";
		}
		return "";
	}
	
	private static Variavel VariavelExiste(String variavel) {
		hash aux=null;
        for (int i = 0; i < 10; i++) {
           aux = Telas.TabelaSintatico.tabela[i];
           while (aux != null) {
	  		  if(aux.variavel != null && aux.variavel.token.toString().equals(variavel))
	    		return aux.variavel;
	  		  aux = aux.prox;
	       }
	    }
	    return null;
    }
	
	public static Registro registroExiste(String reg) {
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
	
	private static Funcao FuncaoExiste(String funcao) {
		hash aux=null;
        for (int i = 0; i < 10; i++) {
           aux = Telas.TabelaSintatico.tabela[i];
           while (aux != null) {
	  		  if(aux.funcao != null && aux.funcao.token.toString().equals(funcao))
	    		return aux.funcao;
	  		  aux = aux.prox;
	       }
	    }
	    return null;
    }
	
	@Override
	public String toString() {
		return "TraducaoPortugolEmC [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
