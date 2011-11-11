package com.qqtem.LoginManager.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class Abas extends Composite {

	public Abas() {
		TabLayoutPanel panel = new TabLayoutPanel(2.5, Unit.EM);
		panel.setHeight("100%");
		panel.setWidth("100%");
		initWidget(panel);
		
		panel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);
		
	    // estas variáveis são os conteúdos de cada aba. (não o texto do nome delas...)
		Label homeText = new Label("Home!");
	    Label tagText = new Label("Tags!");
	    Label locaisText = new Label("Locais!");
	    Label usuariosText = new Label("Usuários");
	    Label denunciasText = new Label("Denúncias");
	    
	    panel.add(homeText, "Home");
	    panel.add(tagText, "Tags");
	    panel.add(locaisText, "Locais");
	    panel.add(usuariosText, "Usuários");
	    panel.add(denunciasText, "Denúncias");
	}


}
