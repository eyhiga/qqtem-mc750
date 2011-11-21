/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qqtem.LoginManager.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class QqTem implements EntryPoint {
	private static VerticalPanel verticalPanel;
	private static HorizontalPanel horizontalPanel;
	private static Hyperlink logout;
		
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("100%", "100%");
		
		Window.setTitle("qqTem - Login");
		
		FlexTable flexTable = new FlexTable();
		rootPanel.add(flexTable, 0, 0);
		flexTable.setWidth("100%");
		
		Image logo = new Image("logo.png");
		flexTable.setWidget(0, 0, logo);
		
		logout = new Hyperlink("Logout", false, "newHistoryToken");
		logout.setVisible(false);
		
		logout.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				QqTem.realizaLogout();
			}
		});
		flexTable.setWidget(1, 0, logout);
		
		verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("gwt-VerticalPanel");
		verticalPanel.setBorderWidth(1);
		flexTable.setWidget(2, 0, verticalPanel);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
		verticalPanel.setSize("100px", "100px");
		
		horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);		
		
		Login login = new Login();
		horizontalPanel.add(login);
		
		flexTable.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getRowFormatter().setVerticalAlign(0, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_TOP);
	}
	
	public static void realizaLogin() {
		verticalPanel.remove(horizontalPanel);
		
		Abas homeAbas = new Abas();
		
		verticalPanel.setSize("100%", "100%");
		verticalPanel.add(homeAbas);
		verticalPanel.setBorderWidth(1);
		
		logout.setVisible(true);
		
		Window.setTitle("qqTem - Home");
		return;
	}
	
	public static void realizaLogout() {
		logout.setVisible(false);
		
		verticalPanel.remove(0);
		horizontalPanel.remove(0);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setSize("100px", "100px");
		
		Login login = new Login();
		horizontalPanel.add(login);
		
		Window.setTitle("qqTem - Login");
		
	}
}
