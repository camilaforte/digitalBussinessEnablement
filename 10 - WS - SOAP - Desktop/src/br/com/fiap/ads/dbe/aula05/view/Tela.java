package br.com.fiap.ads.dbe.aula05.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shlSwtCalcularps;
	private Text txtAm;
	private Text txtNac;
	private Text txtPs;

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
		shlSwtCalcularps.open();
		shlSwtCalcularps.layout();
		while (!shlSwtCalcularps.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSwtCalcularps = new Shell();
		shlSwtCalcularps.setSize(410, 190);
		shlSwtCalcularps.setText("SWT CalcularPS");
		
		txtAm = new Text(shlSwtCalcularps, SWT.BORDER);
		txtAm.setBounds(35, 34, 75, 21);
		
		txtNac = new Text(shlSwtCalcularps, SWT.BORDER);
		txtNac.setBounds(35, 61, 75, 21);
		
		Label lblAm = new Label(shlSwtCalcularps, SWT.NONE);
		lblAm.setBounds(10, 37, 19, 15);
		lblAm.setText("am");
		
		Label lblNac = new Label(shlSwtCalcularps, SWT.NONE);
		lblNac.setBounds(10, 64, 19, 15);
		lblNac.setText("nac");
		
		Button btnCalcular = new Button(shlSwtCalcularps, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			//clique botao
			
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCalcular.setBounds(35, 105, 75, 25);
		btnCalcular.setText("Calcular");
		
		txtPs = new Text(shlSwtCalcularps, SWT.BORDER);
		txtPs.setBounds(189, 34, 120, 48);
		
		Label lblPs = new Label(shlSwtCalcularps, SWT.NONE);
		lblPs.setBounds(237, 13, 19, 15);
		lblPs.setText("ps");

	}
}
