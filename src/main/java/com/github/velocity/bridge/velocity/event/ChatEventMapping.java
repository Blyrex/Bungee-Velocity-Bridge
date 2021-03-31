package com.github.velocity.bridge.velocity.event;

import com.github.velocity.bridge.BungeeVelocityBridgePlugin;
import com.github.velocity.bridge.player.BridgeProxiedPlayer;
import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;

public final class ChatEventMapping extends EventMapping<PlayerChatEvent, ChatEvent> {
    public ChatEventMapping(BungeeVelocityBridgePlugin plugin) {
        super(plugin, PlayerChatEvent.class, ChatEvent.class, PostOrder.NORMAL);
    }

    @Override
    public ChatEvent prepare(PlayerChatEvent event) {
        ProxiedPlayer proxiedPlayer = BridgeProxiedPlayer.fromVelocity(super.plugin.getServer(), event.getPlayer());
        return new ChatEvent(proxiedPlayer, proxiedPlayer, event.getMessage());
    }

    @Override
    public void post(PlayerChatEvent event, ChatEvent chatEvent) {
        if (chatEvent.isCancelled()) {
            event.setResult(PlayerChatEvent.ChatResult.denied());
        }
    }
}