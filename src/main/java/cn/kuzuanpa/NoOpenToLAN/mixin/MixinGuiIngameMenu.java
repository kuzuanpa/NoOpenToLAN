package cn.kuzuanpa.NoOpenToLAN.mixin;

import cn.kuzuanpa.NoOpenToLAN.NoOpenToLAN;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngameMenu.class)
public abstract class MixinGuiIngameMenu extends GuiScreen {

    @Inject(method = "initGui",at = @At(value = "TAIL"))
    public void NoOpenToLAN$DisableLANButton(CallbackInfo ci){
        if(!NoOpenToLAN.removeButton && !NoOpenToLAN.disableButton)return;
        GuiButton LANGuiButton = NoOpenToLAN$findLanGuiButton();
        if(LANGuiButton != null && NoOpenToLAN.disableButton)LANGuiButton.enabled = false;
        if(LANGuiButton != null && NoOpenToLAN.removeButton)buttonList.remove(LANGuiButton);
    }
    @Unique
    public GuiButton NoOpenToLAN$findLanGuiButton(){
        for (Object o : buttonList) {
            if (!(o instanceof GuiButton)) continue;
            GuiButton button = (GuiButton) o;
            if (button.displayString.equals(I18n.format("menu.shareToLan"))) return button;
        }
        return null;
    }
}
