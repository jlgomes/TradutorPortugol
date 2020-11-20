package Telas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Arquivo {
	
	public void arquivoTokens(String  text) {
		try{  
			File arquivo = new File("C:\\Windows\\Temp\\ArquivoTokens.txt");
		  
		    // Cria arquivo se ele não existe  
			if (!arquivo.exists()) {
		        //cria um arquivo (vazio)
		        arquivo.createNewFile();
		    }
			FileWriter fw = new FileWriter(arquivo, true);
			 
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(text);
	        
	        bw.close();
	        fw.close();
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public void arquivoErros(String  text) {
		try{  
			File arquivo = new File("C:\\Windows\\Temp\\ArquivoErros.txt");
		  
		    // Cria arquivo se ele não existe  
			if (!arquivo.exists()) {
		        //cria um arquivo (vazio)
		        arquivo.createNewFile();
		    }
			FileWriter fw = new FileWriter(arquivo, true);
			 
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(text);
	        
	        bw.close();
	        fw.close();
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public void arquivoTabela(String  text) {
		try{  
			File arquivo = new File("C:\\Windows\\Temp\\ArquivoTabela.txt");
		  
		    // Cria arquivo se ele não existe  
			if (!arquivo.exists()) {
		        //cria um arquivo (vazio)
		        arquivo.createNewFile();
		    }
			FileWriter fw = new FileWriter(arquivo, true);
			 
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(text);
	        
	        bw.close();
	        fw.close();
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public void AnaliseLexica() throws FileNotFoundException{		
        File arquivo = new File("C:\\Windows\\Temp\\codigoFonte.txt");//../../../../
        
        int j=1,num=1;
        try{
            //faz a leitura do arquivo
            FileReader fr = new FileReader(arquivo);
            
            
            BufferedReader br = new BufferedReader(fr);
            String linha, temp="", str = "";
            int comentario = 0;
            
            //equanto houver mais linhas
            while (br.ready()) {
            	File arquivoobj = new File("C:\\Windows\\Temp\\codigoTemp"+j+".txt");
            	FileWriter fwo = new FileWriter(arquivoobj);
            	BufferedWriter bwo = new BufferedWriter(fwo);
             
                //lê a proxima linha
                linha = br.readLine();
                char palavra [] = linha.toCharArray();
                 
                int k;
                for(k=0; k < palavra.length; k++){
                	if(comentario == 1){
                		if(palavra[k] == '}'){
                			comentario=0;
                			palavra[k] = ' ';
                			break;
                		}else{
                			if(palavra[k] != '}'){
                				palavra[k] = ' ';
                			}                			
                		}
                	}else{
                		if(palavra[k] == '"'){
                			str = ""+palavra[k];
                			palavra[k] = ' ';
                			int p;
                			for(p=k+1; p < palavra.length; p++){
                				if(palavra[p] == '"'){
                					str += palavra[p];
                					bwo.write("\n"+str+"\n");
                					str = "";
                					palavra[p] = ' ';
                					break;
                				}
                				str += palavra[p];
                				palavra[p] = ' ';
                				k++;
                			}
                			bwo.write("\n"+str+"\n");
                    	}
                	}
                	if(palavra[k] == '{'){
                		palavra[k] = ' ';
                		comentario = 1;
                	}
                	
                }
             
                int u;
            	for(u=0; u < palavra.length; u++){
            		temp += palavra[u];
            	}
            	
                String teste [] = temp.split(" ");
                temp = "";
                int i,h ;
                String temporaria="";
                for(i=0; i < teste.length; i++){
                	teste[i] = teste[i].replace(":", " : ");
                	teste[i] = teste[i].replace(";", " ; ");
                	teste[i] = teste[i].replace("/", " / ");
                	teste[i] = teste[i].replace("*", " * ");
                	teste[i] = teste[i].replace("+", " + ");
                	//teste[i] = teste[i].replace(">", " > ");
                	char maior [] = teste[i].toCharArray();
                	for(h=0; h < maior.length; h++){
                		if (maior[h] == '>' && ((h+1) < maior.length)){
                			if((maior[h+1] == '=') || ( (maior[h] == '>' && ( h!=0)) && (maior[h-1] == '<') )){
                				temporaria += maior[h];
                				continue;
                			}
                			temporaria += " "+maior[h]+" ";
                			continue; 			
                		}else{
                			if(maior[h] == '>'){
                				temporaria += " "+maior[h]+" ";
                				continue;
                			}
                		}
                		temporaria += maior[h];
                	}
                	teste[i] = temporaria;
                	temporaria = "";
                	//teste[i] = teste[i].replace("<", " < ");
                	char menor [] = teste[i].toCharArray();
                	for(h=0; h < menor.length; h++){
                		if (menor[h] == '<' && ((h+1) < menor.length)){
                			if(menor[h+1] == '=' || menor[h+1] == '-' || menor[h+1] == '>'){
                				temporaria += menor[h];
                				continue;
                			}else
                			temporaria += " "+menor[h]+" ";
                			continue;
                		}else{
                			if(menor[h] == '<'){
                				temporaria += " "+menor[h]+" ";
                    			continue;
                			}
                		}
                		temporaria += menor[h];
                	}
                	teste[i] = temporaria;
                	temporaria = "";
                	teste[i] = teste[i].replace(">=", " >= ");
                	teste[i] = teste[i].replace("<=", " <= ");
                	//teste[i] = teste[i].replace("=", " = ");
                	char igual [] = teste[i].toCharArray();
                	for(h=0; h < igual.length; h++){
                		if (igual[h] == '=' &&  h!=0){
                			if(igual[h-1] == '>' || igual[h-1] == '<'){
                				temporaria += igual[h];
                				continue;
                			}
                			temporaria += " "+igual[h]+" ";
                			continue;
                		}else{
                			if(igual[h] == '='){
                				temporaria += " "+igual[h]+" ";
                    			continue;
                			}
                		}
                		temporaria += igual[h];
                	}
                	teste[i] = temporaria;
                	temporaria = "";
                	teste[i] = teste[i].replace("<>", " <> ");
                	teste[i] = teste[i].replace("(", " ( ");
                	teste[i] = teste[i].replace(")", " ) ");
                	teste[i] = teste[i].replace("\"", " \" ");
                	teste[i] = teste[i].replace("\\", " \\ ");
                	teste[i] = teste[i].replace("[", " [ ");
                	//teste[i] = teste[i].replace("]", " ] ");
                	char fcolchete [] = teste[i].toCharArray();
                	for(h=0; h < fcolchete.length; h++){
                		if (fcolchete[h] == ']' && ((h+1) < fcolchete.length)){
                			if(fcolchete[h+1] == '.'){
                				temporaria += " "+fcolchete[h];
                				continue;
                			}else
                			temporaria += " "+fcolchete[h]+" ";
                			continue;
                		}else{
                			if(fcolchete[h] == ']'){
                				temporaria += " "+fcolchete[h]+" ";
                    			continue;
                			}
                		}
                		temporaria += fcolchete[h];
                	}
                	teste[i] = temporaria;
                	temporaria = "";
                	
                	teste[i] = teste[i].replace("..", " .. ");
                	//teste[i] = teste[i].replace(",", " , ");
                	
                	char virgula [] = teste[i].toCharArray();
                	temporaria="";
                	for(h=0; h < virgula.length; h++){
                		if (virgula[h] == ',' && h != 0){
                			if((virgula[h-1] == '0') || (virgula[h-1] == '1') || (virgula[h-1] == '2') || (virgula[h-1] == '3') || (virgula[h-1] == '4') || (virgula[h-1] == '5') || (virgula[h-1] == '6') || (virgula[h-1] == '7') || (virgula[h-1] == '8') || (virgula[h-1] == '9')){
                				temporaria += virgula[h];
                				continue;
                			}
                			temporaria += " "+virgula[h]+" ";
                			continue;
                		}else{
                			if(virgula[h] == ','){
                				temporaria += " "+virgula[h]+" ";
                    			continue;
                			}
                		}
                		temporaria += virgula[h];
                	}
                	teste[i] = temporaria;
                	temporaria = "";
                	
                	teste[i] = teste[i].replace(",", " , ");
                	//teste[i] = teste[i].replace("-", " - ");
                	char menos [] = teste[i].toCharArray();
                	for(h=0; h < menos.length; h++){
                		if (menos[h] == '-' && h!=0){
                			if(menos[h-1] == '<'){
                				temporaria += menos[h];
                				continue;
                			}
                			temporaria += " "+menos[h]+" ";
                			continue;
                		}else{
                			if(menos[h] == '-'){
                				temporaria += " "+menos[h]+" ";
                    			continue;
                			}
                		}
                		temporaria += menos[h];
                	}
                	teste[i] = temporaria;
                	temporaria = "";
                	//teste[i] = teste[i].replace(".", " . ");
                	char ponto [] = teste[i].toCharArray();
                	for(h=0; h < ponto.length; h++){
                		if (ponto[h] == '.' && h!=0){
                			if(ponto[h-1] == ']'){
                				temporaria += " "+ponto[h]+" ";
                				continue;
                			}
                		}
                		temporaria += ponto[h];
                	}
                	teste[i] = temporaria;
                	temporaria = "";
                	
                	teste[i] = teste[i].replace("<-", " <- ");
                	
                	String tempora [] = teste[i].split(" ");
                	int t;
                	for(t=0; t < tempora.length; t++){
                		bwo.write(tempora[t]+"\n");
                	}
                }
             	bwo.close();
            	fwo.close();
            	j++;
            }
            j--;
            br.close();
            fr.close();
            int k;
            for(k=1; k<=j; k++){
            	FileReader arqEntrada = new FileReader("C:\\Windows\\Temp\\codigoTemp"+k+".txt");
            	int token;
            	Lexer scanner = new Lexer(arqEntrada);
            	scanner.setNum(num);
            	//obtem o token correspondente
            	do {
            		token = scanner.yylex();
            		//System.out.println(token);
            	}
            	while (token != Lexer.YYEOF);
            	arqEntrada.close();
            	num = scanner.getNum();
            }
            
            for(k=1; k<=j; k++){
            	File arqdelete = new File("C:\\Windows\\Temp\\codigoTemp"+k+".txt");
            	arqdelete.delete();
            }
        	 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
