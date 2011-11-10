package com.qqtem.LoginManager.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Login extends Composite {
	private TextBox textBoxUsername;
	private TextBox textBoxPassword;

	public Login() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		Label lblLogin = new Label("Login:");
		verticalPanel.add(lblLogin);
		
		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		
		Label lblUsurio = new Label("Usuário:");
		flexTable.setWidget(0, 0, lblUsurio);
		
		textBoxUsername = new TextBox();
		flexTable.setWidget(0, 1, textBoxUsername);
		
		Label lblSenha = new Label("Senha:");
		flexTable.setWidget(1, 0, lblSenha);
		
		textBoxPassword = new TextBox();
		flexTable.setWidget(1, 1, textBoxPassword);
		
		final Label lblErrorLabel = new Label("");
		flexTable.setWidget(2, 1, lblErrorLabel);
		
		CheckBox chckbxMantenhameLogado = new CheckBox("Mantenha-me logado!");
		flexTable.setWidget(3, 1, chckbxMantenhameLogado);
		
		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if ((textBoxUsername.getText().length() == 0) || (textBoxPassword.getText().length() == 0)) {
					lblErrorLabel.setText("Usuário ou senha inválidos.");
				}
				else {
					LoginManager.realizaLogin();
				}
			}
		});
		btnNewButton.setText("Logar!");
		flexTable.setWidget(4, 1, btnNewButton);
	}

}
