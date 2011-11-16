package com.qqtem.LoginManager.client;

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
		
		DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
		horizontalPanel.add(decoratorPanel_1);
		decoratorPanel_1.setWidth("100%");
		
		FlexTable tableDenuncias = new FlexTable();
		decoratorPanel_1.setWidget(tableDenuncias);
		tableDenuncias.setWidth("100%");
		tableDenuncias.setText(0, 0, "Descrição");
		tableDenuncias.setText(0, 1, "Data");
		tableDenuncias.setText(0, 2, "Usuário");
		tableDenuncias.setText(0, 3, "Estado");
		tableDenuncias.getRowFormatter().addStyleName(0, "tableListHeader");
		tableDenuncias.addStyleName("tableList");
		
		DecoratorPanel decoratorPanel_2 = new DecoratorPanel();
		horizontalPanel.add(decoratorPanel_2);
		decoratorPanel_2.setWidth("100%");
		
		FlexTable tableLocais = new FlexTable();
		decoratorPanel_2.setWidget(tableLocais);
		tableLocais.setWidth("100%");
		tableLocais.setText(0, 0, "Nome");
		tableLocais.setText(0, 1, "Tipo");
		tableLocais.getRowFormatter().addStyleName(0, "tableListHeader");
		tableLocais.addStyleName("tableList");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel.add(verticalPanel_2);
		verticalPanel_2.setWidth("100%");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		verticalPanel_2.add(decoratorPanel);
		decoratorPanel.setWidth("100%");
		
		FlexTable tableComentarios = new FlexTable();
		decoratorPanel.setWidget(tableComentarios);
		tableComentarios.setText(0, 0, "Classificação");
		tableComentarios.setText(0, 1, "Usuário");
		tableComentarios.setText(0, 2, "Local");
		tableComentarios.setText(0, 3, "Conteúdo");
		tableComentarios.getRowFormatter().addStyleName(0, "tableListHeader");
		tableComentarios.addStyleName("tableList");
		tableComentarios.setWidth("100%");

	}
	
}

