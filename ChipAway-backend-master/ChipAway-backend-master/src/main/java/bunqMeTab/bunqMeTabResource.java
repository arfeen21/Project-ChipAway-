//package bunqMeTab;
//
//import com.bunq.sdk.context.ApiContext;
//import com.bunq.sdk.context.BunqContext;
//import com.bunq.sdk.http.BunqResponse;
//import com.bunq.sdk.model.generated.endpoint.BunqMeTab;
//import com.bunq.sdk.model.generated.endpoint.BunqMeTabEntry;
//import com.bunq.sdk.model.generated.object.Amount;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//
//public class bunqMeTabResource {
//
//
//    @GetMapping(path = "/user/{userID}/monetary-account/{monetary_accountID}/bunqme-tab/{itemId}")
//    public ResponseEntity<String> createBunqmetab(@PathVariable int userID, @PathVariable String monetary_accountID, @PathVariable String itemId) {
//
//        ApiContext apiContext = ApiContext.restore("bunq.conf");
//        BunqContext.loadApiContext(apiContext);
//
//        BunqMeTabEntry bunqMeTabEntry = new BunqMeTabEntry();
//        bunqMeTabEntry.setAmountInquired(new Amount("10.00", "EUR"));
//        bunqMeTabEntry.setDescription("bla bla");
//        BunqResponse<Integer> bunqResponse = BunqMeTab.create(bunqMeTabEntry);
//        BunqMeTab bunqMeTab = BunqMeTab.get(bunqResponse.getValue()).getValue();
//        return ResponseEntity.ok(bunqMeTab.getBunqmeTabShareUrl());
//    }
//
//}
