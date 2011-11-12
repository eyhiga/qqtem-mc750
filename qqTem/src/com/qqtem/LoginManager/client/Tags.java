package com.qqtem.LoginManager.client;

import com.google.gwt.user.client.Window;
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

public class Tags extends Composite {

	FlexTable flexTable;
	FlexTable topCommands;
	FlexTable dataTable;

	ListBox comboTipo;

	ListBox comboTipoPopup;

	TextBox txtbxTxtnome;

	DialogBox dialog;

	TextBox txtEnderecoPopup;
	TextBox txtNomePopup;
	ListBox listTipoPopup;

	int contRows;

	public Tags() {

		contRows = 0;

		flexTable = new FlexTable();
		initWidget(flexTable);

		SimplePanel simplePanel = new SimplePanel();
		flexTable.setWidget(0, 0, simplePanel);

		topCommands = new FlexTable();
		simplePanel.setWidget(topCommands);
		//topCommands.setSize("100%", "100%");

		comboTipo = new ListBox();
		comboTipo.addItem("Todos");
		comboTipo.addItem("Visível");
		comboTipo.addItem("Não visível");
		topCommands.setWidget(0, 0, comboTipo);
		topCommands.getCellFormatter().addStyleName(0, 0, "topCommandsTipo");
		
		txtbxTxtnome = new TextBox();
		txtbxTxtnome.setWidth(new String("300px"));
		topCommands.setWidget(0, 1, txtbxTxtnome);
		topCommands.getCellFormatter().addStyleName(0, 1, "topCommandsNome");
		txtbxTxtnome.setWidth("300");

		Button btnPesquisar = criarBotaoPesquisar();
		topCommands.setWidget(0, 2, btnPesquisar);
		topCommands.getCellFormatter().addStyleName(0, 2, "topCommandsBotoes");

		topCommands.getCellFormatter().addStyleName(0, 3, "topCommandsBotoes");
		topCommands.getCellFormatter().addStyleName(0, 4, "topCommandsBotoes");
		topCommands.getCellFormatter().addStyleName(0, 5, "topCommandsBotoes");
		
		Button btnAdicionar = criarBotaoAdicionar();
		topCommands.setWidget(0, 6, btnAdicionar);
		topCommands.getCellFormatter().addStyleName(0, 6, "topCommandsAdicionar");

		Button btnRemover = criarBotaoRemover();
		topCommands.setWidget(0, 7, btnRemover);
		topCommands.getCellFormatter().addStyleName(0, 7, "topCommandsRemover");

		SimplePanel bottonPanel = new SimplePanel();
		flexTable.setWidget(1, 0, bottonPanel);

		dataTable = new FlexTable();
		bottonPanel.setWidget(dataTable);
		dataTable.setSize("100%", "100%");

		dataTable.setText(0, 0, "Selecionar");
		dataTable.setText(0, 1, "Nome");
		dataTable.setText(0, 2, "Visível");

		dataTable.setCellPadding(6);
		dataTable.getRowFormatter().addStyleName(0, "tableListHeader");
		dataTable.addStyleName("tableList");
		dataTable.getCellFormatter().addStyleName(0, 0, "tableListSelecionar");
		dataTable.getCellFormatter().addStyleName(0, 1, "tableListNome");
		dataTable.getCellFormatter().addStyleName(0, 2, "tableListSelecionar");


	}

	private Button criarBotaoPesquisar()
	{
		Button btnPesquisar = new Button("Pesquisar");
		
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
					CheckBox chk = (CheckBox) dataTable.getWidget(i, 2);
					boolean cond = false;

					if(!tipo.equalsIgnoreCase("Todos"))
					{	
						if(chk.getValue() && tipo.equalsIgnoreCase("Visível"))
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
						else
						{
							if(!chk.getValue() && tipo.equalsIgnoreCase("Não visível"))
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

		return btnPesquisar;
		
	}

	private Button criarBotaoAdicionar()
	{
		Button btnAdicionar = new Button("Adicionar");
		
		btnAdicionar.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event) {

				dialog = criarDialogAdicionar();
				
				dialog.center();
				dialog.show();
			}
		});
		
		return btnAdicionar;
	}
	
	private Button criarBotaoRemover()
	{
		Button btnRemover = new Button("Remover");
		
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
		
		return btnRemover;
		
	}

	private DialogBox criarDialogAdicionar()
	{
		DialogBox diag = new DialogBox();
		
		diag.setTitle("Adicionar tag");
		FlexTable dialogContent = new FlexTable();

		VerticalPanel vertNome = new VerticalPanel();
		dialogContent.setWidget(0, 0, vertNome);

		FlexTable flexNome = new FlexTable();
		vertNome.add(flexNome);

		Label lblNome = new Label("Nome: ");
		lblNome.setWidth(new String("70px"));
		lblNome.setHorizontalAlignment(Label.ALIGN_RIGHT);
		flexNome.setWidget(0, 1, lblNome);
		txtNomePopup = new TextBox();
		txtNomePopup.setName("txtNome");
		txtNomePopup.setWidth(new String("200px"));
		flexNome.setWidget(0, 2, txtNomePopup);

		VerticalPanel vertVisivel = new VerticalPanel();
		//dialogContent.setWidget(3, 0, vertVisivel);

		FlexTable flexDesc = new FlexTable();
		vertVisivel.add(flexDesc);
		Label lblDesc = new Label("Visível: ");
		lblDesc.setWidth(new String("70px"));
		lblDesc.setHorizontalAlignment(Label.ALIGN_RIGHT);
		flexDesc.setWidget(0, 0, lblDesc);
		CheckBox chkVisivel = new CheckBox();
		flexDesc.setWidget(0, 1, chkVisivel);

		VerticalPanel vertBotoes = new VerticalPanel();
		dialogContent.setWidget(4, 0, vertBotoes);

		FlexTable flexBotoes = new FlexTable();
		vertBotoes.add(flexBotoes);
		Button btnSalvar = new Button("Salvar");

		btnSalvar.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				int row = dataTable.getRowCount();

				contRows++;

				String nome = txtNomePopup.getText();

				CheckBox chk = new CheckBox();

				dataTable.getCellFormatter().addStyleName(row, 0, "tableListSelecionar");
				dataTable.setWidget(row, 0, chk);

				Label n = new Label(nome);
				CheckBox c = new CheckBox();
				c.setValue(true);

				dataTable.setWidget(row, 1, n);
				dataTable.setWidget(row, 2, c);
				
				dataTable.getCellFormatter().addStyleName(row, 2, "tableListSelecionar");
				
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

		flexBotoes.setWidget(0, 5, btnSalvar);
		flexBotoes.setWidget(0, 6, btnCancelar);

		diag.setWidget(dialogContent);

		return diag;
		
	}
	
}

