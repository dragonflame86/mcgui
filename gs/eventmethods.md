# Creating event methods.

Event methods are references to methods in your code.
Nearly all event methods start their attribute with `@`

## Example - Button click:

```html
<button x="20" y="20" width="120" height="20" @click="my_mod:button_click">
Press me!
</button>
```

When the button is clicked, McGUI will locate an event method with the ID `my_mod:button_click` and run it.

If it can't find it, it will throw an error.

To register a event method, add the following to your `ModInitializer`'s `onInitialize()` method.

```java
MethodsRegistry.register("my_mod:button_click", new MCUIEventMethod() {
    @Override
    public void invoke() {
        System.out.println("I was clicked!");
    }
});
```

