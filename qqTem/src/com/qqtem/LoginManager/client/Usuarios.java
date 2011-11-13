package com.qqtem.LoginManager.client;

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
import com.google.gwt.user.client.ui.ListBox;

public class Usuarios extends Composite {

	public Usuarios() {
		
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
		
		FlexTable dataTable = new FlexTable();
		flexTable.setWidget(1, 0, dataTable);
		dataTable.setSize("100%", "100%");
		
		dataTable.setText(0, 0, "Selecionar");
		dataTable.setText(0, 1, "Login");
		dataTable.setText(0, 2, "Nome");
		dataTable.setText(0, 3, "Estado");
		
		for (int i = 0; i < dataTable.getCellCount(0); i++) {
			comboBox.addItem(dataTable.getText(0, i));
		}
	}

}
