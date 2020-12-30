package cal.codes.mcgui.mcui.events;

import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.elements.UIElement;
import org.jetbrains.annotations.Nullable;

public interface EventHook {
    public void invoke(@Nullable UIElement element, UIDocument document, @Nullable CheckboxEventArgs checkboxEventArgs);
}
