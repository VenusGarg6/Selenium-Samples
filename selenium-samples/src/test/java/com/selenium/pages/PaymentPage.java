package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	WebDriver driver;
	public PaymentPage(WebDriver pDriver) {
		this.driver=pDriver;
		PageFactory.initElements(pDriver,this);
	}
	
	@FindBy(xpath="//*[@id=\"learn-press-payment\"]/ul/li/label") WebElement payWithStripe;
	@FindBy(xpath="//*[@id=\"learn-press-checkout-place-order\"]") WebElement placeOrder;
	@FindBy(xpath="//*[@id=\"card-element\"]/div/iframe") WebElement iFrame;
	@FindBy(xpath="//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input") WebElement cardNumber;
	@FindBy(xpath="//*[@id=\"root\"]/form/div/div[2]/span[2]/span[1]/span/span/input") WebElement expiryDate;
	@FindBy(xpath="//*[@id=\"root\"]/form/div/div[2]/span[2]/span[2]/span/span/input") WebElement cvc;
	@FindBy(xpath="//*[@id=\"payment-button\"]") WebElement paymentBtn;
	
	public void paymentDone(String cardNum,String expDate,String cvv) {
		payWithStripe.click();
		System.out.println("PayWithStripe done!");
		placeOrder.submit();
		System.out.println("Place Order done!");
		driver.switchTo().frame(iFrame);
		System.out.println("Switch to iFrame done!");
		cardNumber.sendKeys(cardNum);
		System.out.println("Card number done!");
		expiryDate.sendKeys(expDate);
		System.out.println("Exp Date done!");
		cvc.sendKeys(cvv);
		System.out.println("CVV done!");
		driver.switchTo().defaultContent();
		System.out.println("Switch to default done!");
		paymentBtn.click();
		System.out.println("Payment button click done!");
	}
}
