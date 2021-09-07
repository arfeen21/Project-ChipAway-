package com.example.chipawaybackend.demo.controllers;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.context.BunqContext;
import com.bunq.sdk.http.BunqResponse;
import com.bunq.sdk.model.generated.endpoint.BunqMeTab;
import com.bunq.sdk.model.generated.endpoint.BunqMeTabEntry;
import com.bunq.sdk.model.generated.object.Amount;
import com.example.chipawaybackend.demo.models.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TabController {

    @GetMapping("/user/bunq_me-tab/{value}/{description}")
    public Link createBunqMeTab(@PathVariable String value, @PathVariable String description) {

        ApiContext apiContext = ApiContext.restore("/home/ec2-user/bunq.conf");
        BunqContext.loadApiContext(apiContext);
        BunqMeTabEntry bunqMeTabEntry = new BunqMeTabEntry();
        bunqMeTabEntry.setAmountInquired(new Amount(value, "EUR"));
        bunqMeTabEntry.setDescription(description);
        BunqResponse<Integer> bunqResponse = BunqMeTab.create(bunqMeTabEntry);
        BunqMeTab bunqMeTab = BunqMeTab.get(bunqResponse.getValue()).getValue();
        return new Link(ResponseEntity.ok(bunqMeTab.getBunqmeTabShareUrl()));

    }
}
