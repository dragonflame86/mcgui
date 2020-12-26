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
        File mcuiFile = FilesRegistry.fetch("example_mod:epic_example_file") // Fetch the .mcui file we made in https://mcgui.cf/#/gs/registerfile from the FilesRegistry
        UIDocument doc = MCUIParser.parse(mcuiFile, true) // Parse the file, and delete any cache. You can specify to keep cache by using false instead of true.
        this.addButton(new SpruceButtonWidget( // Add a button to the "Screen"/TitleScreen in the top right corner.
            Position.of(0, 12), // x=0 y=12
            150, // width=150
            20, // height=20
            new LiteralText("My crazy cool MCGUI"), // Whatever is on the button.
            btn -> this.client.openScreen(doc)).asVanilla()); // When the button is clicked, open our document.
    }
```

Great! You should get something similar to this when you click your button:

![](https://iili.io/KhMDua.png)

### Next Steps

- [Creating event methods.](/gs/eventmethods.md)

