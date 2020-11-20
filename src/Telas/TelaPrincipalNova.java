package Telas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import javax.swing.event.CaretEvent;
//import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Sub_Zero
 */
public class TelaPrincipalNova extends javax.swing.JFrame {

	Arquivo arq2 = new Arquivo();
	
    /**
     * Creates new form TelaPrincipalNova
     */
    public TelaPrincipalNova() {
        initComponents();
        try {
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoFonte.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoObjeto.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTokens.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTabela.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoErros.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\erroSemantico.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\traducao.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
        atualizaBarraStatusPortugol();
        atualizaBarraStatusLing_C();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        fileChooserAbrir = new javax.swing.JFileChooser();
        fileChooserSalvarPortugol = new javax.swing.JFileChooser();
        fileChooserSalvar_C = new javax.swing.JFileChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTraduzir = new javax.swing.JButton();
        jLimparPortugol = new javax.swing.JButton();
        jLimparC = new javax.swing.JButton();
        jStatusPortugol = new javax.swing.JLabel();
        jStatusLing_C = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPanePortugol = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPortugol = new javax.swing.JTextArea();
        jTabbedPaneLing_C = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextC = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jArquivo = new javax.swing.JMenu();
        jAbrir = new javax.swing.JMenuItem();
        jSalvarPortugol = new javax.swing.JMenuItem();
        jSalvarLing_C = new javax.swing.JMenuItem();
        jSair = new javax.swing.JMenuItem();
        jAjuda = new javax.swing.JMenu();
        jExemplos = new javax.swing.JMenuItem();
        jSobre = new javax.swing.JMenuItem();

        fileChooserAbrir.setApproveButtonToolTipText("");
        fileChooserAbrir.setDialogTitle("Selecione um arquivo .port");
        fileChooserAbrir.setFileFilter( new MyCustomFilter());
        fileChooserAbrir.setFocusCycleRoot(true);

        fileChooserSalvarPortugol.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileChooserSalvarPortugol.setApproveButtonToolTipText("");
        fileChooserSalvarPortugol.setDialogTitle("Salve um arquivo .port");
        fileChooserSalvarPortugol.setFileFilter( new MyCustomFilter());
        fileChooserSalvarPortugol.setFocusCycleRoot(true);

        fileChooserSalvar_C.setApproveButtonToolTipText("");
        fileChooserSalvar_C.setDialogTitle("Salve um arquivo .c");
        fileChooserSalvar_C.setFileFilter(new MyCustomFilter_C());
        fileChooserSalvar_C.setFocusCycleRoot(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tradutor de Portugol para a Linguagem C");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Linguagem C");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Portugol");

        jTraduzir.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jTraduzir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/setaDir.png"))); // NOI18N
        jTraduzir.setToolTipText("Traduzir");
        jTraduzir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTraduzirActionPerformed(evt);
            }
        });

        jLimparPortugol.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLimparPortugol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/vassoura.png"))); // NOI18N
        jLimparPortugol.setToolTipText("Limpar Portugol");
        jLimparPortugol.setBorder(null);
        jLimparPortugol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimparPortugolActionPerformed(evt);
            }
        });

        jLimparC.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLimparC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/vassoura.png"))); // NOI18N
        jLimparC.setToolTipText("Limpar Linguagem C");
        jLimparC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimparCActionPerformed(evt);
            }
        });

        jStatusPortugol.setText("Linha:   Coluna: ");

        jStatusLing_C.setText("Linha:   Coluna: ");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/console.jpg"))); // NOI18N
        jLabel1.setToolTipText("Console");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jTabbedPanePortugol.setToolTipText("");
        jTabbedPanePortugol.setMinimumSize(new java.awt.Dimension(49, 51));

        jTextPortugol.setColumns(20);
        jTextPortugol.setRows(5);
        jTextPortugol.setToolTipText("");
        jTextPortugol.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextPortugol.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextPortugol.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextPortugolCaretUpdate(evt);
            }
        });
        jScrollPane7.setViewportView(jTextPortugol);

        jTabbedPanePortugol.addTab("novo.port", jScrollPane7);

        jTabbedPaneLing_C.setToolTipText("");

        jTextC.setColumns(20);
        jTextC.setRows(5);
        jTextC.setToolTipText("");
        jTextC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextC.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextCCaretUpdate(evt);
            }
        });
        jScrollPane6.setViewportView(jTextC);

        jTabbedPaneLing_C.addTab("novo.c", jScrollPane6);

        jArquivo.setText("Arquivo");

        jAbrir.setText("Abrir");
        jAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrirActionPerformed(evt);
            }
        });
        jArquivo.add(jAbrir);

        jSalvarPortugol.setText("Salvar (Portugol)");
        jSalvarPortugol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarPortugolActionPerformed(evt);
            }
        });
        jArquivo.add(jSalvarPortugol);

        jSalvarLing_C.setText("Salvar (Ling. C)");
        jSalvarLing_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarLing_CActionPerformed(evt);
            }
        });
        jArquivo.add(jSalvarLing_C);

        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });
        jArquivo.add(jSair);

        jMenuBar1.add(jArquivo);

        jAjuda.setText("Ajuda");

        jExemplos.setText("Exemplos");
        jExemplos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExemplosActionPerformed(evt);
            }
        });
        jAjuda.add(jExemplos);

        jSobre.setText("Sobre");
        jSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSobreActionPerformed(evt);
            }
        });
        jAjuda.add(jSobre);

        jMenuBar1.add(jAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(99, 99, 99)
                                            .addComponent(jLimparPortugol))
                                        .addComponent(jStatusPortugol)))
                                .addComponent(jTabbedPanePortugol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTraduzir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPaneLing_C, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLimparC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jStatusLing_C, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLimparPortugol)
                    .addComponent(jLabel3)
                    .addComponent(jLimparC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPanePortugol, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(jTabbedPaneLing_C, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(jTraduzir)
                        .addGap(153, 153, 153)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jStatusPortugol)
                        .addComponent(jStatusLing_C)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jLimparCActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	jTextC.setText("");
    	try {
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoFonte.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoObjeto.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTokens.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTabela.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoErros.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\erroSemantico.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\traducao.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
        atualizaBarraStatusLing_C();
    }                                        

    private void jLimparPortugolActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	jTextPortugol.setText("");
    	try {
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoFonte.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoObjeto.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTokens.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTabela.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoErros.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\erroSemantico.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\traducao.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	atualizaBarraStatusPortugol();
    }                                               

    private void jTraduzirActionPerformed(java.awt.event.ActionEvent evt) { 
    	jTextArea1.setText("");
    	//Erro erro = new Erro();
    	int erroLexico=0;
		int erroSintatico=0;
		int erroSemantico=0;
    	
    	//criar ou deletar o arquivo caso ele j� existir -- evitando lixo de mem�ria!
    	try {
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoFonte.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\codigoObjeto.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTokens.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoTabela.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\ArquivoErros.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\erroSemantico.txt");
			CriarOuDeletarArquivo("C:\\Windows\\Temp\\traducao.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//Gravando em arquivo o conte�do do TextArea do Portugol
    	try {
    		File arquivo = new File("C:\\Windows\\Temp\\codigoFonte.txt");
    		
    		FileWriter fw = new FileWriter(arquivo, true);
    		 
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(jTextPortugol.getText());
            bw.newLine();
            
            bw.close();
            fw.close();
            
            //Chamar o met�do que faz a An�lise L�xica
            arq2.AnaliseLexica();
            
    	} catch (IOException e) { 
    		e.printStackTrace();
    	}
    	
    	//Gravar a tabela hash em Arquivo
    	Tabela.mostrarhash();
    	
    	try {
			//Gravando em arquivo o conte�do do TextArea do Portugol
    		File arquivoerro = new File("C:\\Windows\\Temp\\ArquivoErros.txt");
    		
    		Reader fwo = new FileReader(arquivoerro);
   		 
			BufferedReader bwo = new BufferedReader(fwo);
			String linha;
			linha = bwo.readLine();
			if(linha!=null)
				erroLexico=1;
			
			while (linha != null){
				jTextArea1.setText(jTextArea1.getText() +"    "+ linha + "\n");
				linha = bwo.readLine();
			}
			
			bwo.close();
			fwo.close();
    	} catch (IOException e) { 
    		e.printStackTrace();
    	}
    	
    	//chamando o analisador sintatico
        try {
			EG3 eg = new EG3("C:\\Windows\\Temp\\codigoFonte.txt");
			if(eg.simerro==1){
	        	jTextArea1.setText(jTextArea1.getText()+"     - "+eg.erro);
	        	erroSintatico=1;
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        //impress�o dos erros sem�nticos
        try {
			//Gravando em arquivo o conte�do do TextArea do Portugol
    		File arquivoerro = new File("C:\\Windows\\Temp\\erroSemantico.txt");
    		
    		Reader fwo = new FileReader(arquivoerro);
   		 
			BufferedReader bwo = new BufferedReader(fwo);
			String linha;
			linha = bwo.readLine();
			if(linha!=null)
				erroSemantico=1;
			
			while (linha != null){
				jTextArea1.setText(jTextArea1.getText() +"     - "+ linha + "\n");
				linha = bwo.readLine();
			}
			
			bwo.close();
			fwo.close();
    	} catch (IOException e) { 
    		e.printStackTrace();
    	}
        
		if(erroLexico==1 || erroSintatico==1 || erroSemantico==1){
        	jTextArea1.setCaretPosition(0);
        }else{
        	try {
    			//Gravando em arquivo o conte�do do TextArea do Portugol
        		File arquivoTraduzido = new File("C:\\Windows\\Temp\\traducao.txt");
        		
        		Reader fwo = new FileReader(arquivoTraduzido);
       		 
    			BufferedReader bwo = new BufferedReader(fwo);
    			String linha;
    			linha = bwo.readLine();
    			jTextC.setText("");
    			while (linha != null){
    				jTextC.setText(jTextC.getText()+linha+"\n");
    				linha = bwo.readLine();
    			}
    			
    			bwo.close();
    			fwo.close();
    			jTextC.setCaretPosition(0);
        	} catch (IOException e) { 
        		e.printStackTrace();
        	}        	
        	JOptionPane.showMessageDialog (null, "Traduzido com sucesso!\n", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
        }
        Tabela.excluirtabelahash();
    }                                         

    private void jAbrirActionPerformed(java.awt.event.ActionEvent evt) {                                       
        int returnVal = fileChooserAbrir.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooserAbrir.getSelectedFile();
            try {
              // What to do with the file, e.g. display it in a TextArea
              jTextPortugol.read( new FileReader( file.getAbsolutePath() ), null );
              
              //Colocar o nome do arquivo no textArea
              jTabbedPanePortugol.setTitleAt(0, file.getName());
            } catch (IOException ex) {
              ex.printStackTrace();
            }
        }
    }                                      

    private void jSalvarPortugolActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int returnVal = fileChooserSalvarPortugol.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try{
                File arq = fileChooserSalvarPortugol.getSelectedFile();
                String pathArquivo = arq.getPath().replace(".port", "")+".port";
                
                CriarOuDeletarArquivo(pathArquivo);
                
                File arquivo = new File(pathArquivo);
                FileWriter fw = new FileWriter(arquivo, true);

                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(jTextPortugol.getText());
                bw.newLine();

                bw.close();
                fw.close();
                //Colocar o nome do arquivo no textArea
                jTabbedPanePortugol.setTitleAt(0, arq.getName().replace(".port", "")+".port");
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }                                               

    private void jSalvarLing_CActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int returnVal = fileChooserSalvar_C.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try{
                File arq = fileChooserSalvar_C.getSelectedFile();
                String pathArquivo = arq.getPath().replace(".c", "")+".c";
                
                CriarOuDeletarArquivo(pathArquivo);
                
                File arquivo = new File(pathArquivo);
                FileWriter fw = new FileWriter(arquivo, true);

                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(jTextC.getText());
                bw.newLine();

                bw.close();
                fw.close();
                //Colocar o nome do arquivo no textArea
                jTabbedPaneLing_C.setTitleAt(0, arq.getName().replace(".c", "")+".c");
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }                                             

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {                                      
        System.exit(0);
    }                                     

    private void jSobreActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Sobre sobre = new Sobre();
        sobre.show();
    }                                      

    private void jExemplosActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Exemplos exemplos = new Exemplos();
        exemplos.show();
    }                                         

    private void jTextPortugolCaretUpdate(javax.swing.event.CaretEvent evt) {                                          
        /*jTextPortugol.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				atualizaBarraStatusPortugol();
			}
        });*/
        atualizaBarraStatusPortugol();
    }                                         

    private void jTextCCaretUpdate(javax.swing.event.CaretEvent evt) {                                   
        atualizaBarraStatusLing_C();
    }                                  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalNova().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JFileChooser fileChooserAbrir;
    private javax.swing.JFileChooser fileChooserSalvarPortugol;
    private javax.swing.JFileChooser fileChooserSalvar_C;
    private javax.swing.JMenuItem jAbrir;
    private javax.swing.JMenu jAjuda;
    private javax.swing.JMenu jArquivo;
    private javax.swing.JMenuItem jExemplos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLimparC;
    private javax.swing.JButton jLimparPortugol;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jSair;
    private javax.swing.JMenuItem jSalvarLing_C;
    private javax.swing.JMenuItem jSalvarPortugol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JMenuItem jSobre;
    private javax.swing.JLabel jStatusLing_C;
    private javax.swing.JLabel jStatusPortugol;
    private javax.swing.JTabbedPane jTabbedPaneLing_C;
    private javax.swing.JTabbedPane jTabbedPanePortugol;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextC;
    private javax.swing.JTextArea jTextPortugol;
    private javax.swing.JButton jTraduzir;
    // End of variables declaration                   

    private void CriarOuDeletarArquivo (String arq) throws IOException{
    	File arquivo = new File(arq);
    	if (!arquivo.exists()) {
	        //cria um arquivo (vazio)
	        arquivo.createNewFile();
	    }else{
	        arquivo.delete();
	        arquivo.createNewFile();
	    }
    }
    
    private static class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".port");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Algoritmos portugol (*.port)";
        }
    }

    private static class MyCustomFilter_C extends FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".c");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Linguagem C (*.c)";
        }
    }
    
    private void atualizaBarraStatusPortugol() {
    int pos = jTextPortugol.getCaretPosition();
    int linha = 0;
    int coluna = 0;
    try {
      linha = jTextPortugol.getLineOfOffset(pos);
      coluna = pos - jTextPortugol.getLineStartOffset(linha);
    }
    catch (Exception e) {}

   	jStatusPortugol.setText("Linha: " + (linha+1) + "  Coluna: " + (coluna+1));
  }
    
  private void atualizaBarraStatusLing_C() {
    int pos = jTextC.getCaretPosition();
    int linha = 0;
    int coluna = 0;
    try {
      linha = jTextC.getLineOfOffset(pos);
      coluna = pos - jTextC.getLineStartOffset(linha);
    }
    catch (Exception e) {}

   	jStatusLing_C.setText("Linha: " + (linha+1) + "  Coluna: " + (coluna+1));
  }
}