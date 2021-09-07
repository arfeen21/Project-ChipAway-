package bunqMeTab;

import com.bunq.sdk.context.ApiContext;

import com.bunq.sdk.context.ApiEnvironmentType;
import com.bunq.sdk.context.BunqContext;
import com.bunq.sdk.http.BunqResponse;
import com.bunq.sdk.model.generated.endpoint.*;
import com.bunq.sdk.model.generated.object.Amount;


public class bunqmetest {


    public static void main(String[] args) {

        ApiContext apiContext = ApiContext.create(ApiEnvironmentType.PRODUCTION,
                "",
                "oauth-enes");
        apiContext.save("bunqoauth.conf");


//        BunqMeTabEntry bunqMeTabEntry = new BunqMeTabEntry();
//        bunqMeTabEntry.setAmountInquired(new Amount("10.00", "EUR"));
//        bunqMeTabEntry.setDescription("bla bla");
//        BunqResponse<Integer> bunqResponse = BunqMeTab.create(bunqMeTabEntry);
//        BunqMeTab bunqMeTab = BunqMeTab.get(bunqResponse.getValue()).getValue();
//        System.out.println(bunqMeTab.getBunqmeTabShareUrl());
//
//        if (bunqMeTab.getBunqmeTabShareUrl()!="0") System.exit(-1);

    }
}
