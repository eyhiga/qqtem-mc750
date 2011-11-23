package com.qqtem.LoginManager.client;

import java.util.Vector;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellBrowser;
import com.google.gwt.view.client.TreeViewModel;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel.AbstractSelectionModel;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.TreeViewModel.NodeInfo;
import com.google.gwt.view.client.TreeViewModel.DefaultNodeInfo;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.ibm.icu.impl.LocaleDisplayNamesImpl.DataTable;
import com.google.gwt.user.client.ui.Label;

public class Usuarios extends Composite {
	private Vector<UserData> usuarios;
	private FlexTable dataTable;
	private UsuarioDialog dialog;
	private TextBox textBox;
	private ListBox comboBox_1;
	private ListBox comboBox;
	
	public Usuarios() {
		dialog = new UsuarioDialog(this);
		usuarios = new Vector<UserData>();
		
		FlexTable flexTable = new FlexTable();
		initWidget(flexTable);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		flexTable.setWidget(0, 0, horizontalPanel);
		
		Label lblSexo = new Label("Sexo:");
		horizontalPanel.add(lblSexo);
		horizontalPanel.setCellVerticalAlignment(lblSexo, HasVerticalAlignment.ALIGN_MIDDLE);
		
		comboBox = new ListBox();
		horizontalPanel.add(comboBox);
		comboBox.addItem("Qualquer");
		comboBox.addItem("Masculino");
		comboBox.addItem("Feminino");
		comboBox.setWidth("98px");
		
		Label lblEstado = new Label("Estado:");
		horizontalPanel.add(lblEstado);
		horizontalPanel.setCellVerticalAlignment(lblEstado, HasVerticalAlignment.ALIGN_MIDDLE);
		
		
		comboBox_1 = new ListBox();
		horizontalPanel.add(comboBox_1);
		comboBox_1.addItem("Qualquer");
		comboBox_1.addItem("Normal");
		comboBox_1.addItem("Administrador");
		comboBox_1.addItem("Banido");
		
		
		textBox = new TextBox();
		horizontalPanel.add(textBox);
		textBox.setWidth("356px");
		
		Button btnPesquisar = new Button("Pesquisar");
		horizontalPanel.add(btnPesquisar);
		flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
		btnPesquisar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dataTable.removeAllRows();
				createTableHeaders();
				String pattern = textBox.getText();
				boolean anySex = comboBox.getSelectedIndex()==0;
				boolean male = comboBox.getSelectedIndex()==1;
				int state = comboBox_1.getSelectedIndex()-1;
				
				for (UserData user : usuarios) {
					if(user.getName().indexOf(pattern)<0 && user.getLogin().indexOf(pattern)<0)
						continue;
					if(user.isMale()!=male && !anySex)
						continue;
					if(state!=-1 && user.getState()!=state)
						continue;
					
					addUserToTable(user);
				}
			}
		});
		
		dataTable = new FlexTable();
		flexTable.setWidget(2, 0, dataTable);
		dataTable.setSize("100%", "100%");
		
		createTableHeaders();
		
		adicionaUsuario("Joao", "jojo22", true , UserData.NORMAL);
		adicionaUsuario("gangster", "gang1337", true ,UserData.BANNED);
		adicionaUsuario("Maria Joana", "marylu", false ,UserData.NORMAL);
		adicionaUsuario("Administrador","admSkyrim",true ,UserData.ADMIN);
		
		
		
		dataTable.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int index = dataTable.getCellForEvent(event).getRowIndex();
				UserData user=getUserByLogin(dataTable.getText(index, 1));
				if (user!=null){
					openUserDialog(user);
				}
			}
		});
		
	}
	
	private void openUserDialog(UserData user){
		dialog.showUser(user);
		dialog.center();
	}
	
	public void adicionaUsuario(String nome, String login,boolean male,int estado){
		usuarios.add(new UserData(usuarios.size(), nome, login,male, estado));
		addUserToTable(usuarios.lastElement());
		

	}
	
	public void addUserToTable(UserData usr){
		int row =dataTable.getRowCount();
		dataTable.setText(row , 0, usr.getName());
		dataTable.setText(row , 1, usr.getLogin());
		dataTable.setText(row , 2, usr.isMale()? "Masculino":"Feminino");
		dataTable.setText(row , 3, getUserStateString(usr.getState()));
		dataTable.getRowFormatter().addStyleName(
				row, row%2==0? "tableList-odd":"tableList-even");
	}
	
	public String getUserStateString(int state){
		switch(state){
		case UserData.ADMIN:
			return "Administrador";
		case UserData.BANNED:
			return "Banido";
		case UserData.NORMAL:
			return "Normal";
		default:
			return "Desconhecido";
		}

	}
	
	
	public void editUser(UserData editingUser) {
		int id = editingUser.getId();
		
		dataTable.setText(id+1, 0, editingUser.getName());
		dataTable.setText(id+1, 1, editingUser.getLogin());
		dataTable.setText(id+1, 2, editingUser.isMale()? "Masculino":"Feminino");
		dataTable.setText(id+1, 3, getUserStateString(editingUser.getState()));
		
	}
	
	public UserData getUserByLogin(String login){
		for (UserData user : usuarios) {
			if(user.getLogin().compareTo(login)==0)
				return user;
		}
		return null;
	}
	
	public void createTableHeaders(){
		dataTable.setText(0, 0, "Nome");
		dataTable.setText(0, 1, "Login");
		dataTable.setText(0, 2, "Sexo");
		dataTable.setText(0, 3, "Estado");
		
		dataTable.getCellFormatter().addStyleName(0,0,"tableListHeader");
		dataTable.getCellFormatter().addStyleName(0,1,"tableListHeader");
		dataTable.getCellFormatter().addStyleName(0,2,"tableListHeader");
		dataTable.getCellFormatter().addStyleName(0,3,"tableListHeader");
	}
	
	
}
