package com.github.velocity.bridge;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

import java.util.logging.Logger;

@Plugin(id="bungeevelocitybridge", name = "BungeeVelocityBridge", version = "1.0.0-SNAPSHOT", authors = {"Blyrex", "0utplay"})
public class BungeeVelocityBridgePlugin {

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public BungeeVelocityBridgePlugin(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    public ProxyServer getServer() {
        return this.server;
    }

    public Logger getLogger() {
        return this.logger;
    }
}