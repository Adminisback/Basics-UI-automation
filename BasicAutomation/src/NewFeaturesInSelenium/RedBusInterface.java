package NewFeaturesInSelenium;

public interface RedBusInterface {
//	clickOnFromCity // (//div[@class='sc-htoDjs kyqvCq'])[1]
//	fromInputXpath	// (//input[@class='sc-bxivhb hrsLPT'])[1]
// FromistofCities
    final String clickOnFromCity = "//div[@class='sc-jWBwVP hyJWPH']/div[1]/div/div/div/div";
	final String fromCityInput = "chop";
	final String expectedNameToShow = "chopda";
	final String toCityInput = "dange";
	final String expectedNameToShowForSelect = "Dange Chowk";
	final String monthName = "Jul 2024";
	final String fromInputXpath = "//div/div/div/div/div/input[@class='sc-bxivhb dsDRlf'] [@id='src']";
	final String fromListOfCities = "//ul/li/div/text";
	final String toInputXpath = "//div/div/div/div/div/input[@class='sc-bxivhb dsDRlf'] [@id='dest']";
	final String toListOfCities = "//ul/li/div/text[1]";
	final String months = "//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]";
	final String dateBlock = "//div[@class='DatePicker__MainBlock-sc-1kf43k8-1 hHKFiR']";
	final String clickOnNextDateMonth = "//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]";
	final String listOfDates = "//div[@class='DayTilesWrapper__RowWrap-sc-19pz9i8-1 fGGTDM']/span/div";
	final String searchBus = "//button[text()='SEARCH BUSES']";
	
}
