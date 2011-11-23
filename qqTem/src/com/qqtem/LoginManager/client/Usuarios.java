package com.qqtem.LoginManager.client;

import java.util.Vector;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.client.ui.Composite;
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

public class Usuarios extends Composite {
	private Vector<UserData> usuarios;
	private FlexTable dataTable;
	private UsuarioDialog dialog;
	
	public Usuarios() {
		dialog = new UsuarioDialog(this);
		usuarios = new Vector<UserData>();
		
		FlexTable flexTable = new FlexTable();
		initWidget(flexTable);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable.setWidget(0, 0, horizontalPanel);
		
		ListBox comboBox = new ListBox();
		horizontalPanel.add(comboBox);
		comboBox.addItem("Todos");
		comboBox.setWidth("98px");
		
		TextBox textBox = new TextBox();
		horizontalPanel.add(textBox);
		textBox.setWidth("356px");
		
		Button btnPesquisar = new Button("Pesquisar");
		horizontalPanel.add(btnPesquisar);
		flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
		
		dataTable = new FlexTable();
		flexTable.setWidget(1, 0, dataTable);
		dataTable.setSize("100%", "100%");
		
		dataTable.setText(0, 0, "Nome");
		dataTable.setText(0, 1, "Login");
		dataTable.setText(0, 2, "Sexo");
		dataTable.setText(0, 3, "Estado");
		
		dataTable.getCellFormatter().addStyleName(0,0,"tableListHeader");
		dataTable.getCellFormatter().addStyleName(0,1,"tableListHeader");
		dataTable.getCellFormatter().addStyleName(0,2,"tableListHeader");
		dataTable.getCellFormatter().addStyleName(0,3,"tableListHeader");
		
		adicionaUsuario("Joao", "jojo22", true , UserData.NORMAL);
		adicionaUsuario("gangster", "gang1337", true ,UserData.BANNED);
		adicionaUsuario("Maria Joana", "marylu", false ,UserData.NORMAL);
		adicionaUsuario("Administrador","admSkyrim",true ,UserData.ADMIN);
		
		
		
		dataTable.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int index = dataTable.getCellForEvent(event).getRowIndex();
				if(index>0){
					openUserDialog(index-1);
				}
			}

		});
		
	}
	
	private void openUserDialog(int index){
		System.out.println(usuarios.elementAt(index).getId());
		dialog.showUser(usuarios.elementAt(index));
		dialog.center();
	}
	public void adicionaUsuario(String nome, String login,boolean male,int estado){
		usuarios.add(new UserData(usuarios.size(), nome, login,male, estado));
		
		System.out.println(usuarios.lastElement().getId());
		
		dataTable.setText(usuarios.size(), 0, nome);
		dataTable.setText(usuarios.size(), 1, login);
		dataTable.setText(usuarios.size(), 2, male? "Masculino":"Feminino");
		dataTable.setText(usuarios.size(), 3, getUserStateString(estado));
		dataTable.getRowFormatter().addStyleName(
				usuarios.size(), usuarios.size()%2==0? "tableList-odd":"tableList-even");
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
		
//		System.out.println(id);
		dataTable.setText(id+1, 0, editingUser.getName());
		dataTable.setText(id+1, 1, editingUser.getLogin());
		dataTable.setText(id+1, 2, editingUser.isMale()? "Masculino":"Feminino");
		dataTable.setText(id+1, 3, getUserStateString(editingUser.getState()));
		
	}
	
	
}
