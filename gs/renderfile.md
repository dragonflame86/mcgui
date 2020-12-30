# Rendering `.mcui` files.

We've registered a file! Now lets show it to the player!

Lets say we want a button on our title screen. Lets make a small Mixin to do this!

*MCGUI includes [SpruceUI](https://github.com/LambdAurora/SpruceUI) automatically, no need to add it into your gradle dependencies.*

You can use the following mixin to hook onto the `onInit` method of the title screen.

```java
@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen
{
    protected TitleScreenMixin(Text title)
    {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void onInit(CallbackInfo ci)
    {
        
    }
}
```

Lets add the following into our `onInit` method:

```java
@Inject(method = "init", at = @At("RETURN"))
private void onInit(CallbackInfo ci)
{
    UIDocument doc = FilesRegistry.fetch("example_mod:epic_example_file"); // Fetch the document we registered in https://mcgui.cf/#/gs/registerfile
    SpruceButtonWidget widget = new SpruceButtonWidget( // Create a button in the top right corner.
        Position.of(0, 12), // x=0 y=12
        150, // width=150
        20, // height=20
        new LiteralText("My crazy cool MCGUI"), // Whatever is on the button.
        btn -> this.client.openScreen(doc)); // Open the UIDocument when the button is pressed.
    this.addButton(widget.asVanilla()); // Add the button to the title screen.
}
```

Great! You should get something similar to this when you click your button:

![](https://iili.io/KhMDua.png)

### Next Steps

- [Creating event methods.](/gs/eventmethods.md)

