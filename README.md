## XPopup
XPopup去除了jcenter，迁移到jitpack，使用jitpack.io进行依赖。

原先的XPopup项目地址：https://github.com/junixapp/XPopup


### **1、导入**
1.引入jitpack
项目根目录中的settings.gradle

 ```java
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io")}
    }
}
```

2.添加
Module的build.gradle

```gradle
implementation 'com.github.summersrest:XPopup-master:v1.0.0'
```
