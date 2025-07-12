package com.viraps.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MinecraftServer.class})
public class ExampleMixin {
  @Inject(at = {@At("HEAD")}, method = {"loadWorld"})
  private void init(CallbackInfo info) {}
}


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\mixin\ExampleMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */