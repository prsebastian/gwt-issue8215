/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.sample.hello.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.ResetEvent;
import com.google.gwt.user.client.ui.FormPanel.ResetHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SubmitButton;

/**
 * HelloWorld application.
 */
public class Hello implements EntryPoint {

  public void onModuleLoad() {

    HTMLPanel htmlPanel = new HTMLPanel("check me:");

    htmlPanel.add(new CheckBox());
    htmlPanel.add(new InlineHTML("<br /><br />"));

    final FormPanel formPanel = new FormPanel();
    formPanel.getElement().setId("form");

    formPanel.add(htmlPanel);

    // here is the new feature
    formPanel.addResetHandler(new ResetHandler() {

      @Override
      public void onReset(ResetEvent event) {

        Window.alert("ResetHandler called");

      }
    });

    formPanel.addSubmitHandler(new SubmitHandler() {

      @Override
      public void onSubmit(SubmitEvent event) {

        Window.alert("SubmitHandler called");

      }
    });

    ResetButton resetButton = new ResetButton("ResetButton");
    SubmitButton submitButton = new SubmitButton("SubmitButton");

    Button buttonWithReset = new Button("formPanel.reset()", new ClickHandler() {
      public void onClick(ClickEvent event) {
        formPanel.reset();
      }
    });

    Button buttonWithSubmit = new Button("formPanel.submit()", new ClickHandler() {
      public void onClick(ClickEvent event) {
        formPanel.submit();
      }
    });


    htmlPanel.add(resetButton);
    htmlPanel.add(submitButton);

    htmlPanel.add(new InlineHTML("<br />"));

    htmlPanel.add(buttonWithReset);
    htmlPanel.add(buttonWithSubmit);

    SafeHtmlBuilder shb = new SafeHtmlBuilder();
    shb.appendHtmlConstant("<input type=\"reset\" value=\"native reset\">");
    shb.appendHtmlConstant("<input type=\"submit\" value=\"native submit\">");
    HTML html = new HTML();
    html.setHTML(shb.toSafeHtml());
    htmlPanel.add(html);

    RootPanel.get().add(formPanel);
  }
}
