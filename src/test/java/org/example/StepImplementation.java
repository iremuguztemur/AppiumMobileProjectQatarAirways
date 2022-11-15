package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.example.base.BaseMethods;
import org.example.pages.ProductPage;
import org.openqa.selenium.By;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {

    BaseMethods baseMethods = new BaseMethods();
    ProductPage productPage = new ProductPage();

    @Step("Uygulamanın acildigi kontrol edilir.")
    public void appControl() throws InterruptedException {
        baseMethods.waitBySecond(2);
        ProductPage.isAppOpen("Travel Inspiration");

    }

    @Step("bildirimler aktif edilir")
    public void enableNotifications() throws InterruptedException {

        if (baseMethods.isElementDisplayed("com.m.qr:id/push_consent_decline")){
            baseMethods.clickElementById("com.m.qr:id/push_consent_decline");
            baseMethods.waitBySecond(3);
        }


    }

    @Step("Karsilama ekrani “Skip” secenegi ile gecilir")
    public void skipScreen() throws InterruptedException {
        baseMethods.waitBySecond(5);
        productPage.clickToSkip();
    }

    @Step("Alt menuden “Book” tabına gecis yapilir.")
    public void switchBookTab() {
        baseMethods.clickElementByXpath("//android.widget.FrameLayout[@content-desc=\"Book\"]/android.widget.FrameLayout/android.widget.ImageView");
    }

    @Step("Seyehat tipi olarak “one way” secilir.")
    public void oneWayTravel() throws InterruptedException {
        baseMethods.waitBySecond(2);
        baseMethods.clickElementByXpath("//android.widget.LinearLayout[@content-desc=\"One-way\"]/android.widget.TextView");
        baseMethods.waitBySecond(5);
    }

    @Step("Kalkis havaalanı olarak Abha(Arabic) secilir.")
    public void departureAirport() throws InterruptedException {
        baseMethods.waitBySecond(3);
        baseMethods.clickElementById("com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder");
        baseMethods.waitBySecond(3);
        baseMethods.clickElementById("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext");
        baseMethods.sendKeyElementById("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext","berlin");
        baseMethods.waitBySecond(3);
        baseMethods.clickElementByXpath("(//*[@resource-id=\'com.m.qr:id/rvmp_item_ond_selection_list_text_view_holder\'])[2]"); //berlin icin
        baseMethods.waitBySecond(1);
    }

    @Step("Varis havaalani olarak Bodrum(Turkiye) secilir.")
    public void destinationAirport() throws InterruptedException {
        baseMethods.waitBySecond(3);
        baseMethods.clickElementById("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_select_destination_text_view");
        baseMethods.waitBySecond(2);
        baseMethods.clickElementById("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext");
        baseMethods.sendKeyElementById("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext","istanbul");
        baseMethods.waitBySecond(2);
        //baseMethods.clickElementByXpath("(//*[@resource-id='com.m.qr:id/rvmp_item_ond_selection_list_text_view_holder'])[2]");//bodrum icin
        baseMethods.clickElementById("com.m.qr:id/rvmp_item_ond_selection_list_city_and_country"); //istanbul icin
        baseMethods.waitBySecond(2);
    }

    @Step("(Bugunun tarihi + 7 gun) olarak bir gidis tarihi secilir")
    public void selectDate() throws InterruptedException {
        baseMethods.waitBySecond(1);
        baseMethods.clickElementById("com.m.qr:id/rvmp_fragment_rtow_flight_selection_departure_date_holder");
        baseMethods.waitBySecond(2);
        baseMethods.clickElementByXpath("(//*[@resource-id=\"com.m.qr:id/rvmp_booking_calendar_day_text_view\"])[30]");
        baseMethods.waitBySecond(1);
        baseMethods.clickElementById("com.m.qr:id/fragment_calendar_confirm_button");
    }

    @Step("Arama butonuna tıklanir")
    public void clickSearchButton(){
        baseMethods.clickElementById("com.m.qr:id/rvmp_booking_search_flights_button");
    }

    @Step("Ucus secim ekraninin geldigi kontrol edilir")
    public void controlFlightScreen() throws InterruptedException {
        baseMethods.waitBySecond(3);
        productPage.controlElement(By.id("com.m.qr:id/booking_activity_conversational_message"),"Select your departure");
    }

    @Step("Rastgele bir ucus secilir.")
    public void chooseRandomFlight() throws InterruptedException {
        baseMethods.waitBySecond(3);
        productPage.chooseRandomElement(By.id("com.m.qr:id/rvmp_item_search_result_root_view"));
    }

    @Step("Economy class secenegine tiklanir")
    public void selectEconomyClass() throws InterruptedException {
        baseMethods.waitBySecond(3);
        productPage.selectEconomyClass();
    }

    @Step("Ucus secim ekranındaki ucus saati ile ucus detaylari ekranindaki ucus saati degeri ayni mi kontrol edilir")
    public void controlFlightInfo() throws InterruptedException {
        baseMethods.waitBySecond(3);
        productPage.controlFlyDetails();
    }

}
