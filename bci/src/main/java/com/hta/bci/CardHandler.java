package com.hta.bci;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardHandler {
    private Map<String, String> banks;
    private Map<String, Integer> banksLogo;

    public CardHandler(){
        banks = new HashMap<String, String>();
        banksLogo = new HashMap<String, Integer>();

        banks.put("603799","بانک ملی ایران");
        banksLogo.put("بانک ملی ایران",R.drawable.bank_meli);
       
        banks.put("636214","بانک آینده");
        banksLogo.put("بانک آینده",R.drawable.bank_ayandeh);
       
        banks.put("589210","بانک سپه");
        banksLogo.put("بانک سپه",R.drawable.bank_sepah);

        banks.put("207177","بانک توسعه صادرات");
        banks.put("627648","بانک توسعه صادرات");
        banksLogo.put("بانک توسعه صادرات",R.drawable.bank_toseh_saderat_iran);

        banks.put("636949","بانک حکمت ایرانیان");
        banksLogo.put("بانک حکمت ایرانیان",R.drawable.bank_hekmat);

        banks.put("627961","بانک صنعت و معدن");
        banksLogo.put("بانک صنعت و معدن",R.drawable.bank_sanat_va_madan);

        banks.put("603770","بانک کشاورزی");
        banks.put("639217","بانک کشاورزی");
        banksLogo.put("بانک کشاورزی",R.drawable.bank_kashavarzi);

        banks.put("628023","بانک مسکن");
        banksLogo.put("بانک مسکن",R.drawable.bank_maskan);

        banks.put("627760","پست بانک ایران");
        banksLogo.put("پست بانک ایران",R.drawable.post_bank);

        banks.put("502908","بانک توسعه تعاون");
        banksLogo.put("بانک توسعه تعاون",R.drawable.bank_toseetaavon);

        banks.put("627412","بانک اقتصاد نوین");
        banksLogo.put("بانک اقتصاد نوین",R.drawable.bank_en);

        banks.put("639164","بانک پارسیان");
        banks.put("627884","بانک پارسیان");
        banks.put("627353","بانک پارسیان");
        banks.put("622106","بانک پارسیان");
        banksLogo.put("بانک پارسیان",R.drawable.bank_parsian);

        banks.put("502229","بانک پاسارگاد");
        banks.put("639347","بانک پاسارگاد");
        banksLogo.put("بانک پاسارگاد",R.drawable.bank_pasargad);

        banks.put("621986","بانک سامان");
        banksLogo.put("بانک سامان",R.drawable.bank_saman);

        banks.put("639346","بانک سینا");
        banksLogo.put("بانک سینا",R.drawable.bank_sina);

        banks.put("639607","بانک سرمایه");
        banksLogo.put("بانک سرمایه",R.drawable.bank_sarmaeh);

        banks.put("502806","بانک شهر");
        banksLogo.put("بانک شهر",R.drawable.bank_shahr);

        banks.put("502938","بانک دی");
        banksLogo.put("بانک دی",R.drawable.bank_day);

        banks.put("603769","بانک صادرات");
        banksLogo.put("بانک صادرات",R.drawable.bank_saderat_iran);

        banks.put("610433","بانک ملت");
        banks.put("991975","بانک ملت");
        banksLogo.put("بانک ملت",R.drawable.bank_melat);

        banks.put("627353","بانک تجارت");
        banksLogo.put("بانک تجارت",R.drawable.bank_tejart);

        banks.put("589463","بانک رفاه");
        banksLogo.put("بانک رفاه",R.drawable.bank_refah);

        banks.put("627381","بانک انصار");
        banksLogo.put("بانک انصار",R.drawable.bank_ansar);

        banks.put("639370","بانک مهر اقتصاد");
        banksLogo.put("بانک مهر اقتصاد",R.drawable.bank_mehreghtesad);

        banks.put("505785","بانک ایران زمین");
        banksLogo.put("بانک ایران زمین",R.drawable.bank_iran_zamin);

        banks.put("606373","بانک قرض الحسنه مهر ایران");
        banksLogo.put("بانک قرض الحسنه مهر ایران",R.drawable.bank_gharzalhasaeh_iran);

        banks.put("639599","بانک قوامین");
        banksLogo.put("بانک قوامین",R.drawable.bank_ghavamin);

        banks.put("502910","بانک کارآفرین");
        banks.put("627488","بانک کارآفرین");
        banksLogo.put("بانک کارآفرین",R.drawable.bank_karafarin);

        banks.put("505416","بانک گردشگری");
        banksLogo.put("بانک گردشگری",R.drawable.bank_gardeshgari);

        banks.put("636795","بانک مرکزی");
        banksLogo.put("بانک مرکزی",R.drawable.bank_markazi);

        banks.put("628157","موسسه اعتباری توسعه");
        banksLogo.put("موسسه اعتباری توسعه",R.drawable.moasseseh_tosee);

        banks.put("505801","موسسه اعتباری کوثر");
        banksLogo.put("موسسه اعتباری کوثر",R.drawable.moasseseh_kosar);
    }

    public boolean CardValidation(String cardNo){
        int nDigits = cardNo.length();
        if (nDigits < 16){
            return false;
        }
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {
            int d = cardNo.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;
            nSum += d / 10;
            nSum += d % 10;
            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }


    public String BankName(String cardNo, Context context){
        if(CardValidation(cardNo) == true){
            if(banks.containsKey(cardNo.substring(0,6))){
                String bank = (String)banks.get(cardNo.substring(0,6));
                return bank;
            }else {
                Toast.makeText(context,R.string.card_not_support,Toast.LENGTH_SHORT).show();
                return null;
            }

        }else {
            Toast.makeText(context,R.string.card_not_validate,Toast.LENGTH_SHORT).show();
            return null;
        }

    }


    public String BankNameForTextWatcher(String cardNo, Context context){
        if(banks.containsKey(cardNo.substring(0,6))){
            String bank = (String)banks.get(cardNo.substring(0,6));
            return bank;
        }else {
            Toast.makeText(context,R.string.card_not_support,Toast.LENGTH_SHORT).show();
            return null;
        }

    }

    public int BankLogo(String bankName, Context context){

        if(banksLogo.containsKey(bankName)){
            Integer logo = banksLogo.get(bankName);
            return logo;
        }else {
            Toast.makeText(context,R.string.bank_not_support,Toast.LENGTH_SHORT).show();
            return 0;
        }

    }


    public ArrayList<Integer> AllLogos(){
        ArrayList<Integer> images = new ArrayList<>();
        for (String key: banksLogo.keySet()) {
            images.add(banksLogo.get(key));
        }
        return images;
    }



}

