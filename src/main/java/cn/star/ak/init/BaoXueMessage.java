package cn.star.ak.init;

import cn.star.ak.network.AKvaV;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record BaoXueMessage() {

    public static void encode(BaoXueMessage msg, FriendlyByteBuf buffer) {

    }

    public static BaoXueMessage decode(FriendlyByteBuf buffer) {
        return new BaoXueMessage();
    }

    public static void handle(BaoXueMessage msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer sender = ctx.get().getSender();
            LazyOptional<AKvaV.PlayerVariables> capability = sender.getCapability(
                    AKvaV.PLAYER_VARIABLES_CAPABILITY, null
            );
            capability.ifPresent(
                    capabilityA->{
                        if (capabilityA.mixin) {
                            capabilityA.baoxue = !capabilityA.baoxue;
                            capabilityA.syncPlayerVariables(sender);
                            sender.sendSystemMessage(
                                    (capabilityA.baoxue ?
                                            net.minecraft.network.chat.Component.translatable("message.ak.baoxue.on") :
                                            net.minecraft.network.chat.Component.translatable("message.ak.baoxue.off")
                                    )
                            );
                        }
                    }
            );
        });
        ctx.get().setPacketHandled(true);
    }}
