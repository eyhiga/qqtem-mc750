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
	}

}
