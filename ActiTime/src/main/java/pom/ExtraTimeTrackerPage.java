package pom;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.webActionUtil;

public class ExtraTimeTrackerPage extends BasePage {
	@FindBy(id="addTaskButtonId")
	private WebElement newlink;
	
	@FindBy(xpath="//div[contains(@class,'customerSelector')]//div[@class='dropdownButton']")
	private WebElement selectcustomerdropdown;
	
	@FindBy(xpath="//div[contains(@style,'display: block')]//div[contains(@class,'itemRow ')]")
	private List<WebElement> customerdropdownoptionList;
	
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name']")
	private WebElement customerNameTextfield;
	
	@FindBy(xpath="//input[@placeholder='Enter Project Name']")
	private WebElement projectNameTextfield;
	
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement taskNameTextfiled;
	
	@FindBy(xpath="(//input[@placeholder='not needed'])[1]")
	private WebElement timeestimateTextfield;
	
	@FindBy(xpath="(//button[text()='set deadline'])[1]")
	private WebElement deadlineButton;
	
	@FindBy(xpath="(//div[@title='engineering'])[1]")
	private WebElement typeofworkButton;
	@FindBy(xpath="//div[text()='Create Tasks']")
	private WebElement createTasksLink;
	
	@FindBy(xpath="//div[contains(@style,'visibility: visible')]//button[contains(@class,'x-btn-text')]")
	private WebElement setdeadLinebutton;
	
	
	@FindBy(xpath="//a[@class='x-date-mp-next']")
	private WebElement nextYearIcon;

	
	
	@FindBy(xpath="//td[contains(@class,'x-date-mp-year')]")
	private List<WebElement> yearsList;
	@FindBy(xpath="//td[@class='x-date-middle']//button[contains(@class,'x-btn-text')]")
	private WebElement yearmonthdayButton;
	@FindBy(xpath="//td[contains(@class,'x-date-mp-month')]")
	private List<WebElement> monthList;
	@FindBy(xpath="//td[contains(@class,'x-date-mp-btns')]//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//div[contains(@style,'visibility: visible')]//td[contains(@class,'x-date-active')]")
	private List<WebElement> daysList;
	
	@FindBy(xpath="//div[contains(@class,'typeOfWorkEditorMenu')and contains(@style,'display: block')]//div[@class='typeLabel ellipsis']")
	private List<WebElement> typeOfWorkOptionList;
	
	@FindBy(xpath="//div[@class='task']")
	private List<WebElement> verifyTaskOptions;
	
	public List<WebElement> getVerifyTaskOptions() {
		return verifyTaskOptions;
	}

	public List<WebElement> getTypeOfWorkOptionList() {
		return typeOfWorkOptionList;
	}

	public List<WebElement> getYearsList() {
		return yearsList;
	}

	public WebElement getYearmonthdayButton() {
		return yearmonthdayButton;
	}

	public List<WebElement> getMonthList() {
		return monthList;
	}

	public WebElement getOkButton() {
		return okButton;
	}

	public List<WebElement> getDaysList() {
		return daysList;
	}

	public WebElement getNewlink() {
		return newlink;
	}

	public WebElement getSelectcustomerdropdown() {
		return selectcustomerdropdown;
	}

	public WebElement getCustomerNameTextfield() {
		return customerNameTextfield;
	}

	public WebElement getProjectNameTextfield() {
		return projectNameTextfield;
	}

	public List<WebElement> getCustomerdropdownoptionList() {
		return customerdropdownoptionList;
	}

	public WebElement getTaskNameTextfiled() {
		return taskNameTextfiled;
	}

	public WebElement getTimeestimateTextfield() {
		return timeestimateTextfield;
	}

	public WebElement getDeadlineButton() {
		return deadlineButton;
	}

	public WebElement getTypeofworkButton() {
		return typeofworkButton;
	}

	public WebElement getCreateTasksLink() {
		return createTasksLink;
	}
	public ExtraTimeTrackerPage(WebDriver driver, webActionUtil webactionutil) {
		super(driver, webactionutil);
		// TODO Auto-generated constructor stub
	}
	
	public void selectCustomerdropdown(String dropdown) {
		webactionutil.clickorJsClick(selectcustomerdropdown);
		for(WebElement ele:customerdropdownoptionList) {
			if(ele.getText().contains(dropdown)) {
				webactionutil.clickorJsClick(ele);
				break;
			}
		}
		
	}
	public void selectYear(String year) {
		outer:
		for(;;) {
		for(WebElement ele:yearsList) {
			if(ele.getText().contains(year)) {
				webactionutil.clickorJsClick(ele);;
				break outer;
			}
		}
		webactionutil.clickorJsClick(nextYearIcon);
		}
	}
	public void selectmonth(String month) {
	
		for(WebElement ele:monthList) {
			if(ele.getText().equalsIgnoreCase(month)) {
				webactionutil.clickorJsClick(ele);;
				break;
			}
		}
		
	}
	public void selectday(String day) {
		
		for(WebElement ele:daysList) {
			if(ele.getText().equals(day)) {
				webactionutil.clickorJsClick(ele);;
				break;
			}
		}
		
	}
	
	public WebElement getSetdeadLinebutton() {
		return setdeadLinebutton;
	}

	public WebElement getNextYearIcon() {
		return nextYearIcon;
	}

	public void selectMonth(String month) {
		for(WebElement ele:monthList) {
			if(ele.getText().contains(month)) {
				webactionutil.clickorJsClick(ele);;
				break;
			}
		}
	}
	public void selectDay(String day) {
		for(WebElement ele:daysList) {
			if(ele.getText().contains(day)) {
				webactionutil.clickorJsClick(ele);;
				break;
			}
		}
	}

	public void selectDeadLine(String day,String month,String year) {
		if(Integer.parseInt(year)>=LocalDateTime.now().getYear()) {
		webactionutil.clickorJsClick(deadlineButton);
		webactionutil.clickorJsClick(setdeadLinebutton);
		selectYear(year);
		selectMonth(month);
		webactionutil.clickorJsClick(okButton);
		selectday(day);
		}else {
			throw new IllegalArgumentException("sorry, you can't select previous year");
		}
		
		
	}
	public void typeOfWork(String typeWork) {
		webactionutil.clickorJsClick(typeofworkButton);
		for(WebElement ele:typeOfWorkOptionList) {
			if(ele.getText().contains(typeWork)) {
				webactionutil.clickorJsClick(ele);
				break;
			}
		}
		
	}

	public void CreatenewTask(String dropdown,String customerName,String projectName,String taskName,String timeEstimation,String day, String month,String year,String typeWork) {
		webactionutil.clickorJsClick(newlink);
		selectCustomerdropdown(dropdown);
		webactionutil.enterdata(customerNameTextfield, customerName);
		webactionutil.enterdata(projectNameTextfield, projectName);
		webactionutil.enterdata(taskNameTextfiled, taskName);
		webactionutil.enterdata(timeestimateTextfield, timeEstimation);
		selectDeadLine(day,month, year);
		typeOfWork(typeWork);
		webactionutil.clickorJsClick(createTasksLink);
		webactionutil.waitUtilUrl("dateSt");
	}
	
	public boolean verifyTheTaskCreated(String taskName) {
		for(WebElement ele:verifyTaskOptions) {
			if(ele.getText().contains(taskName)) {
				break;
			}
				
		}
		return true;
	}
	

}
