# Creating your first `.mcui` file.

MCUI files have a very similar syntax to XML.

See this example:

```xml
<Screen title="An Example" showTitle="false">
    <Label x="30" y="30" fixedWidth="190">This is an example of a MCGUI Screen, this can be shown using MinecraftClient.openScreen(Screen screen)</Label>
    <Button x="30" y="50" width="55" height="20" method="mcgui:test_method"> This is an example of a button. </Button>
</Screen>
```

All attributes must be surrounded in double quotes, with the root element being one of the following:

- Screen

Your `.mcui` files must be in your resources folder of your jar.
Preferably in `/resources/mcgui/` however you can place it anywhere.

But how do we register a `.mcui` file?

### Next Steps

- [Registering `.mcui` files.](/gs/registerfile.md)

