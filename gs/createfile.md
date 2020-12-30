# Creating your first `.mcui` file.

MCUI files have a very similar syntax to XML.

See this example:

```html
<screen title="An Example" showtitle="false">
    <label x="30" y="30" fixedwidth="190">
        This is an example of a MCGUI Screen, this can be shown using
        MinecraftClient.openScreen(Screen screen)
    </label>
    <button x="30" y="50" width="55" height="20"> 
        This is an example of a button. 
    </button>
</screen>
```

For a list of all elements you can use, see the sidebar.

Your `.mcui` files must be in your resources folder of your jar.
Preferably in `/resources/mcgui/` however you can place it anywhere.

But how do we register a `.mcui` file?

### Next Steps

- [Registering `.mcui` files.](/gs/registerfile.md)

