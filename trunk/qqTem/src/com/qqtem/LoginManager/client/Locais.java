package com.qqtem.LoginManager.client;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class Locais extends Composite {

	FlexTable flexTable;
	FlexTable flexTable_1;
	FlexTable dataTable;

	ListBox comboTipo;

	ListBox comboTipoPopup;

	TextBox txtbxTxtnome;

	DialogBox dialog;

	TextBox txtEnderecoPopup;
	TextBox txtNomePopup;
	ListBox listTipoPopup;

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

				dialog = new DialogBox();
				FlexTable dialogContent = new FlexTable();

				VerticalPanel vertNome = new VerticalPanel();
				dialogContent.setWidget(0, 0, vertNome);

				FlexTable flexNome = new FlexTable();
				vertNome.add(flexNome);

				Label lblNome = new Label("Nome: ");
				lblNome.setWidth(new String("100px"));
				lblNome.setHorizontalAlignment(Label.ALIGN_RIGHT);
				flexNome.setWidget(0, 1, lblNome);
				txtNomePopup = new TextBox();
				txtNomePopup.setName("txtNome");
				txtNomePopup.setWidth(new String("200px"));
				flexNome.setWidget(0, 2, txtNomePopup);

				VerticalPanel vertEndereco = new VerticalPanel();
				dialogContent.setWidget(1, 0, vertEndereco);

				FlexTable flexEndereco = new FlexTable();
				vertNome.add(flexEndereco);

				Label lblEndereco = new Label("Endereço: ");
				lblEndereco.setWidth(new String("100px"));
				lblEndereco.setHorizontalAlignment(Label.ALIGN_RIGHT);
				flexEndereco.setWidget(0, 1, lblEndereco);
				txtEnderecoPopup = new TextBox();
				txtEnderecoPopup.setName("txtNome");
				txtEnderecoPopup.setWidth(new String("200px"));
				flexEndereco.setWidget(0, 2, txtEnderecoPopup);

				VerticalPanel vertTipo = new VerticalPanel();
				dialogContent.setWidget(2, 0, vertTipo);

				FlexTable flexTipo = new FlexTable();
				vertTipo.add(flexTipo);

				Label lblTipo = new Label("Tipo: ");
				lblTipo.setWidth(new String("100px"));
				lblTipo.setHorizontalAlignment(Label.ALIGN_RIGHT);
				flexTipo.setWidget(0, 1, lblTipo);
				listTipoPopup = new ListBox();
				listTipoPopup.setWidth(new String("200px"));
				listTipoPopup.setName("listTipoPopup");
				listTipoPopup.addItem("Restaurante");
				listTipoPopup.addItem("Hotel");
				listTipoPopup.addItem("Bar");
				listTipoPopup.addItem("Parque");
				flexTipo.setWidget(0, 2, listTipoPopup);

				VerticalPanel vertDesc = new VerticalPanel();
				dialogContent.setWidget(3, 0, vertDesc);

				FlexTable flexDesc = new FlexTable();
				flexDesc.setWidget(0, 0, new Label("Descrição: "));
				flexDesc.setWidget(0, 1, new TextArea());

				VerticalPanel vertBotoes = new VerticalPanel();
				dialogContent.setWidget(4, 0, vertBotoes);

				FlexTable flexBotoes = new FlexTable();
				vertBotoes.add(flexBotoes);
				Button btnAddFotos = new Button("Adicionar fotos");
				Button btnSalvar = new Button("Salvar");


				btnSalvar.addClickHandler(new ClickHandler()
				{
					@Override
					public void onClick(ClickEvent event)
					{
						int row = dataTable.getRowCount();

						String nome = txtNomePopup.getText();
						String end = txtEnderecoPopup.getText();
						String tipo = listTipoPopup.getItemText(listTipoPopup.getSelectedIndex());

						CheckBox chk = new CheckBox();
						dataTable.setWidget(row, 0, chk);
						dataTable.setWidget(row, 1, new Label(nome));
						dataTable.setWidget(row, 2, new Label(end));
						dataTable.setWidget(row, 3, new Label(tipo));
						dialog.hide();
					}
				});

				Button btnCancelar = new Button("Cancelar");

				btnCancelar.addClickHandler(new ClickHandler()
				{
					@Override
					public void onClick(ClickEvent event)
					{
						dialog.hide();
					}
				});

				flexBotoes.setWidget(0, 0, btnAddFotos);
				flexBotoes.setWidget(0, 5, btnSalvar);
				flexBotoes.setWidget(0, 6, btnCancelar);

				dialog.setWidget(dialogContent);

				dialog.center();
				dialog.show();
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

