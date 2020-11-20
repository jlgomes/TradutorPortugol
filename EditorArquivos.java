package Telas;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class EditorArquivos {
  final private String NOME_SISTEMA = "Editor de Arquivos";
  final private int NUM_LINHAS = 10;
  final private int NUM_COLUNAS = 50;

  final private String MENU_ARQUIVO = "Arquivo";
  final private String MITEM_NOVO = "Novo";
  final private String MITEM_SAIR = "Sair";

  final private String IMAGEM_NOVO = "imagens/new.gif";
	final private String IMAGEM_SAIR = "imagens/quit.gif";
	final private String TOOLTIP_NOVO = "Cria um novo arquivo";
  final private String TOOLTIP_SAIR = "Sai do sistema";

  final private String MENSAGEM = "Entre com o nome do arquivo";
  final private String TITULO = "Novo arquivo";

  private JFrame janela = null;
  private JTextArea areaTexto = null;
  private JLabel barraStatus = null;
  private String nomeArq = " ";

  private class NovoArquivoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			criaNovoArquivo();
    }
	}

	private class SaiSistemaListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				saiSistema();
	    }
	}


  public static void main(String[] args) {
    new EditorArquivos();
  }


  public EditorArquivos() {
    janela = new JFrame(NOME_SISTEMA);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setJMenuBar(criaMenuBar());

    Container cp = janela.getContentPane();
    cp.add(criaBarraFerramentas(), BorderLayout.NORTH);
    cp.add(criaAreaTexto(), BorderLayout.CENTER);
    cp.add(criaBarraStatus(), BorderLayout.SOUTH);

    janela.pack();
    janela.show();
  }


  private JMenuBar criaMenuBar() {
		JMenu menu = null;
		JMenuItem mItem = null;

		JMenuBar mBar = new JMenuBar();

    // Menu Arquivo
    menu = mBar.add(new JMenu(MENU_ARQUIVO));
    menu.setMnemonic(KeyEvent.VK_A);

    // Novo arquivo
    mItem = menu.add(new JMenuItem(MITEM_NOVO));
    mItem.setMnemonic(KeyEvent.VK_N);
    mItem.addActionListener(new NovoArquivoListener());

    // Sair
    menu.addSeparator();
    mItem = menu.add(new JMenuItem(MITEM_SAIR));
    mItem.setMnemonic(KeyEvent.VK_S);
    mItem.addActionListener(new SaiSistemaListener());

    return mBar;
	}


	private JToolBar criaBarraFerramentas() {
		JButton button = null;
		Icon imageIcon = null;

		JToolBar toolBar = new JToolBar();

		// Novo arquivo
		imageIcon = new ImageIcon(IMAGEM_NOVO);
		button = new JButton(imageIcon);
		button.addActionListener(new NovoArquivoListener());
		button.setToolTipText(TOOLTIP_NOVO);
		toolBar.add(button);

		// Sair
		imageIcon = new ImageIcon(IMAGEM_SAIR);
		button = new JButton(imageIcon);
		button.addActionListener(new SaiSistemaListener());
		button.setToolTipText(TOOLTIP_SAIR);
		toolBar.add(button);

    return toolBar;
	}


  private JScrollPane criaAreaTexto() {
		areaTexto = new JTextArea(NUM_LINHAS, NUM_COLUNAS);
		areaTexto.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				atualizaBarraStatus();
			}
		});

    JScrollPane spTexto = new JScrollPane(areaTexto);

    return spTexto;
  }


  private JLabel criaBarraStatus() {
	  barraStatus = new JLabel(" ");
	  return barraStatus;
	}


  private void saiSistema() {
    System.exit(0);
  }


  private void atualizaBarraStatus() {
    int pos = areaTexto.getCaretPosition();
    int linha = 0;
    int coluna = 0;
    try {
      linha = areaTexto.getLineOfOffset(pos);
      coluna = pos - areaTexto.getLineStartOffset(linha);
    }
    catch (Exception e) {}

   	barraStatus.setText("Arquivo: " + nomeArq + "  Linha: " + (linha+1) + "  Coluna: " + (coluna+1));
  }


  private void criaNovoArquivo() {
    String novoNome = JOptionPane.showInputDialog(janela, MENSAGEM, TITULO,
                                                  JOptionPane.QUESTION_MESSAGE);
    if (novoNome != null) {
      nomeArq = novoNome;
      areaTexto.setText("");
      areaTexto.setCaretPosition(0);
      atualizaBarraStatus();
    }
  }

}