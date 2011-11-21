package com.qqtem.LoginManager.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class Denuncias extends Composite {
	private static FlexTable tabela;
	private static ListaDenuncias lista;
	private static DialogBox dialog;
	private ArrayList<Integer> idLinha; // idLinha[linha] retorna o id da denuncia presente na linha
	private static ArrayList<Integer> linhaId; // linhaId[id] retorna a linha que a denuncia de id 'id' está presente

	public Denuncias() {
		lista = new ListaDenuncias();
		
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
		
		tabela = new FlexTable();
		tabela.setStyleName("tableList");
		tabela.getRowFormatter().addStyleName(0, "tableListHeader");
		verticalPanel.add(tabela);
		tabela.setSize("100%", "");
		
		tabela.setText(0, 0, "Denúncia");
		tabela.setText(0, 1, "Data");
		tabela.setText(0, 2, "Usuário");
		tabela.setText(0, 3, "Estado");
		
		tabela.getCellFormatter().setStyleName(0, 1, "tableListUsuario");
		tabela.addStyleName("tableList");

		tabela.getCellFormatter().setWidth(0, 0, "150");
		tabela.getCellFormatter().setWidth(0, 1, "50");
		tabela.getCellFormatter().setWidth(0, 2, "50");
		tabela.getCellFormatter().setWidth(0, 3, "100");
		
		this.preencheTabela();
	}

	public void preencheTabela() {
		idLinha = new ArrayList<Integer>();
		linhaId = new ArrayList<Integer>();
		int i, j;
		
		String estilo;
		
		for (i = 0; i < lista.getNumDenuncias(); i++) {
			j = 0;
			
			idLinha.add(i);
			linhaId.add(i+1);
			//tabela.setText(i+1, 0, "" + i);
			for (j = 0; j < 4; j++) {
				tabela.setText(i+1, j, lista.getColunaTabela(i, j));
			}			
			
			if ((i+1) % 2 != 0) estilo = "tableList-odd";
			else estilo = "tableList-even";
			
			tabela.getRowFormatter().addStyleName(i+1, estilo);
		}
		
		tabela.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int linha = tabela.getCellForEvent(event).getRowIndex();
				if (linha <= 0) return;
				
				int idDenuncia = idLinha.get(linha-1);
				
				dialog = Denuncias.criarDialog(idDenuncia);
				//dialog.setTitle("" + linha);
				
				dialog.center();
				dialog.show();
				
			}
		});
	}
	
	public static void alteraLinha(int linha, int coluna, String texto) {
		tabela.setText(linha, coluna, texto);
	}
	
	static DialogBox criarDialog(final int idDenuncia) {
		final DialogBox cxDialogo = new DialogBox();
		cxDialogo.setTitle("Denúncia");
		cxDialogo.setGlassEnabled(true);
		
		cxDialogo.setWidth("400px");
		cxDialogo.setHeight("300 px");
		
		FlexTable conteudo = new FlexTable();
		cxDialogo.setWidget(conteudo);
		conteudo.setWidth("100%");
		conteudo.setHeight("100%");
		
		Label denun = new Label("Denúncia");
		conteudo.setWidget(0, 0, denun);
		denun.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Label descr = new Label(lista.getDescricao(idDenuncia));
		conteudo.setWidget(1, 0, descr);
		descr.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Label data = new Label("Data: " + lista.getData(idDenuncia) + " - " + "Pelo usuário: " + lista.getUsuario(idDenuncia));
		data.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		conteudo.setWidget(2, 0, data);
		
		Hyperlink visualizar = new Hyperlink("Visualizar Informações", false, "newHistoryToken");
		conteudo.setWidget(3, 0, visualizar);
		conteudo.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		final ListBox comboBox = new ListBox();

		comboBox.addItem(lista.getEstado(idDenuncia));
		if (lista.getEstado(idDenuncia) == "Não Tratado") {
			comboBox.addItem("Tratado");
		}
		else {
			comboBox.addItem("Não Tratado");
		}
		
		conteudo.setWidget(4, 0, comboBox);
		conteudo.getCellFormatter().setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		Button ok = new Button("Ok");
		ok.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!comboBox.getValue(comboBox.getSelectedIndex()).equals(lista.getEstado(idDenuncia))) {
					lista.mudaEstado(idDenuncia);
					Denuncias.alteraLinha(linhaId.get(idDenuncia), 3, lista.getEstado(idDenuncia));
					Home.alteraLinha(linhaId.get(idDenuncia), 3, lista.getEstado(idDenuncia));
				}
				
				cxDialogo.hide();
				cxDialogo.clear();
			}
		});
		
		Button cancelar = new Button("Cancelar");
		cancelar.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				cxDialogo.hide();
			}
		});
		
		FlexTable botoes = new FlexTable();
		botoes.setWidget(0, 0, ok);
		botoes.setWidget(0, 1, cancelar);
		
		conteudo.setWidget(5, 0, botoes);
		conteudo.getCellFormatter().setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		return cxDialogo;
	}
	
}
