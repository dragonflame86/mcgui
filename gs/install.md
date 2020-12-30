# Installation

<p style="font-size: 20px; color: orange;">Warning - McGUI is currently in pre-release, it may contain bugs.. For more infomation, <a style=" color: red;" href="">join the discord for updates.</a></p>

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
modImplementation "cal.codes:mcgui:1.0.0-pr1"
include "cal.codes:mcgui:1.0.0-pr1"
```

Reload your gradle project and you should be ready.

### Next Steps

- [Creating a mcui file.](/gs/createfile.md)


