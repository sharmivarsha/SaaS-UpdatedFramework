package utils;

public class Constants {

	
	public static String username;
	public static String password;
	public static String url;
	public static String browser;
	public static String browser1;
	public static String Img_Loginpage;
	public static String Img_Welcomepage;
	public static String Img_AddTenant;
	public static String TenantName;
	public static String GroupName;
	public static String OrgPrefixValue;
	public static String DisplayName;
	public static String Address;
	public static String Dropdownvalues;
	public static String Zip;
	public static String Website;
	public static String Phone;
	public static String Email;
	public static String Img_TenantConfiguration;
	public static String UserFirstName;
	public static String UserLastName;
	public static String UserEmail;
	public static String UserPhone;
	public static String mailurl;
	public static String mailbrowser;
	public static String mailusername;
	public static String mailpassword;
	public static String adduserfirstname;
	public static String adduserlastname;
	public static String adduseremail;
	public static String adduserphone;
	public static String Img_AddUser;
	public static String labeldeployment;
	public static String releasetextbox;
	public static String descriptiontextbox;
	public static String releasebranch;
	public static String expectedcreatereleasesnapshot;
	public static String actualcreatereleasesnapshot;
	public static String expectedtenantsnapshot;
	public static String actualtenantsnapshot;
	
	 public static void initialize() {
	        username = PropertyManager.get("username");
	        password = PropertyManager.get("password");
	        url = PropertyManager.get("url");
	        browser = PropertyManager.get("browser");
	        browser1 = PropertyManager.get("browser1");
	        Img_Loginpage = PropertyManager.get("Img_Loginpage");
	        Img_Welcomepage = PropertyManager.get("Img_Welcomepage");
	        Img_AddTenant = PropertyManager.get("Img_AddTenant");
	        TenantName = PropertyManager.get("TenantName");
	        GroupName = PropertyManager.get("GroupName");
	        OrgPrefixValue = PropertyManager.get("OrgPrefixValue");
	        DisplayName = PropertyManager.get("DisplayName");
	        Address = PropertyManager.get("Address");
	        Dropdownvalues = PropertyManager.get("Dropdownvalues");
	        Zip = PropertyManager.get("Zip");
	        Website = PropertyManager.get("Website");
	        Phone = PropertyManager.get("Phone");
	        Email = PropertyManager.get("Email");
	        Img_TenantConfiguration = PropertyManager.get("Img_TenantConfiguration");
	        UserFirstName = PropertyManager.get("UserFirstName");
	        UserLastName = PropertyManager.get("UserLastName");
	        UserEmail = PropertyManager.get("UserEmail");
	        UserPhone = PropertyManager.get("UserPhone");
	        mailbrowser = PropertyManager.get("mailbrowser");
	        mailurl = PropertyManager.get("mailurl");
	        mailusername = PropertyManager.get("mailusername");
	        mailpassword = PropertyManager.get("mailpassword");
	        adduserfirstname = PropertyManager.get("adduserfirstname");
	        adduserlastname = PropertyManager.get("adduserlastname");
	        adduseremail = PropertyManager.get("adduseremail");
	        adduserphone = PropertyManager.get("adduserphone");
	        Img_AddUser = PropertyManager.get("Img_AddUser");
	        labeldeployment = PropertyManager.get("labeldeployment");
	        releasetextbox = PropertyManager.get("releasetextbox");
	        descriptiontextbox = PropertyManager.get("descriptiontextbox");
	        releasebranch = PropertyManager.get("releasebranch");
	        expectedcreatereleasesnapshot = PropertyManager.get("expectedcreatereleasesnapshot");
	        actualcreatereleasesnapshot = PropertyManager.get("actualcreatereleasesnapshot");
	        expectedtenantsnapshot = PropertyManager.get("expectedtenantsnapshot");
	        actualtenantsnapshot = PropertyManager.get("actualtenantsnapshot");
	    }
	}

	

