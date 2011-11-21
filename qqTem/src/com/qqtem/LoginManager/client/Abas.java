package com.qqtem.LoginManager.client;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.DecoratedTabPanel;

public class Abas extends Composite {
	private static DecoratedTabPanel decoratedTabPanel;

	public Abas() {
		
		decoratedTabPanel = new DecoratedTabPanel();
		initWidget(decoratedTabPanel);
		decoratedTabPanel.setSize("100%", "100%");
		
	    // estas variáveis são os conteúdos de cada aba. (não o texto do nome delas...) 
	    Locais locais = new Locais();
	    Tags tags = new Tags();
	    Usuarios usuarios = new Usuarios();
	    Home home = new Home();
	    Denuncias denuncias = new Denuncias();
	    
	    decoratedTabPanel.add(home, "Home");
	    decoratedTabPanel.add(tags, "Tags");
	    decoratedTabPanel.add(locais, "Locais");
	    decoratedTabPanel.add(usuarios, "Usuários");
	    decoratedTabPanel.add(denuncias, "Denúncias");
	    
	    decoratedTabPanel.selectTab(0);
	    
	    decoratedTabPanel.addSelectionHandler(new SelectionHandler<Integer>() {

			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				if ((event.getSelectedItem() == 4) || (event.getSelectedItem() == 0)) {
					Denuncias.repopDialog();
				}
				
			}
	    	
	    });
	}
	
	public static void setSelected(int tab) {
		decoratedTabPanel.selectTab(tab);
	}


}
