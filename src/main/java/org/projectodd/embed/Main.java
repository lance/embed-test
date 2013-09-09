package org.projectodd.embed;

import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.VertxFactory;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.eventbus.Message;

/**
 * Tests a shared event bus on localhost with embedded vert.x
 * From the project root, run ./bin/runtest.sh
 */
public class Main {

    public static void main(String[] args) {
        Vertx vertx = VertxFactory.newVertx("localhost");
        EventBus bus = vertx.eventBus();

        try {
            System.out.println("Sleeping for a little while to let vert.x do it's thing");
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }

        if (args.length > 0 && args[0].equals("publish")) {
            System.out.println("Publishing to embed-test.channel");
            bus.publish("embed-test.channel", "Hello world");
        } else {
            System.out.println("Registering handler for embed-test.channel");
            bus.registerHandler("embed-test.channel", new Handler<Message>() {
                @Override
                public void handle(Message message) {
                    System.out.println("Got: " + message.toString());
                }
            });
        }
    }

}
