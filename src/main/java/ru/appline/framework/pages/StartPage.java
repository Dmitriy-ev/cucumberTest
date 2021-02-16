package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StartPage extends BasePage {

	@FindBy(xpath = "//*[@class='kitt-cookie-warning__close']")
	WebElement coockeClose;

	@FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link') and @role='button']")
	List<WebElement> menuBaseList;

	@FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link_second')]")
	List<WebElement> menuSubList;

	/**
	 * Функция наведения мыши на любую менюшку
	 *
	 * @param nameBaseMenu - наименование меню
	 * @return StartPage - т.е. остаемся на этой странице
	 */
	public StartPage selectBaseMenu(String nameBaseMenu) {
		for (WebElement menuItem : menuBaseList) {
			if (menuItem.getText().equalsIgnoreCase(nameBaseMenu)) {
				action.moveToElement(menuItem).click().build().perform();
				return this;
			}
		}
		Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
		return this;
	}

	/**
	 * Функция клика на любое подменю
	 *
	 * @param nameSubMenu - наименование подменю
	 * @return StrahovaniePage - т.е. переходим на страницу {@link ru.appline.framework.pages.StrahovaniePage}
	 */
	public CreditCalculator selectSubMenu(String nameSubMenu) {
		for (WebElement menuItem : menuSubList) {
			if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
				wait.until(ExpectedConditions.visibilityOf(menuItem));
				action.moveToElement(menuItem).click().build().perform();
				return app.getCreditCalculator();
			}
		}
		Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
		return app.getCreditCalculator();
	}

//	/**
//	 * нажимаем на кнопку закрыть coocke
//	 */
//	public StartPage coocke() {
//		elementToBeVisible(coockeClose);
//		elementToBeClickable(coockeClose).click();
//		return this;
//
//	}

}