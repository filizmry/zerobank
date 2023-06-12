package com.zerobank.step_defs;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FindTransactions_stepDefs {
    AccountActivityPage accountActivityPage=new AccountActivityPage();
    FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
    @When("Tap on Find Transactions")
    public void tap_on_Find_Transactions() {
        accountActivityPage.tapOnFindTransactionButton();

    }

    @When("Send {string} keyword into description input box")
    public void send_keyword_into_description_input_box(String string) {
        BrowserUtils.sendKeys(findTransactionsPage.getDescriptionInputBox(),string);

    }

    @When("Tap on find button")
    public void tap_on_find_button() {
     findTransactionsPage.tapOnFindButton();
    }

    @Then("Verify that all description results contains {string}")
    public void verify_that_all_description_results_contains(String string) {
        List<String> listOfTexts = findTransactionsPage.getAllTextsFromDescriptions();

        /*boolean bool = true;
        for (String listOfText : listOfTexts) {
            if(!listOfText.contains(string)){
                bool = false;
                break;
            }
        }
        Assert.assertTrue(bool);*/
        //second way
        boolean b = listOfTexts.stream().allMatch(n -> n.contains(string));
        Assert.assertTrue(b);
    }
    }




