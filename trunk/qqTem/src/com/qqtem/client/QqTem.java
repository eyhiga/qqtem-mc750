package com.qqtem.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class QqTem implements EntryPoint {


	//private final DockLayoutPanel page = new DockLayoutPanel(Style.Unit.PX);
	private final VerticalPanel page = new VerticalPanel();
	
	//private final VerticalPanel login = new VerticalPanel();
	private final HorizontalPanel usr = new HorizontalPanel();
	private final HorizontalPanel pwd = new HorizontalPanel();
	private final Label usrLbl = new Label("Usuário: ");
	private final TextBox usrTxt = new TextBox();
	private final Label pwdLbl = new Label("Senha: ");
	private final PasswordTextBox pwdTxt = new PasswordTextBox();
	
	public static Login login = new Login();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {		
		
		RootPanel.get("page").add(page);
		
		//Image banner = new Image("images/banner.png");
		//page.add(banner);
		
		createLoginPage();
		
	}
	
	private void createLoginPage()
	{
		
		//Login login = new Login();
		RootPanel.get("page").add(login);
		
		/*
		login.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		login.setSize(new String("100%"), new String("100%"));
		
		page.add(login);
		
		Label title = new Label("Login");
		title.setPixelSize(50, 30);
		title.setStyleName("loginTitle");
		login.add(title);
		
		
		usr.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		usr.setWidth(new String("300"));

		usrLbl.setAutoHorizontalAlignment(Label.ALIGN_RIGHT);
		
		usr.add(usrLbl);
		usr.add(usrTxt);
		usr.setSize(new String("100%"), new String("100%"));
		login.add(usr);
		
		
		pwd.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		pwd.setWidth(new String("300"));
		
		pwdLbl.setAutoHorizontalAlignment(Label.ALIGN_RIGHT);

		pwd.add(pwdLbl);
		pwd.add(pwdTxt);
		pwd.setSize(new String("100%"), new String("100%"));
		login.add(pwd);
		
		Button loginBtn = new Button("Entrar");
		login.add(loginBtn);
		

		class LoginHandler implements ClickHandler
		{
			@Override
			public void onClick(ClickEvent event) 
			{
				authenticateUser();
			}
			
			private void authenticateUser()
			{	
				String login = usrTxt.getText();
				String password = usrTxt.getText();
				
				createMainPage();
				
			}	
		}
		
		loginBtn.addClickHandler(new LoginHandler());*/
		
	}
	
	private void createMainPage()
	{
		Window.alert("Autenticado");
	}
	
}
