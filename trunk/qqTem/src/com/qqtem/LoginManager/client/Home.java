package com.qqtem.LoginManager.client;

import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;

public class Home extends Composite {

	public Home() {
		
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
		
		FlexTable tableDenuncias = new FlexTable();
		tableDenuncias.setText(0, 0, "Descrição");
		tableDenuncias.setText(0, 1, "Data");
		tableDenuncias.setText(0, 2, "Usuário");
		tableDenuncias.setText(0, 3, "Estado");
		
		tableDenuncias.setCellPadding(6);
		tableDenuncias.getRowFormatter().addStyleName(0, "tableListHeader");
		tableDenuncias.getCellFormatter().setStyleName(0, 1, "tableListUsuario");
		tableDenuncias.addStyleName("tableList");
		
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
		
		cptnpnlNewPanel_2.setContentWidget(tableComentarios);
		tableComentarios.setSize("100%", "");
	

	}
	
}

