package com.qqtem.LoginManager.client;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Button;

public class UsuarioDialog extends DialogBox {

	public UsuarioDialog() {
		setText("Usuário");
		setHTML("<center><h1>Usuário</h1></center>");
		
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("100%", "100%");
		
		Label lblLogin = new Label("Login");
		flexTable.setWidget(0, 0, lblLogin);
		
		TextBox txtbxLogin = new TextBox();
		txtbxLogin.setText("Login");
		flexTable.setWidget(0, 1, txtbxLogin);
		
		Label lblNome = new Label("Nome");
		flexTable.setWidget(1, 0, lblNome);
		
		TextBox txtbxNome = new TextBox();
		txtbxNome.setText("Nome");
		flexTable.setWidget(1, 1, txtbxNome);
		
		Label lblSexo = new Label("Sexo");
		flexTable.setWidget(2, 0, lblSexo);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setWidget(2, 1, horizontalPanel);
		
		RadioButton rdbtnMasculino = new RadioButton("new name", "Masculino");
		horizontalPanel.add(rdbtnMasculino);
		
		RadioButton rdbtnFeminino = new RadioButton("new name", "Feminino");
		horizontalPanel.add(rdbtnFeminino);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		flexTable.setWidget(3, 1, horizontalPanel_1);
		
		Button btnSalvar = new Button("Salvar");
		horizontalPanel_1.add(btnSalvar);
		
		Button btnCancelar = new Button("Cancelar");
		horizontalPanel_1.add(btnCancelar);
	}
}
