package com.arge.correosm.retrofit;

import com.arge.correosm.models.FCMBody;
import com.arge.correosm.models.FCMRResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMApi {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAlMVWRvI:APA91bG6PN2G6x3gNgZ2ZV54q15wVpD3UV73ia4lPdfmqyyrYuiHKQKbLAKrO2GAMllNTXENJ3tl26IfboamxtvkPS3oIi-Xcb_lV2XqPXqPckkEgIiBT76iBhei8VFoePH6MhzA-o_2"
    })
    @POST("fcm/send")
    Call<FCMRResponse> send(@Body FCMBody body);
}














