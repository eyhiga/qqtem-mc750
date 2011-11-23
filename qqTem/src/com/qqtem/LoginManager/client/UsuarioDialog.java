package com.qqtem.LoginManager.client;

import javax.swing.JOptionPane;

import com.gargoylesoftware.htmlunit.javascript.host.Popup;
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
import com.google.gwt.user.client.ui.impl.PopupImpl;
import com.google.gwt.dev.util.msg.Message;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class UsuarioDialog extends DialogBox {

	private Usuarios usuarios;
	private TextBox txtbxLogin;
	private TextBox txtbxNome;
	private RadioButton rdbtnMasculino;
	private RadioButton rdbtnFeminino;
	private RadioButton rbState[] = new RadioButton[3];
	private UserData editingUser;
	private boolean saved;
	private RadioButton rdbtnAdmin;
	private RadioButton rdbtnNormal;
	private RadioButton rdbtnBanido;
	
	public UsuarioDialog(Usuarios usr) {
		this.usuarios = usr;
		saved = false;
		setText("Usuário");
		setHTML("<center><h1>Usuário</h1></center>");
		
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("100%", "100%");
		
		Label lblLogin = new Label("Login");
		flexTable.setWidget(0, 0, lblLogin);
		
		txtbxLogin = new TextBox();
		txtbxLogin.setText("Login");
		flexTable.setWidget(0, 1, txtbxLogin);
		
		Label lblNome = new Label("Nome");
		flexTable.setWidget(1, 0, lblNome);
		
		txtbxNome = new TextBox();
		txtbxNome.setText("Nome");
		flexTable.setWidget(1, 1, txtbxNome);
		
		Label lblSexo = new Label("Sexo");
		flexTable.setWidget(2, 0, lblSexo);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setWidget(2, 1, horizontalPanel);
		
		rdbtnMasculino = new RadioButton("gender", "Masculino");
		horizontalPanel.add(rdbtnMasculino);
		
		rdbtnFeminino = new RadioButton("gender", "Feminino");
		horizontalPanel.add(rdbtnFeminino);
		
		Label lblEstado = new Label("Estado");
		flexTable.setWidget(3, 0, lblEstado);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flexTable.setWidget(3, 1, verticalPanel);
		
		rdbtnAdmin = new RadioButton("state", "Admin");
		rdbtnAdmin.setHTML("Administrador");
		verticalPanel.add(rdbtnAdmin);
		
		
		rdbtnNormal = new RadioButton("state", "Normal");
		verticalPanel.add(rdbtnNormal);
		
		rdbtnBanido = new RadioButton("state", "Banido");
		verticalPanel.add(rdbtnBanido);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		flexTable.setWidget(4, 1, horizontalPanel_1);
		
		Button btnSalvar = new Button("Salvar");
		btnSalvar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				editingUser.setLogin(txtbxLogin.getText());
				editingUser.setName(txtbxNome.getText());
				editingUser.setMale(rdbtnMasculino.getValue());
				if(rdbtnAdmin.getValue())
					editingUser.setState(UserData.ADMIN);
				else if(rdbtnBanido.getValue())
					editingUser.setState(UserData.BANNED);
				else
					editingUser.setState(UserData.NORMAL);
				
				usuarios.editUser(editingUser);
				hide();
			}
		});
		horizontalPanel_1.add(btnSalvar);
		
		Button btnCancelar = new Button("Cancelar");
		btnCancelar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				UsuarioDialog.this.hide();
			}
		});
		horizontalPanel_1.add(btnCancelar);
		
		rbState[0] = rdbtnNormal;
		rbState[1] = rdbtnAdmin;
		rbState[2] = rdbtnBanido;
	}
	
	void showUser(UserData user){
		saved = false;
		editingUser = user;
		
		txtbxLogin.setText(user.getLogin());
		txtbxNome.setText(user.getName());
		if(user.isMale())
			rdbtnMasculino.setValue(true);
		else
			rdbtnFeminino.setValue(true);
		
		rbState[user.getState()].setValue(true);
	}

	public UserData getEditingUser(){
		return editingUser;
	}
	
	public boolean wasSaved(){
		return saved;
	}
	

	
}
