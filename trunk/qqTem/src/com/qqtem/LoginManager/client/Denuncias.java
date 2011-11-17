package com.qqtem.LoginManager.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class Denuncias extends Composite {

	public Denuncias() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setWidth("100%");
		
		ListBox comboBox = new ListBox();
		comboBox.addItem("Todos");
		comboBox.addItem("Não tratados");
		comboBox.addItem("Tratados");
		flexTable.setWidget(0, 0, comboBox);
		flexTable.getCellFormatter().setWidth(0, 0, "100");
		TextBox txtboxPesquisa = new TextBox();
		txtboxPesquisa.setWidth("300px");
		flexTable.setWidget(0, 1, txtboxPesquisa);
		
		flexTable.getCellFormatter().setWidth(0, 1, "300px");
		
		Button pesquisar = new Button("Pesquisar");
		flexTable.setWidget(0, 2, pesquisar);
		
		FlexTable tabela = new FlexTable();
		tabela.setStyleName("tableList");
		tabela.getRowFormatter().addStyleName(0, "tableListHeader");
		verticalPanel.add(tabela);
		tabela.setWidth("100%");
		
		tabela.setText(0, 0, "Denúncia");
		tabela.setText(0, 1, "Data");
		tabela.setText(0, 2, "Usuário");
		tabela.setText(0, 3, "Estado");
		tabela.getCellFormatter().setWidth(0, 0, "150");
		tabela.getCellFormatter().setWidth(0, 1, "50");
		tabela.getCellFormatter().setWidth(0, 2, "50");
		tabela.getCellFormatter().setWidth(0, 3, "100");
		
		tabela.setText(1, 0, "Local marcado inexistente");
		tabela.setText(1, 1, "13/10/2011");
		tabela.setText(1, 2, "João");
		tabela.setText(1, 3, "Não tratado");
		
		tabela.setText(2, 0, "Comentário Inapropriado");
		tabela.setText(2, 1, "13/10/2011");
		tabela.setText(2, 2, "Maria");
		tabela.setText(2, 3, "Não tratado");
		
		tabela.setText(3, 0, "Comentário Abusivo");
		tabela.setText(3, 1, "12/10/2011");
		tabela.setText(3, 2, "Pedro");
		tabela.setText(3, 3, "Não tratado");
		
		tabela.setText(4, 0, "Foto inapropriada");
		tabela.setText(4, 1, "12/10/2011");
		tabela.setText(4, 2, "Dexter");
		tabela.setText(4, 3, "Tratado");
		
		tabela.getRowFormatter().addStyleName(1, "tableList-odd");
		tabela.getRowFormatter().addStyleName(2, "tableList-even");
		tabela.getRowFormatter().addStyleName(3, "tableList-odd");
		tabela.getRowFormatter().addStyleName(4, "tableList-even");
	}

}
