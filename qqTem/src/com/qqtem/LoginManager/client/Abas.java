package com.qqtem.LoginManager.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;

public class Abas extends Composite {

	public Abas() {
		
		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		initWidget(decoratedTabPanel);
		decoratedTabPanel.setSize("100%", "100%");
		
	    // estas variáveis são os conteúdos de cada aba. (não o texto do nome delas...)
		Label homeText = new Label("Home!");
	    Label tagText = new Label("Tags!");
	    Label locaisText = new Label("Locais!");
	    Label usuariosText = new Label("Usuários");
	    Label denunciasText = new Label("Denúncias");
	    
	    decoratedTabPanel.add(homeText, "Home");
	    decoratedTabPanel.add(tagText, "Tags");
	    decoratedTabPanel.add(locaisText, "Locais");
	    decoratedTabPanel.add(usuariosText, "Usuários");
	    decoratedTabPanel.add(denunciasText, "Denúncias");
	    
	    decoratedTabPanel.selectTab(0);
	}


}
