package com.qqtem.LoginManager.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.DecoratedTabPanel;

public class Abas extends Composite {

	public Abas() {
		
		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		initWidget(decoratedTabPanel);
		decoratedTabPanel.setSize("100%", "100%");
		
	    // estas variáveis são os conteúdos de cada aba. (não o texto do nome delas...)
	    Label denunciasText = new Label("Denúncias");
	    
	    Locais locais = new Locais();
	    Tags tags = new Tags();
	    Usuarios usuarios = new Usuarios();
	    Home home = new Home();
	    
	    decoratedTabPanel.add(home, "Home");
	    decoratedTabPanel.add(tags, "Tags");
	    decoratedTabPanel.add(locais, "Locais");
	    decoratedTabPanel.add(usuarios, "Usuários");
	    decoratedTabPanel.add(denunciasText, "Denúncias");
	    
	    decoratedTabPanel.selectTab(0);
	}


}
