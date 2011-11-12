package com.qqtem.LoginManager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.TextColumn;

public class Locais extends Composite {
	
	FlexTable flexTable;
	FlexTable flexTable_1;
	FlexTable dataTable;
	
	ListBox comboTipo;
	
	TextBox txtbxTxtnome;
	
	public Locais() {
		
		flexTable = new FlexTable();
		initWidget(flexTable);
		
		SimplePanel simplePanel = new SimplePanel();
		flexTable.setWidget(0, 0, simplePanel);
		
		flexTable_1 = new FlexTable();
		simplePanel.setWidget(flexTable_1);
		flexTable_1.setSize("100%", "100%");
		
		comboTipo = new ListBox();
		comboTipo.addItem("Todos");
		comboTipo.addItem("Restaurante");
		comboTipo.addItem("Hotel");
		comboTipo.addItem("Bar");
		comboTipo.addItem("Parque");
		comboTipo.addItem("Tipo 1");
		comboTipo.addItem("Tipo 2");
		comboTipo.addItem("Tipo 3");
		comboTipo.addItem("Tipo 4");
		comboTipo.addItem("Tipo 5");
		flexTable_1.setWidget(0, 0, comboTipo);
		
		txtbxTxtnome = new TextBox();
		flexTable_1.setWidget(0, 1, txtbxTxtnome);
		txtbxTxtnome.setWidth("300");
		
		Button btnPesquisar = new Button("Pesquisar");
		flexTable_1.setWidget(0, 2, btnPesquisar);
		
		btnPesquisar.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				String tipo = comboTipo.getItemText(comboTipo.getSelectedIndex());
				String pesquisa = txtbxTxtnome.getText();
				
				for(int i=1; i < dataTable.getRowCount(); i ++)
				{
					Label nome = (Label) dataTable.getWidget(i, 1);
					Label labelTipo = (Label) dataTable.getWidget(i, 3);
					boolean cond = true;
					
					if(!tipo.equalsIgnoreCase("Todos"))
					{
						if(!labelTipo.getText().equalsIgnoreCase(tipo))
						{
							cond = false;
						}
						else
						{
							if(pesquisa.equalsIgnoreCase(""))
							{
								cond = true;
							}
							else
							{
								if(pesquisa.equalsIgnoreCase(nome.getText()))
								{
									cond = true;
								}
								else
								{
									cond = false;
								}
							}
						}
					}
					else
					{
						if(pesquisa.equalsIgnoreCase(""))
						{
							cond = true;
						}
						else
						{
							if(pesquisa.equalsIgnoreCase(nome.getText()))
							{
								cond = true;
							}
							else
							{
								cond = false;
							}
						}
					}
					
					
					if(cond == true)
					{
						dataTable.getRowFormatter().setVisible(i, true);
					}
					else
					{
						dataTable.getRowFormatter().setVisible(i, false);
					}	
				}
			}
		});
		
		Button btnAdicionar = new Button("Adicionar");
		flexTable_1.setWidget(0, 3, btnAdicionar);
		
		btnAdicionar.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event) {
				
				int row = dataTable.getRowCount();
				
				CheckBox chk = new CheckBox();
				chk.setName(String.valueOf(row));
				dataTable.setWidget(row, 0, chk);
				dataTable.setWidget(row, 1, new Label("Nome " + row));
				dataTable.setWidget(row, 2, new Label("Endereço " + row));
				dataTable.setWidget(row, 3, new Label("Tipo " + row));
				
				dataTable.getCellFormatter().addStyleName(row, 0, "watchListNumericColumn");
				dataTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
				dataTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
				dataTable.getCellFormatter().addStyleName(row, 3, "watchListNumericColumn");
				
			}
		});
		
		Button btnRemover = new Button("Remover selecionados");
		flexTable_1.setWidget(0, 4, btnRemover);
		
		btnRemover.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event) {
				
				int i=1;
				CheckBox chk;
				
				while((chk = (CheckBox) dataTable.getWidget(i, 0)) != null)
				{
					
					if(chk.getValue())
					{
						dataTable.removeRow(i);
					}
					else
					{
						i++;
					}
				}
				
			}
		});
		
		SimplePanel simplePanel_1 = new SimplePanel();
		flexTable.setWidget(1, 0, simplePanel_1);
		
		dataTable = new FlexTable();
		dataTable.setStyleName((String) null);
		simplePanel_1.setWidget(dataTable);
		dataTable.setSize("100%", "100%");
		
		dataTable.setText(0, 0, "Selecionar");
		dataTable.setText(0, 1, "Nome");
		dataTable.setText(0, 2, "Endereço");
		dataTable.setText(0, 3, "Tipo");
		
		dataTable.setCellPadding(6);
		dataTable.getRowFormatter().addStyleName(0, "tableListHeader");
		dataTable.addStyleName("watchList");
		dataTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
		dataTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
		dataTable.getCellFormatter().addStyleName(0, 3, "watchListNumericColumn");
		
	}

	
}

