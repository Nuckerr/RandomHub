# RandomHub
Randomise the lobby-server a player goes to when they join.

This plugin can either run on your bungeecord proxy or on your spigot servers. (The functionality will only appear on servers that it is installed on if you install it
on spigot)

## Features
- Randomhub on join
- Randomhub command
- Randomhub on kick
- Supports bungeecord
- Supports spigot
- Extremly customisable
- Always-lobby-one setting

## Config file
```yaml
hubs:
  - Hub-01
  - Hub-02
messages:
  hub-sent: "&aYou have been sent to %server_name%"
  unable-to-send: "&cUnable to send you to hub"
  permission-message: "&cYou dont have permission to do this"
  alo-updated: "&aAlways-lobby-one has been set to %status%"

```

## Commands
|Name|Description|Aliases|Permission|
|:-:|:----------:|:-----:|:--------:|
|`/hub`|Sends you to a random hub|`/lobby`, `/l`|*None*|
|`/alwayslobbyone`|Toggles your alo setting|`/alwayshubone`, `/aho`, `/alo`|`randomhub.alwayshubone`|
