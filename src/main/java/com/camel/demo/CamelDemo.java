package com.camel.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;



public class CamelDemo {
    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();

        // create a route
        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("file:data/output");
                }
            });
            // Start the context
            context.start();
            // Time for the files to get copied inside the folder
            Thread.sleep(5000);
            context.stop();

        } catch (Exception e) {
            System.out.println("Inside Exception : " + e);
        }
    }
}
