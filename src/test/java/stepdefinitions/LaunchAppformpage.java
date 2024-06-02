package stepdefinitions;

import

        DriverFactory.DriverInitialization;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.Launchpage;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class LaunchAppformpage extends DriverInitialization {


    Launchpage launchpage = new Launchpage(DriverInitialization.Passbrowser());

    public LaunchAppformpage() throws IOException, InvalidFormatException {
    }

    @Given("User is able to open the browser")
    public void userIsAbleToOpenTheBrowser() throws IOException {
        launchpage.OpenPage();

    }


    @And("user select mobilephone {string}")
    public void userSelectMobilephone(String brand) {
 launchpage.SelectPhoneBrand(brand);
    }

    @And("user add the order to cart")
    public void userAddTheOrderToCart() {
launchpage.addOrderTocart();
    }

    @And("Check order in cart")
    public void checkOrderInCart() {

launchpage.CheckOrderInCart();
    }

    @And("user Enter the details")
    public void userEnterTheDetails() throws InterruptedException {
 launchpage.EnterUserDetails();
    }

    @And("Completes the order placing")
    public void completesTheOrderPlacing() {
launchpage.CompletePlacinOrder();

    }


    @And("user Enter the custmer details from Excel {string} and {}")
    public void userEnterTheCustmerDetailsFromExcelAnd(String sheetName, Integer RowNumber ) throws IOException, InvalidFormatException {
launchpage.getCustomerDetailsFromExcel(sheetName,RowNumber);
        launchpage.CompletePlacinOrder();

//launchpage.errorMsgValidation();


    }

    @And("Verify Links")
    public void verifyLinks() throws IOException {

        launchpage.Verifylinks();
    }

    @And("user select mobilephone using map")
    public void userSelectMobilephoneUsingMap(DataTable dataTable) {
        List<Map<String,String>> listdata =dataTable.asMaps(String.class,String.class);





          }}
