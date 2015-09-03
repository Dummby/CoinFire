# CoinFire

Cryptocurrency utility with the following features:

(1) Select markets to pull data back from.
(2) Select from a choice of cryptocurrencies to pull data back for.
(3) Select fiat currency to pull data back for.
(3) CSV data exporting for use in/with analysis, trading, trading-algos, and bots.
(4) Currency conversion.

Data pulled from several API's (see com.coinfire.util.Constants)

Severe restrictions on the number of REST requests that can be made per minute have been placed on most API's - 
config.properties contains the current maximum allowed requests and can be modified accordingly.

Simple Install: download most recent .jar and run with Java 8 JVM.

We cannot be held responsible for any issues that might arise from the use of our product.
