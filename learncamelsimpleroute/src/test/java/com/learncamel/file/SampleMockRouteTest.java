package com.learncamel.file;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new SampleMockRoute();
    }

    @Test
    public void sampleMockRouteTest() throws InterruptedException {
        String input ="Hello";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(input);
        template.sendBody("direct:sampleInput","Hello");
        assertMockEndpointsSatisfied();
    }
}
