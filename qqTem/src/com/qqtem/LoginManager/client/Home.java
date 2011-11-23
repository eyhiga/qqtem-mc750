package com.qqtem.LoginManager.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;

public class Home extends Composite {
	private static FlexTable tableDenuncias;
	private static DialogBox dialog;
	private ArrayList<Integer> idLinha; // idLinha[linha] retorna o id da denuncia presente na linha
	private static ArrayList<Integer> linhaId; // linhaId[id] retorna a linha que a denuncia de id 'id' está presente
	private static ListaDenuncias lista;

	public Home() {
		lista = new ListaDenuncias();
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setWidth("100%");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setWidth("100%");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel);
		horizontalPanel.setWidth("100%");
		
		CaptionPanel cptnpnlNewPanel = new CaptionPanel("Últimas denúncias");
		horizontalPanel.add(cptnpnlNewPanel);
		
		tableDenuncias = new FlexTable();
		tableDenuncias.setText(0, 0, "Descrição");
		tableDenuncias.setText(0, 1, "Data");
		tableDenuncias.setText(0, 2, "Usuário");
		tableDenuncias.setText(0, 3, "Estado");
		
		tableDenuncias.setCellPadding(6);
		tableDenuncias.getRowFormatter().addStyleName(0, "tableListHeader");
		tableDenuncias.getCellFormatter().setStyleName(0, 1, "tableListUsuario");
		tableDenuncias.addStyleName("tableList");
		
		preencheTabela();
		
		cptnpnlNewPanel.setContentWidget(tableDenuncias);
		tableDenuncias.setSize("100%", "");
		
		CaptionPanel cptnpnlNewPanel_1 = new CaptionPanel("Locais adicionados recentemente");
		cptnpnlNewPanel_1.setCaptionHTML("Locais adicionados recentemente");
		horizontalPanel.add(cptnpnlNewPanel_1);
		
		FlexTable tableLocais = new FlexTable();
		tableLocais.setText(0, 0, "Nome");
		tableLocais.setText(0, 1, "Tipo");
		
		tableLocais.setCellPadding(6);
		tableLocais.getRowFormatter().addStyleName(0, "tableListHeader");
		tableLocais.addStyleName("tableList");
		
		tableLocais.setWidget(1, 0, new Label("Danceteria Rala Coxa"));
		tableLocais.setWidget(1, 1, new Label("Entretenimento"));
		
		tableLocais.setWidget(2, 0, new Label("Coisa Boa da Vovó"));
		tableLocais.setWidget(2, 1, new Label("Restaurante"));
		
		tableLocais.setWidget(3, 0, new Label("Inn"));
		tableLocais.setWidget(3, 1, new Label("Hotel"));
		
		tableLocais.getRowFormatter().addStyleName(1, "tableList-odd");
		tableLocais.getRowFormatter().addStyleName(2, "tableList-even");
		tableLocais.getRowFormatter().addStyleName(3, "tableList-odd");
		
		cptnpnlNewPanel_1.setContentWidget(tableLocais);
		tableLocais.setSize("100%", "");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel.add(verticalPanel_2);
		verticalPanel_2.setWidth("100%");
		
		CaptionPanel cptnpnlNewPanel_2 = new CaptionPanel("Comentários com menor avaliação");
		verticalPanel_2.add(cptnpnlNewPanel_2);
		
		FlexTable tableComentarios = new FlexTable();
		tableComentarios.setText(0, 0, "Classificação");
		tableComentarios.setText(0, 1, "Usuário");
		tableComentarios.setText(0, 2, "Local");
		tableComentarios.setText(0, 3, "Conteúdo");
		
		tableComentarios.setCellPadding(6);
		tableComentarios.getRowFormatter().addStyleName(0, "tableListHeader");
		tableComentarios.getCellFormatter().setStyleName(0, 0, "tableListClassificacao");
		tableComentarios.getCellFormatter().setStyleName(0, 1, "tableListUsuario");
		tableComentarios.getCellFormatter().setStyleName(0, 2, "tableListConteudo");
		tableComentarios.getCellFormatter().setStyleName(0, 3, "tableListConteudo");
		tableComentarios.addStyleName("tableList");
		
		tableComentarios.setWidget(1, 0, new Label("-50"));
		tableComentarios.setWidget(1, 1, new Label("João"));
		tableComentarios.setWidget(1, 2, new Label("Bar do Zé"));
		tableComentarios.setWidget(1, 3, new Label("Cerveja ruim!"));
		
		tableComentarios.setWidget(2, 0, new Label("-44"));
		tableComentarios.setWidget(2, 1, new Label("Maria"));
		tableComentarios.setWidget(2, 2, new Label("Churrascaria Maravilha"));
		tableComentarios.setWidget(2, 3, new Label("Atendentes muito simpaticos."));
		
		tableComentarios.setWidget(3, 0, new Label("-31"));
		tableComentarios.setWidget(3, 1, new Label("Josué"));
		tableComentarios.setWidget(3, 2, new Label("Casa Noturna X"));
		tableComentarios.setWidget(3, 3, new Label("Ótimo acesso e ambiente agradável."));
		
		tableComentarios.setWidget(4, 0, new Label("-23"));
		tableComentarios.setWidget(4, 1, new Label("Carlota"));
		tableComentarios.setWidget(4, 2, new Label("Shopping Center Sul"));
		tableComentarios.setWidget(4, 3, new Label("Só tem vagabundo aqui!"));
		
		tableComentarios.setWidget(5, 0, new Label("-22"));
		tableComentarios.setWidget(5, 1, new Label("Pedro"));
		tableComentarios.setWidget(5, 2, new Label("Loja da Esquina"));
		tableComentarios.setWidget(5, 3, new Label("Todos os produtos são originais."));
		
		tableComentarios.setWidget(6, 0, new Label("-19"));
		tableComentarios.setWidget(6, 1, new Label("Manuel"));
		tableComentarios.setWidget(6, 2, new Label("Restaurante Meia-Boca"));
		tableComentarios.setWidget(6, 3, new Label("Meia-boca mesmo."));
		
		tableComentarios.getRowFormatter().addStyleName(1, "tableList-odd");
		tableComentarios.getRowFormatter().addStyleName(2, "tableList-even");
		tableComentarios.getRowFormatter().addStyleName(3, "tableList-odd");
		tableComentarios.getRowFormatter().addStyleName(4, "tableList-even");
		tableComentarios.getRowFormatter().addStyleName(5, "tableList-odd");
		tableComentarios.getRowFormatter().addStyleName(6, "tableList-even");

		
		cptnpnlNewPanel_2.setContentWidget(tableComentarios);
		tableComentarios.setSize("100%", "");
	

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
			
			for (j = 0; j < 4; j++) {
				tableDenuncias.setText(i+1, j, lista.getColunaTabela(i, j));
			}			
			
			if ((i+1) % 2 != 0) estilo = "tableList-odd";
			else estilo = "tableList-even";
			
			tableDenuncias.getRowFormatter().addStyleName(i+1, estilo);
		}
		
		tableDenuncias.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int linha = tableDenuncias.getCellForEvent(event).getRowIndex();
				if (linha <= 0) return;
				
				int idDenuncia = idLinha.get(linha-1);
				
				dialog = Denuncias.criarDialog(idDenuncia);
				
				dialog.center();
				dialog.show();
				
				Denuncias.setDialog(dialog);
				
			}
		});
	}
	
	public static void alteraLinha(int linha, int coluna, String texto) {
		tableDenuncias.setText(linha, coluna, texto);
	}
	
}
