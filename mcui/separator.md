# Separator

A separator element, can have a optional set title. Can be used to declutter the layout of a screen.

```html
<separator>
</separator>
```

## Attributes

| Attribute | Usage(s) | Description | Required |
|  :---:  |  :---:  |  :---:  | :---: |
| `x` | `x="0"` | The `x` position of the element. | ✔️ |
| `y` | `y="0"` | The `y` position of the element. | ✔️ |
| `width` | `width="0"` | The length of the separator. | ✔️ |
| `title` | `title=""` | The title that should be used. | ❌ |
| `loc` | `loc="true"`<br>`loc="false"` | Whether or not the contents of the title attibutes is considered a i18n key.<br>Default false. | ❌ |
| `@render` | `@render="event_method:id"` | Event - When the element is shown to the user (render phase) | ❌ |