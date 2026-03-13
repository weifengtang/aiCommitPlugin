# AI Commit Plugin

IntelliJ IDEA 插件，在 Commit 窗口添加 "✨ AI Commit" checkbox，勾选后自动在 commit message 末尾添加 `#AI commit#` 标识。

## 功能特性

- ✅ 在 Commit 窗口底部添加 "✨ AI Commit" checkbox
- ✅ 勾选后自动在 commit message 末尾添加 `#AI commit#` 标识
- ✅ 取消勾选后自动恢复原始 commit message
- ✅ 支持状态持久化（记住上次勾选状态）
- ✅ 避免重复添加标识

## 技术方案

- **语言**: Kotlin
- **IDE 版本**: IntelliJ IDEA 2023.2+
- **核心组件**:
  - `CheckinHandlerFactory` - 在 Commit 对话框中注入自定义组件
  - `RefreshableOnComponent` - 实现 checkbox UI 面板
  - `PersistentStateComponent` - 状态持久化（XML 存储）

## 使用步骤

### 1. 构建插件

```bash
./gradlew buildPlugin
```

构建产物位于: `build/distributions/aiCommitPlugin-1.0.0.zip`

### 2. 安装插件

1. 打开 IntelliJ IDEA
2. 进入 `File` → `Settings` → `Plugins`
3. 点击 `Install Plugin from Disk`
4. 选择 `build/distributions/aiCommitPlugin-1.0.0.zip`
5. 重启 IDEA

### 3. 使用

1. 打开 Git Commit 窗口（`Ctrl+K` 或 `Cmd+K`）
2. 在底部找到 "✨ AI Commit" checkbox
3. 勾选后，commit message 自动添加 `#AI commit#`
4. 取消勾选后，自动恢复原始 message

## 项目结构

```
src/main/
├── kotlin/com/example/aicommit/
│   ├── AICommitCheckInHandlerFactory.kt  # Handler 工厂
│   ├── AICommitCheckInHandler.kt         # Handler 实现
│   ├── AICommitPanel.kt                  # UI 面板 + checkbox 逻辑
│   └── AICommitSettings.kt               # 持久化设置
└── resources/META-INF/
    └── plugin.xml                        # 插件配置
```

## 开发命令

```bash
# 构建插件
./gradlew buildPlugin

# 运行测试实例
./gradlew runIde

# 验证插件
./gradlew verifyPlugin
```
