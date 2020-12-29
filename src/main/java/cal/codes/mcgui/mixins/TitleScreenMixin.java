///*
// * MCGui is licensed under the Mozilla Public License 2.0
// * Failure to follow this license will result in further action.
// */
//
//package cal.codes.mcgui.mixins;
//
//import cal.codes.mcgui.mcui.FilesRegistry;
//import cal.codes.mcgui.mcui.MCUIParser;
//import cal.codes.mcgui.mcui.elements.UIDocument;
//import me.lambdaurora.spruceui.Position;
//import me.lambdaurora.spruceui.widget.SpruceButtonWidget;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.client.gui.screen.TitleScreen;
//import net.minecraft.text.LiteralText;
//import net.minecraft.text.Text;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(TitleScreen.class)
//public class TitleScreenMixin extends Screen
//{
//    protected TitleScreenMixin(Text title)
//    {
//        super(title);
//    }
//
//    @Inject(method = "init", at = @At("RETURN"))
//    private void onInit(CallbackInfo ci)
//    {
//        try {
//            UIDocument doc = MCUIParser.parse(FilesRegistry.fetch("mcgui:test_file"), true);
//            this.addButton(new SpruceButtonWidget(Position.of(0, 12), 150, 20, new LiteralText("SpruceUI Test Menu"),
//                    btn -> this.client.openScreen(doc)).asVanilla());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
