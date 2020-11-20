package Telas;
import java.util.Scanner;
 
public class Tabela {
 
    public static class hash {
 
        int chave;
        String token;
        hash prox;
    }
 
    static int tam = 10;
    static hash tabela[] = new hash[10];
    static Scanner entrada = new Scanner(System.in);
    static Arquivo arq2 = new Arquivo();
 
    public static int inserir(int pos, int n, String token) {
    	hash aux;
    	int existe = 0;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            while (aux != null) {
                if(aux.token.equals(token.trim())){
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
        	novo = new hash();
        	novo.chave = n;
        	novo.token = token.trim();
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
            	//System.out.println("id: " + aux.chave + " Token: "+ aux.token);
                arq2.arquivoTabela("id: " + aux.chave + " Token: "+ aux.token +"\n");
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