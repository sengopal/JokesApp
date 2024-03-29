/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.jokes.application.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.jokes.lib.JokeBuilder;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.application.jokes.udacity.com",
    ownerName = "backend.application.jokes.udacity.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    //public MyBean sayHi(@Named("name") String name) {
    public MyBean getJoke(){
        String joke = JokeBuilder.get();
        MyBean mybean = new MyBean();
        mybean.setJoke(joke);
        return mybean;
    }

}
