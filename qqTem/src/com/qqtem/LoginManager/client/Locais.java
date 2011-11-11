package com.qqtem.LoginManager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.widget.client.TextButton;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.user.cellview.client.TextColumn;

public class Locais extends Composite {

	SimplePager pager;
	
	public Locais() {
		
		FlexTable flexTable = new FlexTable();
		initWidget(flexTable);
		
		SimplePanel simplePanel = new SimplePanel();
		flexTable.setWidget(0, 0, simplePanel);
		
		FlexTable flexTable_1 = new FlexTable();
		simplePanel.setWidget(flexTable_1);
		flexTable_1.setSize("100%", "100%");
		
		ListBox comboBox = new ListBox();
		comboBox.addItem("Todos");
		comboBox.addItem("Restaurante");
		comboBox.addItem("Hotel");
		comboBox.addItem("Bar");
		comboBox.addItem("Parque");
		flexTable_1.setWidget(0, 0, comboBox);
		
		TextBox textBox = new TextBox();
		flexTable_1.setWidget(0, 1, textBox);
		textBox.setWidth("300");
		
		Button btnNewButton = new Button("Pesquisar");
		flexTable_1.setWidget(0, 2, btnNewButton);
		
		Button btnNewButton_1 = new Button("Adicionar");
		flexTable_1.setWidget(0, 3, btnNewButton_1);
		
		Button btnNewButton_2 = new Button("Remover selecionados");
		flexTable_1.setWidget(0, 4, btnNewButton_2);
		
		SimplePanel simplePanel_1 = new SimplePanel();
		flexTable.setWidget(1, 0, simplePanel_1);
		
		CellTable<Object> cellTable = new CellTable<Object>();
		simplePanel_1.setWidget(cellTable);
		cellTable.setSize("100%", "100%");
		
		Column<Object, String> column = new Column<Object, String>(new EditTextCell()) {
			@Override
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(column, "Selecionar");
		
		Column<Object, String> column_1 = new Column<Object, String>(new EditTextCell()) {
			@Override
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(column_1, "Nome");
		
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		
	}

}
