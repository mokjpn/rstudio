/*
 * PublishReportSourcePage.java
 *
 * Copyright (C) 2009-15 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.rsconnect.ui;

import java.util.ArrayList;

import org.rstudio.core.client.widget.WizardNavigationPage;
import org.rstudio.core.client.widget.WizardPage;
import org.rstudio.studio.client.rsconnect.model.RSConnectPublishInput;
import org.rstudio.studio.client.rsconnect.model.RSConnectPublishResult;

import com.google.gwt.resources.client.ImageResource;

public class PublishReportSourcePage 
   extends WizardNavigationPage<RSConnectPublishInput, RSConnectPublishResult>
{
   
   public PublishReportSourcePage(
         String title,
         String subTitle,
         ImageResource icon,
         RSConnectPublishInput input,
         boolean asMultiple)
   {
      super(title, subTitle, "Publish Source Code", icon, null, 
            createPages(input, asMultiple));
   }

   private static ArrayList<WizardPage<RSConnectPublishInput, 
                                       RSConnectPublishResult>> 
           createPages(RSConnectPublishInput input, boolean asMultiple)
   {
      ArrayList<WizardPage<RSConnectPublishInput, 
                           RSConnectPublishResult>> pages =
                           new ArrayList<WizardPage<RSConnectPublishInput, 
                                                    RSConnectPublishResult>>();
      
      pages.add(new PublishFilesPage("Publish " +
            (asMultiple? "documents" : "document") + " with source code",
            "Choose this option if you want to create " + 
            (asMultiple ? "scheduled reports" : "a scheduled report") + " or " +
            "execute your " + 
            (asMultiple ? "documents" : "document") + " on the server.", 
            RSConnectResources.INSTANCE.publishDocWithSource(), 
            input, asMultiple, false));
      String staticTitle = "Publish finished " + 
            (asMultiple ? "documents" : "document") + " only";
      String staticSubtitle = "Choose this option to publish the content as " +
             "it appears in RStudio.";
      pages.add(new PublishFilesPage(staticTitle, staticSubtitle, 
            RSConnectResources.INSTANCE.publishDocWithoutSource(), 
            input, asMultiple, true));
      return pages;
   }
}