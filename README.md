# IranianBankCard
===============
Check validation card and get bank name and bank logo

[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)


Gradle
------
Step 1. Add the JitPack repository to your build file 
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
dependencies {
	        implementation 'com.github.Bezan-nBoro:IranianBankCard:0.1.0'
	}
```

Maven
------
Step 1. Add the JitPack repository to your build file 
```
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
Step 2. Add the dependency
```
<dependency>
	    <groupId>com.github.Bezan-nBoro</groupId>
	    <artifactId>IranianBankCard</artifactId>
	    <version>Tag</version>
	</dependency>
```
Usage
-----
```java
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
        
        if(edtCard.getText().toString().length() >= 6){
                    String bankN = cardHanlder.BankNameForTextWatcher(edtCard.getText().toString(),getApplicationContext());
                    imgLogo.setImageResource(cardHanlder.BankLogo(bankN,getApplicationContext()));
                }else {
                    imgLogo.setImageDrawable(null);
                }
          }
    }
```

## Are you a developer?
> 1-Fork it!</br>
> 2-Create your feature branch: git checkout -b my-new-feature</br>
> 3-Commit your changes: git commit -am 'Add some feature'</br>
> 4-Push to the branch: git push origin my-new-feature</br>
> 5-Submit a pull request</br>



