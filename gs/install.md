# Installation

<p style="font-size: 20px; color: red;">Warning - McGUI is not stable, please only use for experimentation. For more infomation, <a style=" color: red;" href="">join the discord for updates on when it becomes stable.</a></p>

First of all, add falsemaven to your repositories in `build.gradle`:

```groovy
repositories {
    maven {
        name = "falsemaven"
        url = 'https://maven.falseresync.ru/releases'
    }
}
```

Add the following dependencies to your dependencies in `build.gradle`:

```groovy
modImplementation "cal.codes:mcgui:0.1.0-SNAPSHOT"
include "cal.codes:mcgui:0.1.0-SNAPSHOT"
```

Reload your gradle project and you should be ready.

### Next Steps

- Creating a mcui file.
- Registering the file.
- Adding buttons with methods.

