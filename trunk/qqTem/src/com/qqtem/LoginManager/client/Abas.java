package com.qqtem.LoginManager.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class Abas extends TabLayoutPanel {

	public Abas() {
		super(2.5, Unit.EM);
		super.getElement().getStyle().setMarginBottom(10.0, Unit.PX);
		
	    // estas variáveis são os conteúdos de cada aba. Elas estão todas
		Label homeText = new Label("Home!");
	    Label tagText = new Label("Tags!");
	    Label locaisText = new Label("Locais!");
	    Label usuariosText = new Label("Usuários");
	    Label denunciasText = new Label("Denúncias");
	    
	    
	    super.add(homeText, "Home");
	    super.add(tagText, "Tags");
	    super.add(locaisText, "Locais");
	    super.add(usuariosText, "Usuários");
	    super.add(denunciasText, "Denúncias");
	}

}
