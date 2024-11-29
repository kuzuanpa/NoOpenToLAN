package cn.kuzuanpa.NoOpenToLAN.mixin;

import cn.kuzuanpa.NoOpenToLAN.NoOpenToLAN;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.world.WorldSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IntegratedServer.class)
public abstract class MixinServerShareToLAN {

    @Inject(method = "shareToLAN",at = @At(value = "HEAD"), cancellable = true)
    public void NoOpenToLAN$DisableLANButton(WorldSettings.GameType p_71206_1_, boolean p_71206_2_, CallbackInfoReturnable<String> cir){
        cir.setReturnValue(null);
    }
}
