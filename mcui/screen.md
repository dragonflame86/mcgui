# Screen

The base element for showing screens.

```html
<screen>
    <!-- Screen Contents here -->
</screen>
```

## Attributes

| Attribute | Usage(s) | Description | Required |
|  ---  |  ---  |  ---  | --- |
| `title` | `title=""` | The title of the screen, rendered at the top of the screen by default.<br>Can be hidden by using `showtitle`  | ✔️ |
| `showtitle` | `showtitle="false"`<br>`showtitle="true"` | A boolean option whether to render the title. | ❌ |
| `@render` | `@render="event_method:id"` | Event - When the screen is shown to the user (render phase) | ❌ |

## Valid Child Elements

- [label](/mcui/label.md)
- [button](/mcui/button.md)
- [separator](/mcui/separator.md)

