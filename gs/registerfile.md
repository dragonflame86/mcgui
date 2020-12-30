# Registering `.mcui` files.

Registering `.mcui` files are quite simple.

First of all, add the following to your `onInitialize` method in your `ModInitializer`

This will grab a File from your resources folder. Make sure to change the `MyModInitializer` to the current class your `onInitialize` method is in.
Also make sure to change the `path/to/my/epic.mcui` to wherever you kept your mcui file.

`path/to/my/epic.mcui` would be turned into `/resources/path/to/my/epic.mcui` automatically.

```java
@Override
public void onInitialize() {
    File mcuiFile = ResourceHelper.getFileFromResource("path/to/my/epic.mcui", MyModInitializer.class) // Get the mcui file from resources.
}
```

Now you have a mcuiFile. Lets register it into the MCGUI DocumentRegistry for later use!

```java
@Override
public void onInitialize() {
    File mcuiFile = ResourceHelper.getFileFromResource("path/to/my/epic.mcui", MyModInitializer.class); // Get the mcui file from resources.
    UIDocument doc = MCUIParser.parse(mcuiFile, true); // Parse the file into a UIDocument, deleting any temporary files. You can specify false if you want to keep the temporary files created by the ResourceHelper.
    DocumentRegistry.register("mcgui:test_file", doc); // Register it for later use.
}
```

Great! You have loaded in a `.mcui` file!

### Next Steps

- [Rendering `.mcui` files.](/gs/renderfile.md)

