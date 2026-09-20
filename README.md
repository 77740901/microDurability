# microDurability-unofficial

> **Unofficial 26.2 Fabric Port** — Based on [ReviversMC/microDurability](https://github.com/ReviversMC/microDurability), ported to Minecraft 26.2 (Fabric). Original authors: dzwdz & ReviversMC.

![Environment: client](https://img.shields.io/badge/environment-client-1976d2?style=flat)
![License: MPL-2.0](https://img.shields.io/badge/license-MPL--2.0-blue)

## What is this?

microDurability is a minimal durability viewer that shows the durability bars of your armor right above the hotbar, without wasting any space. It can also warn you when your tools or armor are about to break.

This is an unofficial community port for **Minecraft 26.2 (Fabric)**.

## Features

- Armor durability bars displayed above the hotbar
- Low durability warning for tools and armor (blinking effect)
- Highly configurable via Mod Menu + Cloth Config
- Compatible with Raised and Double Hotbar mods
- Minimal performance impact

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 26.2
2. Download the latest `.jar` from [Releases](https://github.com/77740901/microDurability/releases)
3. Place the `.jar` in your `mods` folder

## Dependencies

| Mod | Required |
|-----|----------|
| [Fabric Loader](https://fabricmc.net/use/) 0.19.3+ | Yes |
| [Cloth Config API](https://modrinth.com/mod/cloth-config) | Yes |
| [Mod Menu](https://modrinth.com/mod/modmenu) | Optional (for in-game config GUI) |

## Configuration

Config file: `.minecraft/config/microdurability.json5`

Or use **Mod Menu** → select `microDurability-unofficial 26.2 Compat` → click the config button to adjust settings in-game.

## Differences from the Original

- **Creative mode armor bar positioning**: The armor durability bars are shifted down in creative mode to avoid overlapping with the status text.
- **Tweakeroo FreeCamera compatibility**: When Tweakeroo's FreeCamera feature is enabled, all microDurability HUD elements (armor bars and durability warnings) are automatically hidden to prevent them from rendering while the camera is detached from the player. Supports Tweakeroo 0.29.0+.

## License

This project is licensed under **MPL-2.0**, except for the following modules which are licensed under **CC-BY-NC-SA-4.0**:

| Module | License |
|--------|---------|
| All modules except `microdurability-core` and `microdurability-dev-env-extras` | MPL-2.0 |
| `microdurability-core` | CC-BY-NC-SA-4.0 |
| `microdurability-dev-env-extras` | CC-BY-NC-SA-4.0 |

Original authors: dzwdz & ReviversMC. This is an unofficial community port.
