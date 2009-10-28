package com.safi.workshop.serverview;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewUserSurveyPage extends WizardPage {

  private Button keepMeInformedButton;
  private Text phoneField;
  private Label contactPhoneNumberLabel;
  private Combo numEmpCombo;
  private Label numberOfEmployeesLabel;
  private Combo industryCombo;
  private Label whatIsYourLabel;
  private Combo astExpCombo;
  private Label howWouldYouLabel;
  private Combo astSysCombo;
  private Label whatAsteriskAdministrationLabel;
  private Combo howHeardCombo;
  private Label howDidYouLabel;
  private Combo countryCombo;
  private Label countryLabel;
  private Text companyNameField;
  private Label companyNameLabel;

  /**
   * Create the wizard
   */
  public NewUserSurveyPage() {
    super("wizardPage");
    setTitle("Optional Survey");
    setDescription("The following form helps us better understand the needs of the SafiSystems community and better prioritize our development plans");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    //
    setControl(container);

    companyNameLabel = new Label(container, SWT.NONE);
    companyNameLabel.setText("Company name:");

    companyNameField = new Text(container, SWT.BORDER);
    final GridData gd_companyNameField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    companyNameField.setLayoutData(gd_companyNameField);

    contactPhoneNumberLabel = new Label(container, SWT.NONE);
    contactPhoneNumberLabel.setText("Contact phone number:");

    phoneField = new Text(container, SWT.BORDER);
    final GridData gd_phoneField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    phoneField.setLayoutData(gd_phoneField);

    countryLabel = new Label(container, SWT.NONE);
    countryLabel.setText("Country:");

    countryCombo = new Combo(container, SWT.NONE);
    countryCombo.setItems(new String[] { "Please Select", "United States of America", "Canada",
        "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
        "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia",
        "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
        "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina",
        "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
        "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon",
        "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
        "Christmas Island", "Cocoa (Keeling) Islands", "Colombia", "Comoros", "Congo",
        "Cook Islands", "Costa Rica", "Cote Divoire", "Croatia (local name: Hrvatska)", "Cuba",
        "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
        "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
        "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France",
        "France, Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories",
        "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland",
        "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
        "Heard and Mc Donald Islands", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
        "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
        "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
        "Korea, Democratic Peoples Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan",
        "Lao Peoples Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia",
        "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia",
        "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
        "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico",
        "Micronesia, Federated States Of", "Moldova, Republic Of", "Monaco", "Mongolia",
        "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal",
        "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua",
        "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman",
        "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
        "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania",
        "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
        "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe",
        "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
        "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
        "South Georgia", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan",
        "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland",
        "Syrian Arab Republic", "Taiwan", "Tajikistan", "Tanzania, United Republic of", "Thailand",
        "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
        "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
        "United Kingdom", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
        "Vanuatu", "Vatican City State (Holy See)", "Venezuela", "Viet Nam",
        "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands",
        "Western Sahara", "Yemen", "Yugoslavia", "Zaire", "Zambia", "Zimbabwe" });
    final GridData gd_countryCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    countryCombo.setLayoutData(gd_countryCombo);
    countryCombo.select(0);

    howDidYouLabel = new Label(container, SWT.NONE);
    howDidYouLabel.setText("How did you hear about us?");

    howHeardCombo = new Combo(container, SWT.NONE);
    howHeardCombo.setItems(new String[] { "Please Select", "Search Engine", "News", "Blog",
        "Colleague", "Other " });
    final GridData gd_hearAboutUsCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    howHeardCombo.setLayoutData(gd_hearAboutUsCombo);
    howHeardCombo.select(0);

    whatAsteriskAdministrationLabel = new Label(container, SWT.NONE);
    whatAsteriskAdministrationLabel
        .setText("What Asterisk administration system\n(if any) are you currently using?");

    astSysCombo = new Combo(container, SWT.NONE);
    astSysCombo.setItems(new String[] { "Please Select", "AsteriskNOW", "trixbox CE",
        "trixbox PRO", "FreePBX", "None (Asterisk configuration files)", "Other" });
    final GridData gd_astSysCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    astSysCombo.setLayoutData(gd_astSysCombo);
    astSysCombo.select(0);

    howWouldYouLabel = new Label(container, SWT.NONE);
    howWouldYouLabel.setText("How would you describe your level\nof Asterisk experience?");

    astExpCombo = new Combo(container, SWT.NONE);
    astExpCombo.setItems(new String[] { "Please Select", "Beginner", "Moderate", "Advanced",
        "Just Looking", "None", "Other" });
    final GridData gd_astExpCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    astExpCombo.setLayoutData(gd_astExpCombo);
    astExpCombo.select(0);

    whatIsYourLabel = new Label(container, SWT.NONE);
    whatIsYourLabel.setText("What is your company's industry?");

    industryCombo = new Combo(container, SWT.NONE);
    industryCombo.setItems(new String[] { "Please Select", "Accommodation and Food Services",
        "Administrative", "Agriculture, Forestry, and Hunting",
        "Arts, Entertainment, and Recreation", "Construction", "Educational Services",
        "Finance and Insurance", "Health Care and Social Assistance", "Information Technology",
        "Manufacturing", "Mining", "Prof, Scientific, and Tech Services", "Public Administration",
        "Real Estate and Rental and Leasing", "Retail Trade", "Transportation and Warehousing",
        "Utilities", "Wholesale Trade", "Other" });
    final GridData gd_industryCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    industryCombo.setLayoutData(gd_industryCombo);
    industryCombo.select(0);

    numberOfEmployeesLabel = new Label(container, SWT.NONE);
    numberOfEmployeesLabel.setText("Number of Employees:");

    numEmpCombo = new Combo(container, SWT.NONE);
    numEmpCombo.setItems(new String[] { "Please Select", "1-10", "11-24", "25-49", "50-99",
        "100-499", "500+" });
    final GridData gd_numEmpCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    numEmpCombo.setLayoutData(gd_numEmpCombo);
    numEmpCombo.select(0);

    keepMeInformedButton = new Button(container, SWT.CHECK);
    keepMeInformedButton.setSelection(true);
    final GridData gd_keepMeInformedButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 2,
        1);
    keepMeInformedButton.setLayoutData(gd_keepMeInformedButton);
    keepMeInformedButton.setText("Keep me informed about SafiSystems news and product updates");
    setPageComplete(true);
  }

  public String getCompanyName() {
    return companyNameField.getText().trim();
  }

  public String getPhone() {
    return phoneField.getText().trim();
  }

  public String getCountry() {
    return countryCombo.getSelectionIndex() == 0 ? "" : countryCombo.getItem(countryCombo
        .getSelectionIndex());
  }

  public String getHowHeard() {
    return this.howHeardCombo.getSelectionIndex() == 0 ? "" : howHeardCombo.getItem(howHeardCombo
        .getSelectionIndex());
  }

  public String getAsteriskSystem() {
    return astSysCombo.getSelectionIndex() == 0 ? "" : astSysCombo.getItem(astSysCombo
        .getSelectionIndex());
  }

  public String getAsteriskExpertise() {
    return astExpCombo.getSelectionIndex() == 0 ? "" : astExpCombo.getItem(astExpCombo
        .getSelectionIndex());
  }

  public String getIndustry() {
    return industryCombo.getSelectionIndex() == 0 ? "" : industryCombo.getItem(industryCombo
        .getSelectionIndex());
  }

  public String getNumEmployees() {
    return numEmpCombo.getSelectionIndex() == 0 ? "" : numEmpCombo.getItem(numEmpCombo
        .getSelectionIndex());
  }

  public boolean keepMeInformed() {
    return keepMeInformedButton.getSelection();
  }

}
