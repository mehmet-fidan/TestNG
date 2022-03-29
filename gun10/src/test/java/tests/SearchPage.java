package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utils.ParentClass;

import java.util.List;


public class SearchPage extends ParentClass {


    @FindBy(css = "input[name='search']")
    public WebElement eSearchIpodByText;

    @FindBy(xpath = "//div[@class='caption']//a[contains(text(),'iPod')]")
    public List<WebElement> eIpods;

    @FindBy(xpath = "(//div[@class='col-sm-4']//h1)[2]")
    public WebElement eRandomlySelectedProductsName;

    @FindBy(id = "button-cart")
    public WebElement eAddProductToCart;

    @FindBy(id = "cart-total")
    public WebElement eGotoViewCart;

    @FindBy(xpath = "(//p[@class='text-right']//a)[1]")
    public WebElement eViewCart;

    @FindBy(xpath = "//div[@class='table-responsive']//a[contains(text(),'iPod')]")
    public List<WebElement> eProductsInCart;

    @FindBy(xpath = "//ul//li//h2")
    public WebElement ePriceOfAddedProduct;

    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr//td[@class='text-right']")
    public List<WebElement> eTotalPriceOfProductsInCart;

    @FindBy(css = "td[class='text-left']>div input[name*='quantity']")
    public List<WebElement> eQuantityOfProductsInCart;

    @FindBy(xpath = "//div[@class='pull-right']//a[text()='Checkout']")
    public WebElement eCheckOutFromCart;

    @FindBy(css = "input[value='existing']")
    public WebElement eExistingAddressSelection;

    @FindBy(id = "button-payment-address")
    public WebElement eContinueAddressToBuy;

    @FindBy(id = "button-shipping-address")
    public WebElement eContinueShipping;

    @FindBy(css = "textarea[name='comment']") //  div[class='panel-body'] p textarea[name='comment']
    public WebElement eCommentAndPreferredPayment;

    @FindBy(id = "button-shipping-method")
    public WebElement eDeliveryMethodContinue;

    @FindBy(css = "input[value='cod']")
    public WebElement ePaymentSelection;

    @FindBy(css = "input[name='agree']")
    public WebElement ePaymentMethodAgree;

    @FindBy(id = "button-payment-method")
    public WebElement eButtonPaymentMethod;

    @FindBy(id = "button-confirm")
    public WebElement eConfirmButton;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement eFinalizedOrderContinue;


    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void IpodSearchAndSelect(String textForSearch) {
        sendkeys(eSearchIpodByText, textForSearch + Keys.ENTER);
       // int randomIndex = (int) (Math.random() * eIpods.size());
        int randomIndex = random(eIpods.size());
        // System.out.println(randomIndex);
        clickTo(eIpods.get(randomIndex));
        String textOfRandomProduct = eRandomlySelectedProductsName.getText();
        String priceOfAddedProduct = ePriceOfAddedProduct.getText();
        //System.out.println(eRandomlySelectedProductsName.getText());
        clickTo(eAddProductToCart);
        clickTo(eGotoViewCart);
        clickTo(eViewCart);
        // String priceOfProductInCart=ePriceOfProductInCart.getText();
        // System.out.println(priceOfProductInCart);

        // System.out.println(eQuantityOfProductsInCart.getAttribute("value"));
         System.out.println("Price of added product is: "+priceOfAddedProduct);
        // int quantityOfProducts =Integer.parseInt(eQuantityOfProductsInCart.getAttribute("value"));
        int priceOfProductInt = Integer.parseInt(priceOfAddedProduct.replaceAll("[^0-9]", ""));


        // int totalPriceOfProductsInCart=Integer.parseInt(eTotalPriceOfProductsInCart.getText().replaceAll("[^0-9]",""));


        // System.out.println("---------------");

        //  System.out.println(eProductsInCart.size());

        textControl(textOfRandomProduct);

        //  priceControl(priceOfProductInt);
        // System.out.println("eQuantityOfProductsInCart size: "+eQuantityOfProductsInCart.size());
        // System.out.println("eTotalPriceOfProductsInCart size: "+eTotalPriceOfProductsInCart.size());
        priceControl(textOfRandomProduct, priceOfProductInt);
        clickTo(eCheckOutFromCart);
        clickTo(eExistingAddressSelection);
        clickTo(eContinueAddressToBuy);
        clickTo(eContinueShipping);
        sleep(2000);
        sendkeys(eCommentAndPreferredPayment, "I am ok");
        clickTo(eDeliveryMethodContinue);
        clickTo(ePaymentSelection);
        clickTo(ePaymentMethodAgree);
        clickTo(eButtonPaymentMethod);
        clickTo(eConfirmButton);
     //   clickTo(eFinalizedOrderContinue);

    }

    private int random(int size) {
        return (int)(Math.random()*size);
    }

    public void textControl(String text) {
        for (int i = 0; i < eProductsInCart.size(); i++) {
             System.out.println(i+".eProductsInCart: "+eProductsInCart.get(i).getText());
            System.out.println("-------------------");
            System.out.println("Text of random product is: " + text);
            if (eProductsInCart.get(i).getText().equals(text)) {
                System.out.println("The products are same");
                break;
            }
        }
    }

    public void priceControl(String text, int price) {
        int numberOfProducts;
        for (int i = 0; i < eQuantityOfProductsInCart.size(); i++) {
            for (int j = 0; j <= eTotalPriceOfProductsInCart.size(); j++) {
                if (eProductsInCart.get(i).getText().equals(text)) {
                    int totalPriceOfProductsInCart = Integer.parseInt(eTotalPriceOfProductsInCart.get(j).
                            getText().replaceAll("[^0-9]", ""));
                    numberOfProducts = Integer.parseInt(eQuantityOfProductsInCart.get(i).getAttribute("value"));
                    if (price * numberOfProducts == totalPriceOfProductsInCart) {
                        System.out.println(i + ". Quantity of products in cart is: " +
                                eQuantityOfProductsInCart.get(i).getAttribute("value"));
                        System.out.println("Total price of products in cart is:" + totalPriceOfProductsInCart);
                        System.out.println("The method is fine");
                        break;
                    }
                }
            }
        }
    }

    public void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
