# Button

A button element that can be clicked to trigger a `@click` event.

```html
<button>
    <!--String Contents-->
</button>
```

## Attributes


| Attribute | Usage(s) | Description | Required |
|  :---:  |  :---:  |  :---:  | :---: |
| `x` | `x="0"` | The `x` position of the element. | ✔️ |
| `y` | `y="0"` | The `y` position of the element. | ✔️ |
| `width` | `width="0"` | The width of the element. | ✔️ |
| `height` | `y=""` | The height of the element.<br>Recommended to be `20` or visual bugs will occur. | ✔️ |
| `id` | `id=""` | The identifier of the element, allows the element to be fetched at a later date. | ❌ |
| `loc` | `loc="true"`<br>`loc="false"` | Whether or not the contents of the button is a i18n key.<br>Default false. | ❌ |
| `@render` | `@render="event_method:id"` | Event - When the element is shown to the user (render phase) | ❌ |
| `@click` | `@click="event_method:id"` | Event - When the button has been clicked. | ❌ |




## Valid Child Elements

- None