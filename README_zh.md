# CustomWeaponAPI

---

[English](README.md) | [中文](README_zh.md)

---

用于快速在Bukkit/Spigot服务端中制作自定义武器的支持库

## 支持的自定义项目

合成表、物品名称及简介

## 如何使用

- Maven:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependency>
    <groupId>com.github.AFterNode</groupId>
    <artifactId>CustomWeaponAPI</artifactId>
    <version>0.1.0</version>
</dependency>
```

- Gradle
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
        implementation 'com.github.AFterNode:CustomWeaponAPI:0.1.0'
}
```
