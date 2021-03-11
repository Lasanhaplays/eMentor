/*
 Aplicar o uso de Aquivos Serializados, devendo ter uma classe destinada para 
essa finalidade, contemplando os métodos de salvar e ler em disco genéricos 
para receber vetores/listas de objetos. Também, ter os métodos salvar e ler em 
disco para controlar os últimos índices salvos de alunos e professores 
(prevendo o uso de vetores)
 */
package ementor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable; 


public class Arquivos implements Serializable{
    
    public void salvarNoDisco(Object[] meuObjeto, String nomeArquivo){
       File arquivo = new File(nomeArquivo) ; //Cria fisicamente o arquivo
       try {
           FileOutputStream fout = new FileOutputStream(arquivo); // Criação de saída de arquivo
           ObjectOutputStream ObjetoGravacao = new ObjectOutputStream (fout); // Criação de saída de objeto
           
           ObjetoGravacao.writeObject(meuObjeto);
           
           ObjetoGravacao.flush(); //limpa buffer
           ObjetoGravacao.close(); // Fecha objeto
           fout.close(); // fecha arquivo
           
       }
       catch (Exception ex){
           System.out.println("ERRO: "+ex.toString());
       }
    }
    ///////////////////////////////////////////////////////
    public Object [] lerDoDisco (Object [] vetor, String nomeArquivo){
       File arquivo = new File(nomeArquivo) ; //Cria fisicamente o arquivo
       try {
           
           FileInputStream arquivoFisico = new FileInputStream(arquivo);
           ObjectInputStream OEntrada = new ObjectInputStream (arquivoFisico);
           
           vetor = (Object []) OEntrada.readObject();
           
           OEntrada.close();
           arquivoFisico.close();
           
           
           
       }catch (Exception ex){
           System.out.println("ERRO: "+ex.toString());
       }
       return vetor;
    }
    ///////////////////////////////////////////////////////////////////
    public void salvarNoDiscoIndiceI(int indiceI, String nomeArquivo){
       File arquivo = new File(nomeArquivo) ; //Cria fisicamente o arquivo
       try {
           FileOutputStream fout = new FileOutputStream(arquivo); // Criação de saída de arquivo
           ObjectOutputStream ObjetoGravacao = new ObjectOutputStream (fout); // Criação de saída de objeto
           
           ObjetoGravacao.writeObject(indiceI);
           
           ObjetoGravacao.flush(); //limpa buffer
           ObjetoGravacao.close(); // Fecha objeto
           fout.close(); // fecha arquivo
           
       }
       catch (Exception ex){
           System.out.println("ERRO: "+ex.toString());
       }
    }
    ///////////////////////////////////////////////////////
    public int lerDoDiscoIndiceI (String nomeArquivo){
       File arquivo = new File(nomeArquivo) ; //Cria fisicamente o arquivo
       int indiceI=0;
       try {
           
           FileInputStream arquivoFisico = new FileInputStream(arquivo);
           ObjectInputStream OEntrada = new ObjectInputStream (arquivoFisico);
           
           indiceI = (int) OEntrada.readObject();
           
           OEntrada.close();
           arquivoFisico.close();           
           
           
       }catch (Exception ex){
           System.out.println("ERRO: "+ex.toString());
       }
       return indiceI;
    }
    ///////////////////////////////////////////////////////////////////
    
}
