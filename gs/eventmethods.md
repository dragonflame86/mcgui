# Creating event methods.

Event methods are references to methods in your code.
Nearly all event methods start their attribute with `@`

## Example - Button click:

```html
<button x="20" y="20" width="120" height="20" @click="my_mod:button_click">
Press me!
</button>
```

When the button is clicked, McGUI will locate an event method with the ID `my_mod:button_click` and invoke it.
McGUI passes the UIDocument and the related element as arguments.

If it can't find the linked method, it will throw an error.

To register a event method, add the following to your `ModInitializer`'s `onInitialize()` method or any method that is ran during the `onInitialize` phase.

```java
MethodsRegistry.register("my_mod:button_click", (elm, doc) -> {
   System.out.println("I was clicked!")
});
```

## Example - Elements render:

```html
<screen title="test" @render="mymod:test_screen_render">
    <label x="20" y="20" fixedwidth="190" @render="mymod:test_label_render">This is a label, wow!</label> 
    <separator x="20" y="30" width="190" @render="mymod:test_separator_render"></separator>
</screen>
```

When the screen is rendered, the method linked to `mymod:test_screen_render` will be invoked, then label and separator will have their render events invoked.

The render events are invoked by their hierarcal place in the `.mcui` file, the top-most element is invoked, then the next, and so on.

