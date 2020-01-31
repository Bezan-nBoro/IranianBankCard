package com.hta.bankcardsiranian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.hta.bci.CardHandler;

public class MainActivity extends AppCompatActivity {

    private CardHandler card;
    private String cardNo = "6037697515178959";
    private String cardNoFake = "6037697515178958";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card = new CardHandler();


        // You can check validation card with card.CardValidation("Card Number")
        boolean statusCard = card.CardValidation(cardNo);
        Toast.makeText(getApplicationContext(),"Card1: " + statusCard,Toast.LENGTH_SHORT).show();

        statusCard = card.CardValidation(cardNoFake);
        Toast.makeText(getApplicationContext(),"Card2: " + statusCard,Toast.LENGTH_SHORT).show();


        //For Get Bank Name Or Bank Logo First Get Bank name With CardNo and get Bank logo with Bank name
        String bankName = card.BankName(cardNo,getApplicationContext());
        Toast.makeText(getApplicationContext(),"BankName: " + bankName,Toast.LENGTH_SHORT).show();


        // Get Logo with bank name
        Integer imgLogo = card.BankLogo(bankName,getApplicationContext());

        // Set logo on ImageView whit this command
        //Logo.setImageResource(imgLogo);

        //For textWathcher
        /*
        if(edtCard.getText().toString().length() >= 6){
                    String bankN = cardHanlder.BankNameForTextWatcher(edtCard.getText().toString(),getApplicationContext());
                    imgLogo.setImageResource(cardHanlder.BankLogo(bankN,getApplicationContext()));
                }else {
                    imgLogo.setImageDrawable(null);
                }
          }*/



    }
}
