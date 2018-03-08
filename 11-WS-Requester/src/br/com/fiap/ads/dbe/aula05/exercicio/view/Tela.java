package br.com.fiap.ads.dbe.aula05.exercicio.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.ads.dbe.aula05.exercicio.repository.ChamaWS;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.ProdutoTO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtCodigo;
	private Text txtDescricao;
	private Text txtQtidade;
	private Text txtValor;
	private Label lblDescrio;
	private Label lblQtidade;
	private Label lblValor;
	private Label lblInformaesDoProduto;
	private Label lblErro;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(369, 230);
		shell.setText("SWT Application");
		
		Label lblCodigoProduto = new Label(shell, SWT.NONE);
		lblCodigoProduto.setBounds(30, 47, 102, 15);
		lblCodigoProduto.setText("Codigo Produto");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(138, 41, 76, 21);
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				
				try {
					ChamaWS ch = new ChamaWS();
					ProdutoTO produto = ch.buscarProduto(codigo);
					txtDescricao.setText(produto.getDescricao());
					txtQtidade.setText(String.valueOf(produto.getQti()));
					txtValor.setText(String.valueOf(produto.getPreco()));
				} catch (RemoteException e1) {
					lblErro.setText("Erro do ws");
				}
				
			}
			
			
		
		});
		btnOk.setBounds(238, 37, 75, 25);
		btnOk.setText("OK");
		
		txtDescricao = new Text(shell, SWT.BORDER);
		txtDescricao.setBounds(30, 100, 143, 21);
		
		txtQtidade = new Text(shell, SWT.BORDER);
		txtQtidade.setBounds(30, 129, 143, 21);
		
		txtValor = new Text(shell, SWT.BORDER);
		txtValor.setBounds(30, 160, 143, 21);
		
		lblDescrio = new Label(shell, SWT.NONE);
		lblDescrio.setBounds(179, 103, 55, 15);
		lblDescrio.setText("Descri\u00E7\u00E3o");
		
		lblQtidade = new Label(shell, SWT.NONE);
		lblQtidade.setBounds(179, 132, 55, 15);
		lblQtidade.setText("Qtidade");
		
		lblValor = new Label(shell, SWT.NONE);
		lblValor.setBounds(179, 166, 55, 15);
		lblValor.setText("Valor");
		
		lblInformaesDoProduto = new Label(shell, SWT.NONE);
		lblInformaesDoProduto.setBounds(30, 79, 158, 15);
		lblInformaesDoProduto.setText("Informa\u00E7\u00F5es do produto");
		
		lblErro = new Label(shell, SWT.NONE);
		lblErro.setBounds(146, 10, 55, 15);

	}

}
