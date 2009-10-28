package com.safi.workshop.serverview;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import com.safi.server.ws.Licrs;
import com.safi.server.ws.WorkshopServerLicensing;
import com.safi.server.ws.WorkshopServerLicensingService;
import com.safi.workshop.util.LicenseUtil;

public class NewUserWizard extends Wizard {

  private NewUserRequiredFieldsPage requiredPage;
  private NewUserSurveyPage surveyPage;

  public NewUserWizard() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void addPages() {
    getRequiredPage();
    getSurveyPage();
    super.addPages();
  }

  @Override
  public boolean performFinish() {
    if (!requiredPage.isPageComplete())
      return false;

    final WorkshopServerLicensing cfc = new WorkshopServerLicensingService()
        .getWorkshopServerLicensingCfc();
    try {
      Licrs result = cfc.signupUser(requiredPage.getUsername(), LicenseUtil.MD5(requiredPage
          .getPassword()), requiredPage.getEmail(), surveyPage.getCompanyName(), surveyPage
          .getCountry(), surveyPage.getHowHeard(), surveyPage.getAsteriskSystem(), surveyPage
          .getAsteriskExpertise(), surveyPage.getIndustry(), surveyPage.getNumEmployees(),
          surveyPage.keepMeInformed(), surveyPage.getPhone());
      System.err.println("the fucker has been signed? " + result.getResultMsg());

      if (!result.isResult()) {
        MessageDialog.openError(getShell(), "User Registration Error", "User registration failed: "
            + result.getResultMsg());
        return false;
      } else {
        MessageDialog
            .openInformation(
                getShell(),
                "Registration Successful",
                "Registration was successful!  You should receive a confirmation email shortly containing a confirmation token in the email body."
                    + "\nOnce the token has been entered into the 'Enter Trial Token' field on the license uploader tab and submitted you will be granted a trial license.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "User Registration Error", "User registration failed: "
          + e.getLocalizedMessage());
    }
    return false;

    // TODO Auto-generated method stub

  }

  private NewUserRequiredFieldsPage getRequiredPage() {
    if (requiredPage == null) {
      addPage(requiredPage = new NewUserRequiredFieldsPage());
    }
    return requiredPage;
  }

  private NewUserSurveyPage getSurveyPage() {
    if (surveyPage == null) {
      addPage(surveyPage = new NewUserSurveyPage());
    }
    return surveyPage;
  }
}
