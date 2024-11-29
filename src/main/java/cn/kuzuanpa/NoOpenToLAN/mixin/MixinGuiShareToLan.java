package cn.kuzuanpa.NoOpenToLAN.mixin;

import cn.kuzuanpa.NoOpenToLAN.NoOpenToLAN;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiShareToLan.class)
public abstract class MixinGuiShareToLan extends GuiScreen {

    @Inject(method = "drawScreen",at = @At(value = "TAIL"))
    public void NoOpenToLAN$HintBuggy(CallbackInfo ci){
        this.drawCenteredString(this.fontRendererObj, NoOpenToLAN.hintMessage, this.width / 2, 140, 16777215);
    }

    @Inject(method = "actionPerformed",at = @At(value = "TAIL"))
    public void NoOpenToLAN$SendBuggyHint(GuiButton button, CallbackInfo ci){
        if (button.id == 101)this.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(NoOpenToLAN.hintMessage));
        if (button.id == 101)this.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(NoOpenToLAN.hintMessage2));
    }
}
